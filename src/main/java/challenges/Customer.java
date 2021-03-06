package challenges;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
  String name;
  int age;
  String address ;
  Long customerId;

  private Customer() {
  }

  Customer(String name, int age, String address, Long customerId) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.customerId = customerId;
  }


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
