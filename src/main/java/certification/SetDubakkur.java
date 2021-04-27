package certification;

import java.util.HashSet;
import java.util.Set;


public class SetDubakkur {
  public static void main(String[] args) {

    SetDubakkur sets = new SetDubakkur();
    sets.doWork();
  }

  private void doWork() {

    Set<String> s = new HashSet<String>();
    s.add("lion");
    s.add("baer");
    //s.forEach( e -> System.out.println(e)); //OK
    //s.forEach( (e) -> System.out.println(e)); //OK
    s.forEach( (ss) -> System.out.println());





  }
}
