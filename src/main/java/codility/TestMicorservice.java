package codility;


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

public class TestMicorservice {

    public static void main(String[] args) {

        TestMicorservice userServiceMicroservice = new TestMicorservice();

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
        someMap3.put("1234", userStats3);

        Map<String, UserStats>[] myMaps = (Map<String, UserStats>[])new HashMap[5];
        myMaps[0]= someMap1;
        myMaps[1]= someMap2;
        myMaps[2]= someMap3;

        Map<Long, Long> finalResult =   userServiceMicroservice.count(myMaps);
        System.out.println(" .... final result ");
        finalResult
                .entrySet()
                .stream().forEach( x -> System.out.println( "key is " + x.getKey() + "and value is " + x.getValue() ));


    }



    Predicate<String> isNumeric = x -> {
        try{
            Integer.parseInt(x);
            return true;
        }catch(Exception e){
            return false;
        }

    };

    Map<Long, Long> count(final Map<String, UserStats>... visits) {

        Map<Long, Long> finalResult = new HashMap<Long, Long>();
            if(Objects.isNull(visits) || visits.length ==0){
                return Collections.emptyMap();
            }

            List<Map<String, UserStats>> list = Arrays.asList(visits);

            for(int listSize = 0 ; listSize < list.size(); listSize++){

                Map<String, UserStats> currMap = list.get(listSize);

                if(currMap != null && !currMap.isEmpty()) {
                    List<Integer> validKeys = currMap.keySet().stream()
                            .filter(Objects::nonNull)
                            .filter(x -> isNumeric.test(x))
                            .map(x -> Integer.parseInt(x))
                            .collect(Collectors.toList());

                    // validKeys.forEach( x -> System.out.println(" key:: " + x));

                    validKeys.stream().forEach(key -> {
                        System.out.println("key is " +  key );
                        if (currMap.get(Integer.toString(key)).getVisitCount().isPresent()) {
                            if (finalResult.containsKey(key)) {
                                // why
                                finalResult.put(key.longValue(), finalResult.get(key) + currMap.get(key).getVisitCount().get());
                            } else {
                                // normal case
                                finalResult.put(key.longValue(), currMap.get(key).getVisitCount().get());
                            }
                        }
                    });
                }
            }
            return  finalResult;
        }




    }

class UserStatistics {
    private Optional<Long> visitCount;
    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

}
