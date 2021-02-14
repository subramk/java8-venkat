package challenges;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;

public class IdentifyDuplicateCustomerAndConcatenateAddresses {

  @Test
  public void duplicateAddressShouldHaveTheirAddressAppended() {

    Customer c1 = new Customer();
    c1.setCustomerId(100L);
    c1.setName("kasi");
    c1.setAge(44);
    c1.setAddress("1cWesternRoad");

    Customer c3 = new Customer();
    c3.setCustomerId(100L);
    c3.setName("KasiDuplicate");
    c3.setAge(42);
    c3.setAddress("SouthernHouseCroydon");

    Customer c2 = new Customer();
    c2.setCustomerId(200L);
    c2.setName("Raj");
    c2.setAge(42);
    c2.setAddress("11 JeffsRoad");

    List<Customer> allCustomers = new ArrayList<>();
    allCustomers.add(c1);
    allCustomers.add(c2);
    allCustomers.add(c3);

    Set<Customer> uniqueCustomers = allCustomers.stream().distinct().collect(toSet());

    List<Customer> custs = uniqueCustomers.stream()
      .filter(Objects::nonNull)
      .collect(toList());

    Optional<Customer> optCustomer= allCustomers
      .stream()
      .collect(groupingBy(Customer::getCustomerId))
      .entrySet()
      .stream()
      .filter(p -> p.getValue().size() > 1) // list of Customers having Id > 1
      .map(entry -> concatAddress(entry.getValue()) ) //TODO Move this logic to  Function<T,R>  or a Supplier<T>
      .collect(toList())
      .stream()
      .findFirst();


    if(optCustomer.isPresent()){
      Customer optCust = optCustomer.get();
      assertThat(optCust.getAddress(), is("1cWesternRoad SouthernHouseCroydon"));
    }
  }

  private Customer concatAddress(List<Customer> custEntry){
    Function<List<Customer>, String> convert = null;

    String addresses =  custEntry
      .stream()
      .map( x ->   x.getAddress())
      .collect(Collectors.joining(" "));

    custEntry.get(0).setAddress(addresses);
    return custEntry.get(0);
  }



  // A simple Customer DTO for poc purpose .. TODO move out to separate class later.
  class Customer implements Serializable {
    String name;
    int age;
    String address ;
    Long customerId;

    public String getName() {
      return name;
    }

    public void setName(final String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(final int age) {
      this.age = age;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(final String address) {
      this.address = address;
    }

    public Long getCustomerId() {
      return customerId;
    }

    public void setCustomerId(final Long customerId) {
      this.customerId = customerId;
    }


    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Customer customer = (Customer) o;
      return customerId.equals(customer.customerId);
    }

    @Override
    public int hashCode() {
      return Objects.hash(customerId);
    }
  }


}
