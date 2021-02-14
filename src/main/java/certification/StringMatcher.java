package certification;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class StringMatcher {

  public static void main(String[] args) {
    StringMatcher mm = new StringMatcher() ;
    mm.doWork();

  }

  private void doWork() {

    Predicate<String> filterByCroydon = str -> str.equalsIgnoreCase("croydon");
    final String stringToTest="hello I must be going to the croydon hello and see that it is a croydon place";

    // use gauva , best way , splitting on Space as the delimiter.
    // List<String> list = Lists.newArrayList(Splitter.on(" ").split(stringToTest));

    List<String> list = new ArrayList<String>(Arrays.asList(stringToTest.split("\\s+")));

    if(nonNull(list) && list.size() > 0 ){ // use CollectionUtils.isNotEmpty instead

     int  numberOfOccurences =  list.stream()
                                .filter(Objects::nonNull)
                                .filter(filterByCroydon)
                                .mapToInt( x -> x.length())
                                .toArray().length;

     System.out.println( " Occurences are :::" + numberOfOccurences);

    }




  }


}

