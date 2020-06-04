package java8.challenges;


import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@FunctionalInterface
public interface Encoder {
   String encode(String encode) ;


    default Encoder getEncoder() {
      return input -> {

         List<Character> charList=  input.codePoints().mapToObj(ch -> (char) ch).collect(Collectors.toList());

         List<Map.Entry<Character, Long>> map = getCharacterLongMap(charList).entrySet().stream().collect(Collectors.toList());
         System.out.println("map" + map);
         StringBuilder stringBuilder = new StringBuilder("");

         map.forEach( entry -> {
             // using java utils collections
             String s = (entry.getValue() > 5) ? String.format("{%s;%s}", entry.getKey(), entry.getValue()) :
                     Collections.nCopies(Math.toIntExact(entry.getValue()), entry.getKey().toString()).stream().collect(Collectors.joining());

             stringBuilder.append(s);
         });

          return stringBuilder.toString();
      };

   }

    static Map<Character, Long> getCharacterLongMap(List<Character> charList) {
      return charList.stream().collect(
              groupingBy(
                      (Function.identity()), // same as  character -> character
                      // for maintaining the same order as passed in
                      () -> new LinkedHashMap<>(),
                      Collectors.counting()
              )

      );
   }

}



