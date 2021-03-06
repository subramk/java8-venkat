package challenges.fizz.buzz.solution.one;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzSolutionOne {
  private static final Map<Integer, String> multiplierMap;
  private BiPredicate<Integer, Integer> isMultipleOf = (num, multiplier) -> num >= multiplier && num % multiplier == 0;

  static {
    multiplierMap = new LinkedHashMap<>();
    multiplierMap.put(15, "fizzbuzz");
    multiplierMap.put(5, "buzz");
    multiplierMap.put(3, "fizz");
  }

  public String process(int start, int end) {
    List<String> endResult = getMarkingList(start, end);
    if (!endResult.isEmpty()) {
      return endResult.stream().collect(Collectors.joining(" "));
    }
    return String.format("Sorry we couldn't work out for the range %d to %d you have given", start, end);
  }

  private List<String> getMarkingList(int start, int end) {
    List<String> outComes= new ArrayList<>();
    IntStream.rangeClosed(start, end).forEach( num -> outComes.add(getMarking(num)));
    return outComes;
  }

  private String getMarking(int number) {
    return multiplierMap.entrySet().stream().filter(entry -> isMultipleOf.test(number, entry.getKey())).
      findFirst().map(entry -> entry.getValue()).orElse(Integer.toString(number));
  }

}
