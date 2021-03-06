package challenges;

import static java.util.Comparator.comparing;
import static java.util.OptionalInt.empty;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class GroupingByAndMapping {

  public Map<Long, List<Person>> getPersonsGroupedById(List<Person> personList) {

    // simple GroupingBy
    Map<Long, List<Person>> personsGroupedById = personList
      .stream()
      .collect(groupingBy(Person::getId));

    return personsGroupedById;
  }

  public Map<Long, List<String>>  groupingByIdAndName(List<Person> personList) {

    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<Long, List<String>> namesOfPersonsMap = personList
      .stream()
      .collect(
        // mapping here is the downstream Collector, ie while we are Grouping by Id , we simultaneously
        // map eachPerson's name as the value of the Map.

        // groupingBy()  ALWAYS Groups the collection  as a List,
        // while in mappingBy() we need to tell the Collection to be mapped To.( ie toList(), toSet() etc ) .

        groupingBy(Person::getId, Collectors.mapping(person -> person.getName(), Collectors.toList()))
      );

    return namesOfPersonsMap;
  }

  // usage of groupingBy with mapping()
  public Map<String, List<Integer>> nameOfPersonGroupedByTheirAge(List<Person> personList) {

    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, List<Integer>> namesOfPersonsMap = personList
      .stream()
      .collect(
        // Note : groupingBy comes in two overloaded ways.
        // 1) groupingBy(Function<T,R>) ==> Collector
        // 2) groupingBy(Function<T,R>, Collector) ==> Collector

        // mapping here is the downstream Collector.
        groupingBy(Person::getName,mapping(Person::getAge, toList())));
        //groupingBy(Person::getName,mapping(Person::getAge, toSet()))); //using Set Variant instead of List.
    return namesOfPersonsMap;
  }

  // usage of groupingBy + counting()
  public Map<String, Long> groupByPersonNameWithCount(List<Person> personList) {
    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, Long> groupByPersonNameWithWithCount = personList
      .stream()
      .collect(
        // counting here is the downstream Collector.
        groupingBy(Person::getName,counting())); // COUNTING always returns a Long.
    return groupByPersonNameWithWithCount;
 }

  // groupingBy + collectingAndThen()
  public Map<String, Integer> groupByPersonNameWithCountAsInteger(List<Person> personList) {

    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, Integer> groupByPersonNameWithWithIntCount = personList
      .stream()
      .collect(
        // use collectingAndThen to Collect and transform
        // the Long returned by counting() to a Integer value.
        groupingBy(Person::getName,collectingAndThen(counting(), val -> val.intValue() )));
        // can be more neater as below .
        //groupingBy(Person::getName,collectingAndThen(counting(), Long::intValue ));

    return groupByPersonNameWithWithIntCount;
  }

  // usage of maxBy - Get the Oldest person in the group.

  public String   getNameOfOldestPersonName(List<Person> personList) {

    // maxBy,minBy Return the  object that we are comparing on . In this case it is Person.

    Optional<Person> p1 = personList.stream().collect( maxBy(comparing(Person::getAge)));
    Optional<Person> p2 = personList.stream().collect( minBy(comparing(Person::getAge)));

    return  personList.stream().collect(
                                        collectingAndThen(
                                            maxBy(comparing(Person::getAge)),
                                            person -> person.map(Person::getName).orElse(""))
                                        );


  }


  // collectingAndThen
  public Map<String, Integer> csvOfPersonNames(List<Person> personList) {

    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, Integer> groupByPersonNameWithWithIntCount = personList
      .stream()
      .collect(
        // use collectingAndThen to Collect and Transform the Long returned by counting() to a Integer value.
        // counting() is the downstream Collector
        // val -> val.intValue() is the finisher .... with signature Function<R,RR> finisher
        groupingBy(Person::getName,collectingAndThen(counting(), val -> val.intValue() )));
    // can be more neater as below .
    //groupingBy(Person::getName,collectingAndThen(counting(), Long::intValue ));

    return groupByPersonNameWithWithIntCount;
  }

  public Optional<Person> oldestPersonInTheGroup(List<Person> personList){

       Optional<Person> oldestPerson =  personList.stream()
          .collect(maxBy(comparing(Person::getAge)));

       return oldestPerson.isPresent() ? oldestPerson : Optional.empty();
  }




}
