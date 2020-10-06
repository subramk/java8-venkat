package codility;


import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/*

Your Architect has designed a User MicroSerivce that will return the userId  and the number
of times the User has visited the site.

The signature of the API method is as follows
Map<Long, Long> count(Map<String, UserStats>... visits) :

Rules that need to be implemented in your business logic is :

1. userId passed to the service should be Numeric to be considered as a Key
2. visitCount may or may not be present in the UserStats object


Solution :
Map<Long, Long> is the return type.

The signature of the method is
Map<Long, Long> count(Map<String, UserStats>... visits) :
[Note : Argument is a varargs , Meaning that than an Array of maps can be passed in representing data of Several Users]

ie : One Map will represent ONE User and his UserStats, so we could have an array of maps passed in as a parameter

Ex
Map<String,UserStats> user1 = new HashMap("1234", new UserStats(120L));
Map<String,UserStats> user2 = new HashMap("1233", new UserStats(130L));
Map<String,UserStats> user3 = new HashMap("ABCD4", new UserStats());
Map<String,UserStats> user4 = new HashMap("ABCD4", new UserStats());
Map<String,UserStats> user5 = new HashMap("1235", new UserStats(170L));

*/

public class UserServiceMicroservice {

    public static void main(String[] args) {

        UserServiceMicroservice userServiceMicroservice = new UserServiceMicroservice();

        Map<String, UserStats> someMap1 = new HashMap();
        UserStats userStats1 = new UserStats();
        userStats1.setVisitCount(Optional.of(124L));
        someMap1.put("1234", userStats1);

        Map<String, UserStats> someMap2 = new HashMap();
        UserStats userStats2 = new UserStats();
        userStats2.setVisitCount(Optional.of(125L));
        someMap2.put("1235", userStats2);

        Map<String, UserStats> someMap3 = new HashMap();
        UserStats userStats3 = new UserStats();
        userStats3.setVisitCount(Optional.empty());
        someMap3.put("1236", userStats3);

        Map<String, UserStats>[] myMaps = (Map<String, UserStats>[]) new HashMap[3];
        myMaps[0] = someMap1;
        myMaps[1] = someMap2;
        myMaps[2] = someMap3;

        Map<Long, Long> finalResult = userServiceMicroservice.count(myMaps);
        finalResult
                .entrySet()
                .stream().forEach(x -> System.out.println("key is " + x.getKey() + "and value is " + x.getValue()));
    }

    Predicate<String> isNumeric = x -> {
        try {
            Integer.parseInt(x);
            return true;
        } catch (Exception e) {
            return false;
        }

    };

    Map<Long, Long> count(final Map<String, UserStats>... visits) {

        Map<Long, Long> finalResult = new HashMap<Long, Long>();

        if (Objects.isNull(visits) || visits.length == 0) {
            return Collections.emptyMap();
        }

        List<Map<String, UserStats>> listOfMaps = Arrays.asList(visits);

        for (int count = 0; count < listOfMaps.size(); count++) {

            putInMap(finalResult, listOfMaps, count);
        }
        return finalResult;
    }

    private void putInMap(final Map<Long, Long> finalResult, final List<Map<String, UserStats>> listOfMaps, final int count) {
        Map<String, UserStats> currentMapInstance  = listOfMaps.get(count);
        if(Objects.nonNull(currentMapInstance) && !currentMapInstance.keySet().isEmpty()){
            String key = currentMapInstance.keySet().stream().findAny().get();
            if(isNumeric.test(key)){
                UserStats userStats = currentMapInstance.get(key);
                finalResult.put(Long.valueOf(key), userStats.getVisitCount().orElseGet( () -> 999L));
            }
        }
    }
}


class UserStats {
    private Optional<Long> visitCount;

    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

}

