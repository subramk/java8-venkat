package java8.challenges;


import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@FunctionalInterface
public interface Encoder {
   String encode(String encode) ;


    static Encoder getEncoder() {
      return input -> {
         Character[] chars = input.chars()
                 .mapToObj(ch -> (char) ch)
                 .toArray(Character[]::new);

         List<Character> charList = Arrays.asList(chars);

         List<Map.Entry<Character, Long>> map = getCharacterLongMap(charList).entrySet().stream().collect(Collectors.toList());
          System.out.println("map" + map);

         StringBuilder stringBuilder = new StringBuilder("");

         map.forEach( entry -> {
             // using java utils collections
             String s = (entry.getValue() > 5) ? String.format("{%s;%s}", entry.getKey(), entry.getValue()) :
                     Collections.nCopies(Math.toIntExact(entry.getValue()), entry.getKey().toString()).stream().collect(Collectors.joining());

               // using apache commons String Utils. Currently  commeted out we can move this into a seperate junit test later
//             String s =  (entry.getValue() > 5) ?  StringUtils.replace(entry.getKey().toString(),entry.getKey().toString(), "{"+entry.getKey().toString()+";"+Math.toIntExact(entry.getValue())+"}") :
//                     StringUtils.repeat(entry.getKey(), Math.toIntExact(entry.getValue()));

             stringBuilder.append(s);
         });

          return stringBuilder.toString();
      };

   }

    static Map<Character, Long> getCharacterLongMap(List<Character> charList) {
      return charList.stream().collect(
              groupingBy(
                      (character -> character),
                      // for maintaining the same order as passed in
                      () -> new LinkedHashMap<Character, Long>(),
                      Collectors.counting()
              )

      );
   }

}



