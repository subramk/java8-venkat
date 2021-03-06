package challenges;

public class PersonBuilder {
    private Long id;
    private String name;
    private int age;

    public PersonBuilder setId(final Long id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(final int age) {
        this.age = age;
        return this;
    }

    public Person build() {
        return new Person(id, name, age);
    }
}
