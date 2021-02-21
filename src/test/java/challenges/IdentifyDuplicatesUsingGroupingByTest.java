package challenges;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class IdentifyDuplicatesUsingGroupingByTest {

  private IdentifyDuplicatesUsingGroupingBy identifyDuplicatesUsingGroupingBy;

  @Test
  @DisplayName("Duplicate Customers Should have their Address Field Merged as part of the First Customer's address")
  public void duplicateAddressShouldHaveTheirAddressFieldMerged() {

    identifyDuplicatesUsingGroupingBy = new IdentifyDuplicatesUsingGroupingBy();

    Customer c1  =  new CustomerBuilder().setAddress("1cWesternRoad").setAge(44).setName("kasi").setCustomerId(100L).build();
    Customer c2  =  new CustomerBuilder().setAddress("SouthernHouseCroydon").setAge(42).setName("KasiDuplicate").setCustomerId(200L).build();
    Customer c3  =  new CustomerBuilder().setAddress("11 JeffsRoad").setAge(42).setName("Raj").setCustomerId(200L).build();

    List<Customer> allCustomers = new ArrayList<>();
    allCustomers.add(c1);
    allCustomers.add(c2);
    allCustomers.add(c3);

    Set<Customer> uniqueCustomers = allCustomers.stream().distinct().collect(toSet());

    List<Customer> custs = uniqueCustomers.stream()
      .filter(Objects::nonNull)
      .collect(toList());

    Optional<Customer> optCustomer  = identifyDuplicatesUsingGroupingBy.identity(custs);

    if(optCustomer.isPresent()){
      Customer optCust = optCustomer.get();
      assertThat(optCust.getAddress(), is("1cWesternRoad SouthernHouseCroydon"));
    }
  }
}
