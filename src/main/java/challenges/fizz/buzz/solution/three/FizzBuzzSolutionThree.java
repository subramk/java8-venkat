package challenges.fizz.buzz.solution.three;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class FizzBuzzSolutionThree {
    final private static List<Operation> OPERATIONS;
    final private static List<String> SUMMARY;

    static {
        OPERATIONS = new ArrayList<>();
        OPERATIONS.add(new Operation(3, "lucky", OperationType.CONTAINS));
        OPERATIONS.add(new Operation(15, "fizzbuzz", OperationType.MULTIPLE));
        OPERATIONS.add(new Operation(5, "buzz", OperationType.MULTIPLE));
        OPERATIONS.add(new Operation(3, "fizz", OperationType.MULTIPLE));
        SUMMARY = Arrays.asList("fizz", "buzz", "fizzbuzz", "lucky", "integer");

    }

    public String process(int start, int end) {
        List<String> endResult = getMarkingList(start, end);
        String output;
        if (!endResult.isEmpty()) {
            output = endResult.stream().collect(Collectors.joining(" "));
        } else {
            return String.format("Sorry we couldn't work out for the range %d to %d you have given", start, end);
        }
        Map<String, Long> summaryMap = getSummary(endResult);
        String summary = generateOutput(summaryMap);
        return output + " " + summary;
    }

    protected Map<String, Long> getSummary(List<String> result) {

      final Map<Boolean, List<String>>  partitionByMap = result.stream().collect(partitioningBy(FizzBuzzSolutionThree::isNumeric));

      final Map<String, Long> summaryMapByWords =
            partitionByMap.entrySet().stream()
                            .filter(e -> !e.getKey())
                            .flatMap(s-> s.getValue().stream())
                            .collect(groupingBy(Function.identity(), () -> new LinkedHashMap<>(), counting()));

      final Long max = partitionByMap.entrySet().stream()
                                .filter(e -> e.getKey()).flatMap(s-> s.getValue().stream())
                                .collect(counting());

      summaryMapByWords.put("integer", max);

      return summaryMapByWords;
    }

    protected String generateOutput(Map<String, Long> summaryMap) {
       return SUMMARY.stream().map( key -> getFormattedOutput(key,summaryMap)).collect(Collectors.joining(" "));
    }

    protected static String getFormattedOutput(String key, Map<String, Long> summaryMap) {
        if (summaryMap.get(key) == null) {
            return key + ": " + 0;
        }
        return key + ": " + summaryMap.get(key);
    }

    protected List<String> getMarkingList(int start, int end) {
        List<String> outputList = new ArrayList<>();
        IntStream.rangeClosed(start, end).forEach( number -> outputList.add(getMarking(number)));
        return outputList;
    }

    protected String getMarking(int number) {
        return OPERATIONS.stream().filter(operation -> operation.operationType().test(number, operation.getNumber())).findFirst()
                .map(operation -> operation.getMarking()).orElse(Integer.toString(number));
    }

    protected static boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
