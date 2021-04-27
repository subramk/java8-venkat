package challenges;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitionByExample {

  public static void main(String[] args) {
    PartitionByExample ex = new PartitionByExample();
  }

  final Predicate<Person> seniorPerson = person -> person.getAge() > 60;
  //final Comparator<Person> ageComparator =  person.getAge();

  // simple partitioningBy

  //  Age  < 40 -  Adult
  //  Age  > 60  - Senior
  public Map<Boolean, List<Person>> getSeniors(final List<Person> persons){

    return persons.stream()
                  .collect(Collectors.partitioningBy(seniorPerson));
  }

  // partitioningBy + counting
  public Map<Boolean, Long> getTotalCountOfSeniors(final List<Person> persons){
    return persons.stream()
      .collect(Collectors.partitioningBy(seniorPerson, Collectors.counting()));
  }

  // partitioningBy + mapping
  public Map<Boolean, List<String>> getNamesOfSeniors(final List<Person> persons){
    return persons.stream()
      .collect(partitioningBy(seniorPerson, mapping( Person::getName, toList())));
  }


  // partitioningBy + collectingAndThen
  public Map<Boolean, List<Integer>> getAgesOfSeniors(final List<Person> persons){
    return persons.stream()
      .collect(partitioningBy(seniorPerson, mapping(Person::getAge, toList())));
  }
}
