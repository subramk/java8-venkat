package challenges;

import static java.util.Comparator.comparing;
import static java.util.OptionalInt.empty;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
  Examples from here : Venkat's talk on Collectors

        https://www.youtube.com/watch?v=pGroX3gmeP8

 */

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
  public Map<String, List<Integer>> nameOfPersonGroupedByTheirAges(List<Person> personList) {

    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, List<Integer>> namesOfPersonsMap = personList
      .stream()
      .collect(
        // Note : groupingBy comes in two overloaded ways.
        // 1) groupingBy(Function<T,R>) ==> Collector
        // 2) groupingBy(Function<T,R>, Collector) ==> Collector

        // mapping here is the downstream Collector.
        // mapping needs to be specified the Collector into which the mapping should
        // takes place ..( can be a List , set etc ) . List is the default .

        groupingBy(Person::getName,mapping(Person::getAge, toList())));

        // using Set Variant instead of List.
        //groupingBy(Person::getName,mapping(Person::getAge, toSet())));

    return namesOfPersonsMap;
  }

  // usage of groupingBy + counting()
  // the Map will hold the value like this....
  //  Ex :   bob - 3
  //         raj - 2
  //         John - 2
  public Map<String, Long> groupByPersonAndCountOfPersons(List<Person> personList) {
    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, Long> groupByPersonNameWithWithCount = personList
      .stream()
      .collect(
        // counting here is the downstream Collector.
        // COUNTING always returns a Long.
        groupingBy(Person::getName,counting()));

    return groupByPersonNameWithWithCount;
 }

  // groupingBy + collectingAndThen()
  public Map<String, Integer> groupByPersonNameWithPersonCountInteger(List<Person> personList) {

    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, Integer> groupByPersonNameWithWithIntCount = personList
      .stream()
      .collect(
        // use collectingAndThen to Collect and transform
        // the Long returned by counting() to a Integer value.
        groupingBy(Person::getName,collectingAndThen(counting(), val -> val.intValue() )));
        // The above can be more neater as below .
        //groupingBy(Person::getName,collectingAndThen(counting(), Long::intValue ));
    return groupByPersonNameWithWithIntCount;
  }



// Here ... the collectingAndThen that returns a Map<String, Holder> - Holder is like a DTO class that holds
// the value.

  public Map<String, Holder> groupByPersonNameAndValueAsObject(List<Person> personList) {

    // GroupingBy Id  && then we want to have only the List<String> names of the person
    Map<String, Holder> groupByPersonNameWithWithIntCount = personList
      .stream()
      .collect(
        // use collectingAndThen to Collect and transform
        // the Long returned by counting() to a Integer value.
        groupingBy(Person::getName,collectingAndThen(counting(),  val -> convertToHolder(val))));

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


  public void groupByPersonAgeAndNameLengthMoreThanFourLetters(final List<Person> personList){

        Map<Integer,List<String>> list  =   personList
              .stream()
              .collect(
                // Function , DownstreamCollector
                // filtering - Java 11 feature
                groupingBy(Person::getAge,
                    mapping(Person::getName, filtering(name -> name.length() > 4,toList()))));

  }

// teeing - Java 12 - Combining 2 Collectors ...TODO example .


// groupingBy + mapping + flatMapping
// flatMapping is done while the mapping operation is being peformed.
  public void groupingByUsingMappingAndFlatMapping(final List<Person> personList){

    Map<Integer, Set<String>>  uniqueLettersOfAllNames =
      personList
          .stream()
          .collect(
      // Function , DownstreamCollector
      // filtering - Java 11 feature
          groupingBy(Person::getAge,
              mapping(person -> person.getName().toUpperCase(),
                  flatMapping( name -> Stream.of(name.split("")),toSet()))));

}

/*
    Just a simple DTO object to hold values .
 */
  class Holder {

    Integer integerVal ;

    public Integer getIntegerVal() {
      return integerVal;
    }

    public void setIntegerVal(final Integer integerVal) {
      this.integerVal = integerVal;
    }


  }


  private Holder convertToHolder(Long inputValue){
    Holder holder = new Holder();
    holder.setIntegerVal(inputValue.intValue());
    return holder;


  }

}
