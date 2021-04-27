package certification;

import java.util.stream.Collectors;

public class Colours implements DefaultMethodsExample.Red, DefaultMethodsExample.Gold, DefaultMethodsExample.Black {
  public static void main(String[] args) {
    Colours colours = new Colours();
    colours.getColour();
  }

  @Override
  public void getColour() {
    //DefaultMethodsExample.Black black  =  DefaultMethodsExample.Black;
  }
}
