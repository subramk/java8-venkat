package certification;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsManipulattion {
  public static void main(String[] args) {
    StreamsManipulattion sm = new StreamsManipulattion();
    sm.doWork();
  }

  private void doWork() {
    // useStream();
   // useReduce();
   // usingCollectorsToMap();
   // usingAllMatch();
    printingNumbers();
  }

  private void useStream() {
    Stream<String> objStream = Stream.of("penguin", "fish");
    IntStream intStream = objStream.mapToInt(str -> str.length());
  }

  private void useReduce() {
  Stream<Integer> stream  = Stream.of(4,5,6);
  Integer sumValues = stream.reduce( 0, (a,b) -> a + b  );


  System.out.println(" .... Summing  values in the stream  is " + sumValues);


    Stream<Integer> streamOfNumbers  = Stream.of(4,5,6);

    Integer productValues = streamOfNumbers.reduce( 1, (a,b) -> a * b  );

    System.out.println(" .... Multiplying values in the  Stream is "+ productValues);


  }

  private void usingAllMatch() {
    Stream<String> sounds   = Stream.generate(() ->"meow");

    boolean match = sounds.noneMatch(String::isEmpty);
    System.out.println( "...... AllMatch called ....  " + match) ;
  }

  private void printingNumbers(){
    System.out.println(  Stream.iterate(1 , x -> ++ x)
                        .limit(5)
                        .map(x -> "" + x)
                        .collect(joining()) );
  }

  private void streamOfStreams(){
    List<Integer> list1 = Arrays.asList(1,2,3);
    List<Integer> list2 = Arrays.asList(4,5,6);
    List<Integer> list3 = Arrays.asList(7,8,9);

    List<Integer> results=
            Stream
            .of(list1,list2,list3)
            .flatMap( x -> x.stream())
            .map(x -> x+1)
            .collect(toList());
  }

  private void usingCollectorsToMap() {
    Stream<String> animals = Stream.of("lions","Tigers","Fish");
    Map<Integer,String> map = animals
            .collect(Collectors.toMap(x ->x.length(),
                                      val-> val,
              // when Keys are same, values are concatenated
                                      (s1 , s2 ) -> s1 + " " + s2));


    Map<Integer,String> mapWithSorting = animals
      .collect(Collectors.toMap(x ->x.length(),
        val-> val,
        // when Keys are same, values are concatenated
        (s1 , s2 ) -> s1 + " " + s2,
        TreeMap::new));


  }
}
