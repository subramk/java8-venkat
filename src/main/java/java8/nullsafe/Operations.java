package java8.nullsafe;

public class Operations {



  public  boolean isRed(String color) {
    return color.equals("RED");
  }


  public boolean isNullSafeRed(final String colour){
    return "RED".equals(colour);
  }




}
