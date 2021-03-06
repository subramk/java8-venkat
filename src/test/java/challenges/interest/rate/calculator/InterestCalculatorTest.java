package challenges.interest.rate.calculator;

import challenges.interest.rate.calculator.BandType;
import challenges.interest.rate.calculator.Customer;
import challenges.interest.rate.calculator.InterestCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import challenges.interest.rate.calculator.*;

import java.math.BigDecimal;

public class InterestCalculatorTest {

    @Test
    @DisplayName("calculate interest premium customer to have discount of 10%, so given 500 he will be get ")
    void shouldCalculateInterestForInput0To100Pounds() {
        // Arrange
        InterestCalculator interestCalculator = new InterestCalculator( new Customer("customer-1", BandType.PREMIUM));
        // Act
        BigDecimal actual = interestCalculator.calculate( new BigDecimal("500"));
        BigDecimal expected = new BigDecimal("50.00");
        // Assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("calculate interest for £100.50p which is 1% and expects £1.01")
    void shouldCalculateInterestForInput100PoundsAnd50Pence() {
        // Arrange
        InterestCalculator interestCalculator = new InterestCalculator(new Customer("customer-1", BandType.NO_BAND));
        // Act
        BigDecimal actual = interestCalculator.calculate( new BigDecimal("100.50"));
        BigDecimal expected = new BigDecimal("1.01");
        // Assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("calculate interest for £1000  which calulates interest for 2% and expects £20")
    void shouldCalculateInterestFor1000Pounds() {
        // Arrange
        InterestCalculator interestCalculator = new InterestCalculator(new Customer("customer-1", BandType.NO_BAND));
        // Act
        BigDecimal actual = interestCalculator.calculate( new BigDecimal("1000"));
        BigDecimal expected = new BigDecimal("20.00");
        // Assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("calculate interest for £500  which calulates interest for 3% and expects £150")
    void shouldCalculateInterestFor5000Pounds() {
        // Arrange
        InterestCalculator interestCalculator = new InterestCalculator(new Customer("customer-1", BandType.NO_BAND));
        // Act
        BigDecimal actual = interestCalculator.calculate( new BigDecimal("5000"));
        BigDecimal expected = new BigDecimal("150.00");
        // Assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("For Customer with gold band type given 2000 pounds will be get interest ")
    void shouldCreateCustomerBand() {

        // Arrange
        InterestCalculator interestCalculator = new InterestCalculator(new Customer("customer-1", BandType.SILVER));
        // Act
        BigDecimal actual = interestCalculator.calculate( new BigDecimal("6000"));
        BigDecimal expected = new BigDecimal("300.00");
        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
