package certification;

import java.io.Serializable;

public class Animal implements Serializable {

  private String name ;
  private int age ;

  private char type ;

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

  public char getType() {
    return type;
  }

  public void setType(final char type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Animal Class toString method ......{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", type=" + type +
      '}';
  }
}
