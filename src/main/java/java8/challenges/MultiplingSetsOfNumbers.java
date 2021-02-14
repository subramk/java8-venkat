package java8.challenges;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiplingSetsOfNumbers {

  public List<int[]>  processNumberPairs(){
    List<Integer> numbers1 = Arrays.asList(1,2,3);
    List<Integer> numbers2 = Arrays.asList(3,4);

    List<int[]> pairs = numbers1
      .stream()
      .flatMap( i ->
        numbers2.stream().map(j -> new int[]{i,j}))
      .collect(toList());

    pairs.stream().forEach(p -> Arrays.stream(p).boxed().map(x -> x.longValue()));
  return pairs ;


  }

  public static void main(String[] args) {
    MultiplingSetsOfNumbers ms = new  MultiplingSetsOfNumbers();
    ms.processNumberPairs();
  }



}
