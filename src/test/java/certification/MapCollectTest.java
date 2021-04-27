package certification;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class MapCollectTest {

  public static class UserSessionObject {
    public String id;
    public String realm;
    public Set<String> clients = new HashSet<>();

    public UserSessionObject(String realm, String... clients) {
      this.id = UUID.randomUUID().toString();
      this.realm = realm;
      for (String c : clients) this.clients.add(c);
    }
  }

  public static class RealmFilter implements Predicate<UserSessionObject> {
    protected String realm;

    public RealmFilter(String realm) {
      this.realm = realm;
    }

    @Override
    public boolean test(UserSessionObject entry) {
      return entry.realm.equals(realm);
    }

    public static RealmFilter create(String realm) {
      return new RealmFilter(realm);
    }
  }

  public static Set<String> clients(UserSessionObject s) {
    return s.clients;
  }


  @Test
  public void testMe()  {

    List<UserSessionObject> list = Arrays.asList(
      new UserSessionObject("realm1", "a", "b")
      , new UserSessionObject("realm1", "a", "c")
      , new UserSessionObject("realm1", "a", "d")
      , new UserSessionObject("realm1", "a", "b")
      , new UserSessionObject("realm2", "a", "b")
      , new UserSessionObject("realm2", "a", "c")
      , new UserSessionObject("realm2", "a", "b")

    );

    Map<String, Long> result = list.stream().collect(
      Collectors.groupingBy(s -> s.realm, Collectors.summingLong(i -> 1)));

    for (Map.Entry<String, Long> entry : result.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    result = list.stream()
      .filter(RealmFilter.create("realm1"))
      .map(s -> s.clients)
      .flatMap(c -> c.stream())
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (Map.Entry<String, Long> entry : result.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }


  }
}




