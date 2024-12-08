package com.java8.flatmap;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeMapExampleClass {

    public static void main(String[] args) {

        MergeMapExampleClass tt = new MergeMapExampleClass();
        tt.doWork();


    }

    private static void doWork() {

        Map<String,Employee> map1  = new HashMap<>();
        Map<String,Employee> map2  = new HashMap<>();



       // map1.put("1", )


//        List<String> ccc = Arrays.asList("1","2");
//
//        Map<Long,String>  mp = new HashMap<>();
//        mp.put(1L,"kasi");
//
//
//                List<Map<Long,String>> ddd = Arrays.asList(mp);



        Map<String, Employee> result = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        //(value1, value2) -> new Employee("1","2"))); // If keys are duplicate
                        (v1, v2) -> new Employee(v1.getName(), v2.getCompany()))); // If keys are duplicate


    }
}
