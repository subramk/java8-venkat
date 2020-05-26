package java8.challenges;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@FunctionalInterface
public interface Encoder {
   String encode(String encode) ;


    static Encoder getEncoder() {
      return input -> {
         Character[] chars = input.chars()
                 .mapToObj(ch -> (char) ch)
                 .toArray(Character[]::new);

         List<Character> charList = Arrays.asList(chars);

         Set<Map.Entry<Character, Long>> map = getCharacterLongMap(charList).entrySet().stream().collect(Collectors.toSet());
          System.out.println("map" + map);

         StringBuilder stringBuilder = new StringBuilder("");
         String mapAsString = "";
         for (Map.Entry<Character, Long> entry : map) {
            Character key = entry.getKey();
            Long value = entry.getValue();
            if (value > 5) {
               mapAsString = StringUtils.replace(key.toString(),key.toString(), "{"+key.toString()+";"+Math.toIntExact(value)+"}");
            } else {
               mapAsString = StringUtils.repeat(key, Math.toIntExact(value));
            }
            stringBuilder.append(mapAsString);
         }
         return stringBuilder.toString();
      };

   }

    static Map<Character, Long> getCharacterLongMap(List<Character> charList) {
      return charList.stream().collect(
              groupingBy(
                      (character -> character),
                      Collectors.counting()
              )
      );
   }

}



