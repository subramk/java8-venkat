package challenges.ee;

import challenges.ee.ConverterType;
import challenges.ee.CurrencyConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CurrencyConverterTest {

    @Test
    @DisplayName("given 1 euro convert to its euivalent us dollar" )
    void givenAEuroConvertToUSDollar() {

        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        // Act
        double actual = currencyConverter.covert( ConverterType.EUR_US_DOLLAR, 2d);

        // Assert
        assertEquals(2.4444, actual);
    }

    @Test
    @DisplayName("given 1 us dollar convert to its euivalent pounds" )
    void givenAUSDollarToSterlingDollar() {

        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        // Act
        double actual = currencyConverter.covert( ConverterType.US_DOLLAR_POUND, 10d);

        // Assert
        assertEquals(7.1, actual);
    }
}
