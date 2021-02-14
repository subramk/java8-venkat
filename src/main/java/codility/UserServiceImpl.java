package codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

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

public class UserServiceImpl {

    //final Predicate<String> isStringNumeric = input  -> NumberUtils.isNumber(input);

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
            //if(isStringNumeric.test(key)){
                UserStats userStats = currentMapInstance.get(key);
                finalResult.put(Long.valueOf(key), userStats.getVisitCount().orElseGet( () -> 999L));
            //}
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

