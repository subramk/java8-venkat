package challenges.interest.rate.calculator;

import java.math.BigDecimal;
import java.util.function.Predicate;

public enum InterestCalculateEnum  {

    RANGE_1_1000(input -> input.compareTo(new BigDecimal("1000")) < 0),
    RANGE_1000_5000(input -> input.compareTo(new BigDecimal("5000")) < 0 );

    private Predicate<BigDecimal> input;

    InterestCalculateEnum(Predicate<BigDecimal> input) {
        this.input = input;
    }


    public Predicate<BigDecimal> getInput() {
        return input;
    }

}
