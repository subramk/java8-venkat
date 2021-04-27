package challenges;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class PartitionByExampleTest {

  final List<Person> personsList = new ArrayList<>();
  private PartitionByExample partitionByExample ;

  @BeforeEach
  public void data(){

    Person p1  =  new PersonBuilder().setId(100L).setAge(49).setName("Kasi").build();
    Person p2  =  new PersonBuilder().setId(200L).setAge(39).setName("Balaji").build();

    // duplicate with Age = 44;
    Person p3  =  new PersonBuilder().setId(300L).setAge(44).setName("Anez").build();
    Person p6  =  new PersonBuilder().setId(300L).setAge(44).setName("SouthwestSingam").build();
    Person p7  =  new PersonBuilder().setId(300L).setAge(44).setName("Reshma").build();
    // duplicate with Age=35;
    Person p4  =  new PersonBuilder().setId(400L).setAge(35).setName("Ilango").build();
    Person p5  =  new PersonBuilder().setId(400L).setAge(35).setName("VertivelThambi").build();
    Person p8  =  new PersonBuilder().setId(400L).setAge(35).setName("Satishhhhessssssssshuuuu!!!").build();

    // Seniors
    Person p9  =   new PersonBuilder().setId(400L).setAge(67).setName("Rajini").build();
    Person p10  =  new PersonBuilder().setId(400L).setAge(62).setName("Kamal!!!").build();

    final List<Person> personsList = new ArrayList<>();
          personsList.add(p1);
          personsList.add(p2);
          personsList.add(p3);
          personsList.add(p4);
          personsList.add(p5);
          personsList.add(p6);
          personsList.add(p7);
          personsList.add(p8);
          personsList.add(p9);
          personsList.add(p10);
  }

  @Test
  public void dummy(){
    Assert.assertTrue(true);
  }

  @Test
  @DisplayName("Retrieve Senior People from the list of Persons")
  public void shouldReturnSeniorPersonsInTheList(){
    partitionByExample = new PartitionByExample();
    assertThat(partitionByExample.getSeniors(personsList),is(2));
  }
}
