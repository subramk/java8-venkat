package challenges.interest.rate.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Predicate;

public class InterestCalculator  {

    private Customer customer;

    private final BigDecimal isEqualToZero = BigDecimal.ZERO;
    private final BigDecimal isThousand = new BigDecimal("1000");
    private Predicate<BigDecimal> isGreaterThanZero = (input -> input.compareTo(isEqualToZero) > 0);
    private Predicate<BigDecimal> isGreaterThanOrEqualToThousand = (input -> input.compareTo(isThousand) >= 0);


    public InterestCalculator(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal calculate(BigDecimal balance) {
        BigDecimal interest = BigDecimal.ZERO;
            switch (getCustomerBYBand().getBandType()) {
                case PREMIUM:
                case GOLD:
                case SILVER:
                    interest = calculateInterestRateForBandCustomers(balance);
                    break;
                case NO_BAND:
                    interest = calculateInterestForNormalCustomers(balance);
                   break;
            }
        return interest;
    }

    private BigDecimal calculateInterestRateForBandCustomers(BigDecimal balance) {
        return customer.getBandType().getDiscountedAmount().apply(balance);
    }

    private BigDecimal calculateInterestForNormalCustomers(BigDecimal balance) {
        BigDecimal interest;

        if (isGreaterThanZero.and(InterestCalculateEnum.RANGE_1_1000.getInput()).test(balance)) {
            interest = interestCalculation(balance, DISCOUNT_TYPE.ONE_PERCENT);
        } else if (isGreaterThanOrEqualToThousand.and(InterestCalculateEnum.RANGE_1000_5000.getInput()).test(balance)) {
            interest = interestCalculation(balance, DISCOUNT_TYPE.TWO_PERCENT);
        } else {
            interest = interestCalculation(balance, DISCOUNT_TYPE.THREE_PERCENT);
        }
        return interest;
    }


    private BigDecimal interestCalculation(BigDecimal balance, DISCOUNT_TYPE discountType) {
        return balance.multiply(discountType.type).multiply(new BigDecimal("0.01")).setScale(2, RoundingMode.HALF_UP);
    }

    public Customer getCustomerBYBand() {
        return customer;
    }


    private enum DISCOUNT_TYPE {
        ONE_PERCENT(new BigDecimal("1")),
        TWO_PERCENT(new BigDecimal("2")),
        THREE_PERCENT(new BigDecimal("3"));
        private BigDecimal type;

        DISCOUNT_TYPE(BigDecimal type) {
            this.type = type;
        }
   }
 }
