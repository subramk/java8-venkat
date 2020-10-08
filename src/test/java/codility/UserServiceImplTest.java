package codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceImplTest {

  private static Map<String, UserStats>[] userStatsMapArray =  (Map<String, UserStats>[]) new HashMap[3];

  private UserServiceImpl userService  = new UserServiceImpl();

  @BeforeClass
  public static void dataForTest(){


    Map<String, UserStats> userStatsMap1 = new HashMap();
    UserStats userStats1 = new UserStats();
    userStats1.setVisitCount(Optional.of(124L));
    userStatsMap1.put("1234", userStats1);

    Map<String, UserStats> userStatsMap2 = new HashMap();
    UserStats userStats2 = new UserStats();
    userStats2.setVisitCount(Optional.of(125L));
    userStatsMap2.put("1235", userStats2);

    Map<String, UserStats> userStatsMap3 = new HashMap();
    UserStats userStats3 = new UserStats();
    userStats3.setVisitCount(Optional.empty());
    userStatsMap3.put("1236", userStats3);

    userStatsMapArray[0] = userStatsMap1;
    userStatsMapArray[1] = userStatsMap2;
    userStatsMapArray[2] = userStatsMap3;

    userStatsMapArray[1] = userStatsMap2;
    userStatsMapArray[2] = userStatsMap3;

  }

  @Test
  public void shouldReturnBasicCount() {
    Map<Long,Long>  resultMap = userService.count(userStatsMapArray);
    Assert.assertEquals(resultMap.size(),3);

    resultMap
      .entrySet()
      .stream().forEach(x -> System.out.println("key is " + x.getKey() +  " and value is " + x.getValue()));
  }

}
