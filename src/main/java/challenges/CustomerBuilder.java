package challenges;

public class CustomerBuilder {
    private String name;
    private int age;
    private String address;
    private Long customerId;

    public CustomerBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder setAge(final int age) {
        this.age = age;
        return this;
    }

    public CustomerBuilder setAddress(final String address) {
        this.address = address;
        return this;
    }

    public CustomerBuilder setCustomerId(final Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Customer build() {
        return new Customer(name, age, address, customerId);
    }
}
