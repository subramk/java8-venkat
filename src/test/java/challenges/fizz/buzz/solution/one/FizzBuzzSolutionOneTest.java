package challenges.fizz.buzz.solution.one;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzSolutionOneTest {

  private FizzBuzzSolutionOne fizzBuzzSolutionOne;

  @BeforeEach
  public void setUp() {
    fizzBuzzSolutionOne = new FizzBuzzSolutionOne();
  }

  @Test
  @DisplayName("FizzBuzz Negative Range -1 to -20 should return empty list")
  public void testNegativeFizzBuzz() {
    String expected="Sorry we couldn't work out for the range -1 to -20 you have given";
    String actual = fizzBuzzSolutionOne.process(-1, -20);
    assertEquals(expected,actual, "Output does not match with expected results");
  }

  @Test
  @DisplayName("FizzBuzz For the Range 1 to 3 should return as 1 2 and fizz")
  public void testForRange1To5FizzBuzz() {
    String expected="1 2 fizz";
    String actual = fizzBuzzSolutionOne.process(1, 3);
    assertEquals(expected,actual, "Output does not match with expected results");
  }

  @Test
  @DisplayName("FizzBuzz For the Range 4 to 5 should return as 4 and buzz")
  public void testForRange4To5FizzBuzz() {
    String expected="4 buzz";
    String actual = fizzBuzzSolutionOne.process(4, 5);
    assertEquals(expected,actual, "Output does not match with expected results");
  }

  @Test
  @DisplayName("FizzBuzz Range 15 to 15 should return correct output")
  public void testFizzBuzzForRange15To15() {
    String expected="fizzbuzz";
    String actual = fizzBuzzSolutionOne.process(15, 15);
    assertEquals(expected,actual,"Output does not match with expected results");
  }

  @Test
  @DisplayName("FizzBuzz Range 1 to 20 should return correct output")
  public void testFizzBuzz() {
    String expected="1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    String actual = fizzBuzzSolutionOne.process(1, 20);
    assertEquals(expected,actual,"Output does not match with expected results");
  }

}
