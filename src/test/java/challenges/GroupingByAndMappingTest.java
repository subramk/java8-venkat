package challenges;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class GroupingByAndMappingTest {

  GroupingByAndMapping groupingByAndMapping;
  List<Person> personsList = new ArrayList<>();

  @Test
  @DisplayName("Duplicate Customers being Grouped based on their Id")
  public void duplicatePersonsGroupedBasedOnId() {

    groupingByAndMapping = new GroupingByAndMapping();

    Person p1  =  new PersonBuilder().setId(100L).setAge(49).setName("Kasi").build();
    Person p2  =  new PersonBuilder().setId(200L).setAge(39).setName("Satish").build();

    // duplicates
    Person p3  =  new PersonBuilder().setId(300L).setAge(44).setName("Anez").build();
    Person p6  =  new PersonBuilder().setId(300L).setAge(44).setName("SouthwestSingam").build();
    Person p7  =  new PersonBuilder().setId(300L).setAge(44).setName("Reshma").build();

    // duplicates
    Person p4  =  new PersonBuilder().setId(400L).setAge(35).setName("Ilango").build();
    Person p5  =  new PersonBuilder().setId(400L).setAge(35).setName("VertivelThambi").build();
    Person p8  =  new PersonBuilder().setId(400L).setAge(35).setName("Satishhhhessssssssshuuuu!!!").build();

    List<Person> personsList = new ArrayList<>();
    personsList.add(p1);
    personsList.add(p2);
    personsList.add(p3);
    personsList.add(p4);
    personsList.add(p5);
    personsList.add(p6);
    personsList.add(p7);
    personsList.add(p8);


    Map<Long, List<Person>> byId  = groupingByAndMapping.getPersonsGroupedById(personsList);

    assertThat(byId.get(300L).stream().count(), is(3L));
    assertThat(byId.get(400L).stream().count(), is(3L));
  }
}
