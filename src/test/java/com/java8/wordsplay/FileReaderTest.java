package com.java8.wordsplay;

import java8.in.action.chapter5.Transaction;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.counting;
import static org.hamcrest.Matchers.*;
import util.McDonald;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;


public class FileReaderTest {

    private String fileName;

    private Stream<String> lines;

    private InputStreamReader in;

    private Path path;

    private List<String> wordList;

    @BeforeEach
    void setUp()  {
        path =   Paths.get("src/test/resources", "samples/mcdonalds-new.csv");

        String words =  "boat ant row ant car ant die ant boat row ant zan zan zan zan zan zan zan zan zan zan"  ;

        String[] wordsArray = words.split(" ");
        wordList = Arrays.asList(wordsArray);

    }


    @Test
     void shouldReturnFile() throws IOException {

         path =   Paths.get("src/test/resources", "samples/mcdonalds-new.csv");

        List<String> blacklist = Files.lines(Paths.get(path.toString())).collect(toList());


        List<McDonald> mcdos = blacklist.stream().map(s -> {
            String [] strings = s.split(",") ;
            McDonald mdo = new McDonald() ;
            mdo.setLatitude(Double.parseDouble(strings[0])) ;
            mdo.setLongitude(Double.parseDouble(strings[1])) ;
            mdo.setName(strings[2].substring(1) + strings[3].substring(0, strings[3].length() - 1)) ;
            mdo.setAddress(strings[4].substring(1)) ;
            mdo.setCity(strings[5].trim()) ;
            mdo.setState(strings[6].trim()) ;
            if (mdo.state().endsWith("\"")) {
                mdo.setState(mdo.state().substring(0, mdo.state().length() - 1)) ;
            }
            if (mdo.state().contains(" ")) {
                mdo.setState(mdo.state().substring(0, mdo.state().indexOf(" "))) ;
            }
            if (mdo.state().length() > 2) {
                mdo.setState(strings[7].trim()) ;
            }
            return mdo ;
        }).collect(toList());
        System.out.println("# of McDos = " + mcdos.size()) ;
    }

    @Test
    void shouldReturnWordWithSortedEntries() throws Exception {

//        Given the text: ant boat row ant car ant die ant boat row ant
//        1) We calculate the weight of each word as the number of occurrences:
//        - ant​ : 5 (it appears five times in the text)
//        - boat​: 2 (it appears two times in the text)
//        - row​: 2
//                - car​: 1
//                - die​:
       String words =  "ant boat row ant car ant die ant boat row ant"  ;

        String[] wordsArray = words.split(" ");
        List<String> wordList = Arrays.asList(wordsArray);


        List<Entry<String, Long>> wordMap =
        wordList.stream()
                .collect(
                        groupingBy(
                                (word -> word),
                                counting()
                        )
                )
               .entrySet()
               .stream()
               . sorted( comparing(Entry::getKey)).collect(toList());

        wordMap.forEach( entry1 -> System.out.println(entry1.getKey() + " " + entry1.getValue()));

    }

    @Test
    void shouldReturnWithNaturalOrder()  throws Exception {
        final Supplier<TreeMap<String,Long>> naturalOrdering = () -> new TreeMap<String, Long>(Comparator.naturalOrder());

        Map<String, Long> wordMap =
                wordList.stream()
                        .collect(
                                groupingBy(
                                        (word -> word),
                                        // creating natural order tree map dynamically
                                        naturalOrdering,
                                        Collectors.counting()
                                )
                        );

        wordMap.forEach((key, value) -> System.out.println(key + " " + value));
    }


    @Test
    void shouldRedturnWithNaturalOrder()  throws Exception {
        final Supplier<TreeMap<String,Long>> naturalOrdering = () -> new TreeMap<String, Long>(Comparator.naturalOrder());

        Map<String, Long> wordMapNaturalOrdering = getWordListComparingBy(naturalOrdering);
        wordMapNaturalOrdering.forEach((key, value) -> System.out.println(key + " " + value));
    }


    @Test
    void shouldReturnReverseOrder()  throws Exception {
        final Supplier<TreeMap<String,Long>> reverseOrder = () -> new TreeMap<String, Long>(Comparator.reverseOrder());

        Map<String, Long> wordMapReverseOrdering = getWordListComparingBy(reverseOrder);
        wordMapReverseOrdering.forEach((key, value) -> System.out.println(key + " " + value));
    }


    //TODO : Unit Test pending for Optional<Supplier<TreeMap<String, Long>>>
    // TODO Avoid using Optional as method parameters and in Collections  : See https://www.youtube.com/watch?v=fBYhtvY19xA 32:54 minute . Stuart Marks
    private TreeMap<String, Long> getWordListWithOptionalComparingBy(final Optional<Supplier<TreeMap<String, Long>>> orderingSupplier) {
        return wordList.stream()
                .collect(
                        groupingBy(
                                (word -> word),
                                orderingSupplier.get(),
                                counting()
                        )
                );
    }

    private TreeMap<String, Long> getWordListComparingBy(final Supplier<TreeMap<String, Long>> orderingSupplier) {
        return wordList.stream()
                .collect(
                        groupingBy(
                                (word -> word),
                                orderingSupplier,
                                counting()
                        )
                );
    }

}
