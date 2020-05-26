package java8.challenges;


import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@FunctionalInterface
public interface Decoder {
   String decode(String decode) ;


    // e.g. obj.encode (“B{O;7}M!!!!!”) will return  “BOOOOOOOM!!!!!”
    Pattern pattern = Pattern.compile("[{O;0-9}]");

    StringBuilder stringBuilderMatcher = new StringBuilder("");
    StringBuilder stringBuilderNonMatcher = new StringBuilder("");
    String mapAsString = "";
    static Decoder getDecoder() {
        return input -> {


            Character[] chars = input.chars()
                    .mapToObj(ch -> (char) ch)
                    .toArray(Character[]::new);

            List<Character> charList = Arrays.asList(chars);
            Matcher matcher = pattern.matcher(input);
            List<String> macthersList = new ArrayList<>();

            while (matcher.find()) {
                macthersList.add(matcher.group());
            }

            StringBuilder sb = new StringBuilder();

//            String chString = Stream.of(charList)
//                    .map(ch -> String.valueOf(ch))
//                    .collect(Collectors.joining());

           String a =  charList.stream()
                   .map(charc -> {
                    if (Character.isAlphabetic(charc.charValue())) {
                        sb.append(charc);
                    } else {
                     //
                    }
                  return sb.toString();
           }).collect( Collectors.joining());

            System.out.println(a);
     //     List<Character> cAlpha =  s.collect(Collectors.toList());

         //   System.out.println(chString);
        //    chString.forEach( a -> System.out.println(a));

          //  B{O;7}M!!!!!
           // list.forEach( s -> System.out.println());




//            while (matcher.find()) {
//                charList.forEach( character -> {
//                    if (Character.toString(character).matches(matcher.group())) {
//                        stringBuilderMatcher.append(character);
//                    }
//                });
//            }

//            charList.stream().forEach(charac -> {
//                if (matcher.find()) {
//                    String s = matcher.group();
//                   // if (s.contains(charac.toString())) {
//                    stringBuilderMatcher.append(s);
//                  //  }
//                } else {
//                    stringBuilderNonMatcher.append(charac);
//                }
//
//            });
//           System.out.println("Matcher  " + stringBuilderMatcher.toString());
//            System.out.println("Non Matcher  " + stringBuilderNonMatcher.toString());
            return stringBuilderMatcher.toString();
            //return mapAsString;

        };
    }



    static String getMapAsStrin( char c) {

        return "";
    }
}



