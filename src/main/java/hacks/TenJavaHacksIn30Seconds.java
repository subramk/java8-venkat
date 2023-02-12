package hacks;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.lang.Double;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.checkerframework.checker.units.qual.min;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TenJavaHacksIn30Seconds {

    public static void main(String[] args) {
        runTheQuickHacks();
    }

    private static void runTheQuickHacks() {

        // 1. Multiple Each Item in a List by 2
        System.out.println( IntStream.range(1, 10).map(i -> i * 2) ) ;

        // 2. Sum a List of Numbers
        IntStream.range(1, 1000).sum();

        // 3. Verify if Exists in a String
        List<String> wordList = Arrays.asList("java", "jdk", "spring", "maven");
        String tweet = "This is an example tweet talking about java and maven.";
        wordList.stream().anyMatch(tweet::contains);

        // 4. Read in a File

        try{
            String fileText = new String(Files.readAllBytes(Paths.get("data.txt")));
            List<String> fileLines = Files.readAllLines(Paths.get("data.txt"));
        }catch (IOException ffe){
            System.out.println(ffe);
        }catch(Exception eee){
            System.out.println(eee);
        }

        // 5. Happy Birthday to You!
        IntStream.rangeClosed(1, 4)
                .mapToObj(i -> MessageFormat.format("Happy Birthday {0}", (i == 3) ? "dear NAME" : "to You"))
                .forEach(System.out::println);

        }

        // 6. Filter list of numbers
        Map<Boolean, List<Integer>> passedFailedMap = Stream.of(49, 58, 76, 82, 88, 90)
            .collect(Collectors.partitioningBy(i -> i > 60));


            // 8. Find minimum (or maximum) in a List
        // Uses java 9 and above
//        IntStream.of(14, 35, -7, 46, 98).min();
//        Arrays.asList(14, 35, -7, 46, 98).stream().min(Integer::compare);
//        Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::min);
//        Collections.min(Arrays.asList(14, 35, -7, 46, 98));
//


    // 10. Sieve of Eratosthenes / prime numbers
    LinkedList<Integer> nums = new LinkedList<>(IntStream.rangeClosed(2, 1000).boxed().collect(Collectors.toList()));

//    IntStream.rangeClosed(2, Double.valueOf(Math.sqrt(nums.getLast()))
//                .intValue())
//                .forEach(n -> nums.removeIf(i -> i % n == 0 && n != i));
//
//            nums.forEach(System.out::println);



    // 7.1 and 7.2
    private void parseXmlFromFile() {

        // 7.1 Fetch and Parse an XML web service

        Document parse;
        String url = "http://www.omdbapi.com/?i=tt0121765&plot=short&r=xml";

        try {
            parse = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new URL(url).openStream());
        } catch (SAXException sae) {
            throw new RuntimeException(sae);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        } catch (ParserConfigurationException pce) {
            throw new RuntimeException(pce);
        }

        // 7.2 Fetch and Parse JSON
        String json="";
        try {
            json = new String(Files.readAllBytes(Paths.get(url)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);





    }




}

