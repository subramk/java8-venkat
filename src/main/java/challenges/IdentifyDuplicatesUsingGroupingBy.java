package challenges;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


/*
  Identify duplicate element in Collection and then Perform some operation on the object as
  you iterate - good use of the GroupingBy clause ...


*/
public class IdentifyDuplicatesUsingGroupingBy {


  public Optional<Customer> identity(List<Customer> customerList){
    Optional<Customer> optCustomer= customerList
      .stream()
      .collect(groupingBy(Customer::getCustomerId))
      // Example of what is returned from above,
      // 100 , List<Customer> with id of 100
      // 101 , List<Customer> with id of 101
      //
      .entrySet()
      .stream()
      // we filter based on the List<Customer> 's size for dupicates.
      .filter(p -> p.getValue().size() > 1)
      .map(amendCustomerAddress())
      .collect(toList())
      .stream()
      .findFirst();


    return optCustomer;
  }

  private Function<Map.Entry<Long, List<Customer>>, Customer> amendCustomerAddress() {
    return entry -> concatAddress(entry.getValue());
  }



  private Customer concatAddress(List<Customer> custEntry){
    Function<List<Customer>, String> convert = null;

    String addresses =  custEntry
      .stream()
      .map( x ->   x.getAddress())
      .collect(Collectors.joining(" ")); // 1cWestern Road + " " + SourtherHounse

    custEntry.get(0).setAddress(addresses);
    // return the first Customer as it has the Amended Address String.
    return custEntry.get(0);
  }

}
