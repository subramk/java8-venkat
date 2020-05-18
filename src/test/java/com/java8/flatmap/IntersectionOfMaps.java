package com.java8.flatmap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static junit.framework.TestCase.assertTrue;

/***
 *                      Problem Statement
 *
 *   // Compare Map A and Map B .  Get the Keys of MapB When the values of both Maps are equal .
 *
 */

public class IntersectionOfMaps {

  private Map<Integer,String>  mapA = new HashMap();
  private Map<Integer,String>  mapB = new HashMap();

  @BeforeEach
   void setupData(){
    mapA.put(1,"a");
    mapA.put(2,"b");
    mapA.put(3,"c");

    mapB.put(5,"a");
    mapB.put(6,"d");
    mapB.put(7,"c");

  }

  // Compare Map A and Map B .
  // Get the Keys of MapB where the values of both Maps are equal .
  // In above example , result will be 5,7

  @Test
   void testUsingStreamsApi_Solution_One() {

    /*
      for every Key in Map B
        - get all the keys of mapA and then check if there are any match between  mapB.key and mapA.key

      But if Map is huge size say 15000 size in both mapA and mapB  , then this process will repeat 15000 x 15000  to traverse through both the map collections .
      Making it a 0(N) sqaured search .

      Important : Having a stream within another stream is like a nested loop and it will be a N Squared - // Hence it is ineffective as it is - O(N) squared time

     */
    Set<Integer> keysInMapB = mapB.keySet()
                              .stream()
                              .filter( keyB -> mapA.keySet().stream().filter(keyA -> mapA.get(keyA).equals(mapB.get(keyB))).count() > 0).collect(toSet());

    System.out.println(keysInMapB) ;

    assertTrue(keysInMapB.size() == 2 );
    assertTrue(keysInMapB.containsAll(asList(5,7)) );

  }

  @Test
  // Neater solution than Solution 1 , but it is still O(N) squared time becuase , when we do a mapA.values().contains() on line  85,it does a linear search of ALL  the values of mapA with a single
  // value of map B - and this gets repeated for all the elements in Map B .

   void testUsingStreamsApi_Solution_Two() {


    Set<Integer> keysInMapB = mapB.entrySet()
      .stream()
      .filter( mapB_entry -> mapA.values().contains(mapB_entry.getValue()))
      .map(Map.Entry::getKey)
      .collect(toSet());

    System.out.println(keysInMapB) ;

    assertTrue(keysInMapB.size() == 2 );
    assertTrue(keysInMapB.containsAll(asList(5,7)) );

  }

  @Test
  // Optmized solution - extract all the values of Map A into a Set and then use it . This will move the operation from O(N squared) time to O(N) linear  time.
   void testOptimizedUsingStreamsApi_Solution_Three() {

    final Set<Integer> mapA_Values = new HashSet(mapA.values());

    final Set<Integer> keysInMapB = mapB.entrySet()
      .stream()
      .filter( mapB_entry -> mapA_Values.contains(mapB_entry.getValue()))
      .map(Map.Entry::getKey)
      .collect(toSet());

    assertTrue(keysInMapB.size() == 2 );
    assertTrue(keysInMapB.containsAll(asList(5,7)) );


  }

  @Test
  // Best solution is not using Streams but the .retainAll method in maps which is used in Intersection of Maps .
   void test_Solution_Using_RetainAll_in_Maps() {

    final Set<Integer> mapA_Values = new HashSet(mapA.values());
    final Map<Integer,String> mapB_copy = new HashMap<>(mapB);

    // make a copy of map B as we are going to mutate it when we do the intersection .
    mapB_copy.values().retainAll(mapA_Values);

    final Set<Integer> keysInMapB =  mapB_copy.keySet();

    assertTrue(keysInMapB.size() == 2 );
    assertTrue(keysInMapB.containsAll(asList(5,7)) );

  }


}
