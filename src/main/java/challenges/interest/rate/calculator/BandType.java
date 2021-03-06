package challenges.interest.rate.calculator;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public enum BandType {

    PREMIUM (discount -> discount.multiply(new BigDecimal("10")).multiply(new BigDecimal("0.01"))),
    GOLD (discount -> discount.multiply(new BigDecimal("7.50")).multiply(new BigDecimal("0.01"))),
    SILVER  (discount -> discount.multiply(new BigDecimal("5")).multiply(new BigDecimal("0.01"))),
    NO_BAND();

    BandType() {
    }

    BandType(UnaryOperator<BigDecimal> discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public UnaryOperator<BigDecimal> getDiscountedAmount() {
        return discountedAmount;
    }

    private UnaryOperator<BigDecimal> discountedAmount;




}
