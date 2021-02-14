package com.java8.flatmap;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FlatMapTest {
    private List<Developer> developers = new ArrayList<>();
    private  Developer polyglot;
    private Developer fullStack;

    @BeforeEach void setUp() {

        polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");
        polyglot.add("java");

        fullStack = new Developer("pragmatic");
        fullStack.add("java");
        fullStack.add("javascript");

        developers.add(polyglot);
        developers.add(fullStack);
    }
	
	@Test
     void flatMapListWithDuplicates() {


        List<String> developerRoles = developers	.stream()
                .flatMap(dev -> dev.getLanguages().stream())
        									.collect(Collectors.toList());
        
        developerRoles.forEach(n -> System.out.println(n));

        assertTrue(developerRoles.containsAll(polyglot.getLanguages()));
        assertTrue(developerRoles.containsAll(fullStack.getLanguages()));
        // without removing duplicate
      //  Assert.assertThat(developerRoles.size(),isEqualTo(polyglot.getLanguages().size()+fullStack.getLanguages().size());
    
	
	}

    @Test
    void flatMapSetWithoutDuplicates() {


        Set<String> developerRoles = developers	.stream()
                .flatMap(dev -> dev.getLanguages().stream())
                .collect(Collectors.toSet());

        developerRoles.forEach(n -> System.out.println(n));

      //  assertThat(6).isEqualTo(developerRoles.size());


        assertTrue(developerRoles.containsAll(polyglot.getLanguages()));
        assertTrue(developerRoles.containsAll(fullStack.getLanguages()));


    }
	

class Developer {

    private String name;
    private Set<String> languages;

    public Developer(String name) {
        this.languages = new HashSet<>();
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }
}


}
