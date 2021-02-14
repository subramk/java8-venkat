package challenges;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 *Always use GroupingBy with a downstream Collector to pick out duplicates.
 */
public class DuplicateIdentifier {

  @Test
  public void identifyDuplicates(){
    List<Integer> duplicates = IntStream.of( 1, 2, 3, 2, 1, 2, 3, 4, 2, 2, 2,5,6,7,8,9 )
      .boxed()
      .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
      .entrySet()
      .stream()
      .filter( p -> p.getValue() > 1 )
      .map( Map.Entry::getKey )
      .collect( Collectors.toList() );

    duplicates.forEach( e -> System.out.println("duplicate value found for number ..." + e));
  }
}
