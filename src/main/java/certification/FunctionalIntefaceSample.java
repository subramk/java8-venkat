package certification;


/**
 * A Functional Interface can have only one Abstract method
 *
 * Remaining Methods if Any
 * Any number of default methods are okay
 * Any number of private methods are fine
 * Any number of static methods are fine.
 *
 * So for this to compile  , we can have only one SAM
 * either double quotient() or abstract int reminder(int x , int y );
 *
 *
 */
@FunctionalInterface
public interface FunctionalIntefaceSample {
  int sum = 0 ;

  final static int divisor = 3;

  // this is a abstract method
  // double quotient();

  default void product(){
    System.out.println(".......");
  }

  // this is a abstract method
  abstract int reminder(int x , int y );

  static int result(){
    return 0 ;
  }

  private int count(){
    // variables in an interface are implicity STATIC FINAL .
    // so this is not possible
    // return sum++;

    return 0 ;
  }

}
