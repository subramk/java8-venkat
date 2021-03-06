package challenges.fizz.buzz.solution.three;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzSolutionThreeTest {

    private FizzBuzzSolutionThree fizzBuzzSolutionThree;

    @BeforeEach
    public void setUp() {
        fizzBuzzSolutionThree = new FizzBuzzSolutionThree();
    }

    @Test
    @DisplayName("FizzBuzz Negative Range -1 to -20 should return empty list")
    public void testNegativeFizzBuzz() {
        String expected = "Sorry we couldn't work out for the range -1 to -20 you have given";
        String actual = fizzBuzzSolutionThree.process(-1, -20);
        assertEquals(expected, actual, "Output does not match with expected results");
    }

    @Test
    @DisplayName("FizzBuzz For the Range 1 to 3 should return as 1 2 lucky fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 1 integer: 2")
    public void testForRange1To3FizzBuzz() {
        String expected="1 2 lucky fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 1 integer: 2";
        String actual = fizzBuzzSolutionThree.process(1, 3);
        assertEquals(expected,actual, "Output does not match with expected results");
    }

    @Test
    @DisplayName("FizzBuzz For the Range 13 to 15 should return as lucky 14 fizzbuzz fizz: 0 buzz: 0 fizzbuzz: 1 lucky: 1 integer: 1")
    public void testForRange13To15FizzBuzz() {
        String expected="lucky 14 fizzbuzz fizz: 0 buzz: 0 fizzbuzz: 1 lucky: 1 integer: 1";
        String actual = fizzBuzzSolutionThree.process(13, 15);
        assertEquals(expected,actual, "Output does not match with expected results");
    }


    @Test
    @DisplayName("FizzBuzz Range 1 to 20 should work")
    public void testFizzBuzz() {

        String expectedOutput = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10";
        String result = fizzBuzzSolutionThree.process(1, 20);
        System.out.println(expectedOutput);
        assertEquals(expectedOutput, result, "Output does not match expected");
    }

}
