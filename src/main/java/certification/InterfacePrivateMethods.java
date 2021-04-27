package certification;

public interface InterfacePrivateMethods {

  // fiedls in an interface are IMPLICITY static and final
  int counter = 1983 ;

  default void methodA(){
    // some method

  }


  private  int  methodB(){
    // SOME LOGIC THAT CANNOT BE CHANGED IN ANY  Implentors
    return counter + 100;
  }

}
