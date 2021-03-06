package challenges;

public class Person {

  private Long id;
  private String name;
  private int age;

  public Person(final Long id , final String name, final int age) {
    this.name = name;
    this.age = age;
    this.id = id ;
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

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }






}
