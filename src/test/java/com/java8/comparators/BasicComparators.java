package com.java8.comparators;

import static junit.framework.TestCase.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class BasicComparators {


  @Test
  public void testBasics() {

    Comparator<String>  caseSensitiveOrderingComparator = String::compareTo;

    assertTrue( caseSensitiveOrderingComparator.compare("a", "z") <  0 );
    assertTrue( caseSensitiveOrderingComparator.compare("a", "a") ==  0 );
    assertTrue( caseSensitiveOrderingComparator.compare("z", "a") > 0 );


    List<String> stringsList = Arrays.asList( "ccc" , "bb" , "eeeee", "a", "dddd") ;

    Set treeSet = new TreeSet(caseSensitiveOrderingComparator);
    treeSet.addAll(stringsList);





  }
}
