package com.java8.flatmap;

import com.java8.dto.Person;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.List.of;
import static java.util.stream.Collectors.*;
public class FlatMapExample_1 {

    public static List<Person> createPeople() {
        return of(
                new Person("Sara", 20),
                new Person("Sara", 22),
                new Person("Bob", 20),
                new Person("Paula", 32),
                new Person("Paul", 32),
                new Person("Jack", 2),
                new Person("Jack", 72),
                new Person("Jill", 12)
        );
    }

    public static void main(String[] args) {

        List<Person> people = createPeople();

         Map<String, List<Integer>> groupByNamesAndAges =
            people.stream().collect(
                        groupingBy( Person::getName,
                                    mapping(person -> person.getAge(),
                                            toList())));

        System.out.println("~~~~~~~~~~~ groupingByNameWithTheAges = " + groupByNamesAndAges);

        Map<String, List<Person>> groupingByName =
                people.stream()
                        .filter(Objects::nonNull)
                        .collect(groupingBy(person -> person.getName()));

        System.out.println("~~~~~~~~   byNameOnly = " + groupingByName);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // using .range().boxed on IntStream
        Supplier<Stream<Integer>> integerSupplier = () -> IntStream.range(1,20).boxed();

        java.util.Map<Boolean ,List<Integer>> partititionEvenNumbers =  integerSupplier.get().collect(partitioningBy(e -> e % 2 == 0));

        System.out.println(" Even Numbers = " + partititionEvenNumbers);
    }
}
