package com.stl.java8.examples;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComputeIfAbsentMapCache {

    public static void main(String[] args) {
        ComputeIfAbsentMapCache clazz = new ComputeIfAbsentMapCache();
        clazz.doWork();
    }

    static void doWork() {
        Map<Integer, String> cacheMap = new HashMap<>();
        cacheMap.put(1, "Kasi");
        cacheMap.put(2, "Jim");
        cacheMap.put(3, "Grim");
        cacheMap.put(30, "Sat");
        cacheMap.put(5, "Sat");

        //cacheMap.entrySet().forEach( element  -> System.out.println(element.getValue()));
        cacheMap.forEach((key, value) -> {
            System.out.println("Key : " + key + " Value : " + value);
        });




        Function<Integer, String> mappingFunction = x -> " Raj " + x;
        String theName = "rambo";
        cacheMap.computeIfAbsent(4, mappingFunction);

        System.out.println("theName = " + cacheMap.size());


//        cacheMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(
//                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue),
//                        (x,y) -> (x, LinkedHashMap::new));

//        // 1st way
//        System.out.println( " 1 st way ");
//        cacheMap.forEach((key, value) -> {
//            System.out.println("Key : " + key + " Value : " + value);
//        });
//
//        // 2nd way
//        System.out.println( " 2 nd way ");
//        cacheMap.entrySet().forEach(entry -> {
//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
//        });
//
//        // is it stored in the map
//
//        String valueInMap = cacheMap.get(3);
//
//        mappingFunction.apply(5 );
//        System.out.println(" Applying the Function we get " +  mappingFunction.apply(5));
//
//
//
//
    }
}
