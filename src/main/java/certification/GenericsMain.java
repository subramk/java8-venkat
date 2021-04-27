package certification;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {
  public static void main(String[] args) {
    GenericsMain gm = new GenericsMain();
    gm.doWork();
  }

  void doWork(){
    List<?> list1 = new ArrayList<GenericsA>();

  }
}
