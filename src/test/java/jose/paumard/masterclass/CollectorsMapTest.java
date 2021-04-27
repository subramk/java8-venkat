package jose.paumard.masterclass;

import static java.util.List.*;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

public class CollectorsMapTest {

  public static void main(String[] args) {
    CollectorsMapTest cm = new CollectorsMapTest();

    // all words start with unique letters -
    List<String> sonnetWords = of("the", "world", "of", "frank", "kane", "is", "precious");
    cm.twoArgs_Map_Function(sonnetWords);


  }

  private void twoArgs_Map_Function(final List<String> sonnetWords) {

    Map<String, Integer> sonnetMap = sonnetWords
      .stream()
      // 2 Args Collectors.toMap function .
      .collect(toMap(str -> str.substring(0, 1), str -> str.length()));


  }

  private void threeArgs_Map_Function(final List<String> sonnetWords) {


  }
}
