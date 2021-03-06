package challenges.fizz.buzz.solution.two;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzSolutionTwoTest {

    private FizzBuzzSolutionTwo fizzBuzzSolutionTwo;

    @BeforeEach
    public void setUp() {
        fizzBuzzSolutionTwo = new FizzBuzzSolutionTwo();
    }


    @Test
    @DisplayName("FizzBuzz Negative Range -1 to -20 should return empty list")
    public void testNegativeFizzBuzz() {
        String expected = "Sorry we couldn't work out for the range -1 to -20 you have given";
        String actual = fizzBuzzSolutionTwo.process(-1, -20);
        assertEquals(expected, actual, "Output does not match with expected results");
    }

    @Test
    @DisplayName("FizzBuzz For the Range 1 to 3 should return as lucky")
    public void testForRange1To5FizzBuzz() {
        String expected="lucky";
        String actual = fizzBuzzSolutionTwo.process(3, 3);
        assertEquals(expected,actual, "Output does not match with expected results");
    }

    @Test
    @DisplayName("FizzBuzz For the Range 6 to 9 should return as fizz 7 8 fizz buzz")
    public void testForRange6To9FizzBuzz() {
        String expected="fizz 7 8 fizz buzz";
        String actual = fizzBuzzSolutionTwo.process(6, 10);
        assertEquals(expected,actual, "Output does not match with expected results");
    }

    @Test
    @DisplayName("FizzBuzz For the Range 13 to 15 should return as lucky 14 fizzbuzz")
    public void testForRange13To15FizzBuzz() {
        String expected="lucky 14 fizzbuzz";
        String actual = fizzBuzzSolutionTwo.process(13, 15);
        assertEquals(expected,actual, "Output does not match with expected results");
    }

    @Test
    @DisplayName("FizzBuzz Range 1 to 20 should work")
    public void testFizzBuzz() {
        String expected="1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";
        String output = fizzBuzzSolutionTwo.process(1, 20);
        System.out.println("Output:" + output);
        assertEquals(expected,output,"Output does not match expected");
    }
}
