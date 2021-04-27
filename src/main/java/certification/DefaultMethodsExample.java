package certification;

public class DefaultMethodsExample {

  public static Object Black;

  public interface Black {
    default   void getColour() {
      System.out.println(" .... Black ");
    }
  }

  public interface Red extends Black {
    default void getColour() {
      System.out.println(" .... RED ");
    }
  }

  public interface Gold {
    default void getColour() {
      System.out.println(" .... GOLD ");
    }
  }

}

