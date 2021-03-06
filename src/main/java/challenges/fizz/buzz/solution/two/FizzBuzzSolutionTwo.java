package challenges.fizz.buzz.solution.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzSolutionTwo {
    final private static List<Operation> OPERATIONS;

    static {
        OPERATIONS = new ArrayList<>();
        OPERATIONS.add(new Operation(3, "lucky", OperationType.CONTAINS));
        OPERATIONS.add(new Operation(15, "fizzbuzz", OperationType.MULTIPLE));
        OPERATIONS.add(new Operation(5, "buzz", OperationType.MULTIPLE));
        OPERATIONS.add(new Operation(3, "fizz", OperationType.MULTIPLE));
    }

    public String process(int start, int end) {
        List<String> endResult = getMarkingList(start, end);
        if (!endResult.isEmpty()) {
            return endResult.stream().collect(Collectors.joining(" "));
        }
        return String.format("Sorry we couldn't work out for the range %d to %d you have given", start, end);
    }

    private List<String> getMarkingList(int start, int end) {
        List<String> outputList = new ArrayList<>();
        IntStream.rangeClosed(start, end).forEach(input -> outputList.add(getMarking(input)));
        return outputList;
    }

    private String getMarking(int number) {
        return OPERATIONS.stream().filter(operation -> operation.operationType().test(number, operation.getNumber())).findFirst()
                .map(operation -> operation.getMarking()).orElse(Integer.toString(number));
    }

}
