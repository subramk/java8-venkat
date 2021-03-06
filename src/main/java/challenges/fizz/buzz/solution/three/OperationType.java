package challenges.fizz.buzz.solution.three;

import java.util.function.BiPredicate;

public enum OperationType implements BiPredicate<Integer, Integer> {
    MULTIPLE((num, multiplier) -> num >= multiplier && num % multiplier == 0),
    CONTAINS((haystack, needle) -> Integer.toString(haystack).contains(Integer.toString(needle)));

    private BiPredicate<Integer, Integer> predicate;

    OperationType(BiPredicate<Integer, Integer> predicate) {
        this.predicate = predicate;
    }

    public boolean test(Integer int1, Integer int2) {
        return predicate.test(int1, int2);
    }
}

