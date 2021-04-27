package certification;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {


  public static void main(String[] args) {
    CopyOnWriteArrayListExample cow = new CopyOnWriteArrayListExample();
    cow.doWork();
  }

  void doWork(){
    List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(14, 18 , 20 ));
    //List<Integer> list = Arrays.asList(14, 18 , 20 );

    for(Integer e:list){
      list.add(9);
      list.forEach(System.out::println);
    }

    System.out.println( "Outside of the FOR Loop .... Size of the list is " + list.size() ) ;


  }

}
