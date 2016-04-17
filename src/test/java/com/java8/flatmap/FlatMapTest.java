package com.java8.flatmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import static org.junit.Assert.*;


public class FlatMapTest {
	
	@Test
    public void flatMap() {
        
		List<Developer> team = new ArrayList<>();
        
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");
        polyglot.add("java");
        
        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("javascript");

        team.add(polyglot);
        team.add(busy);

        List<String> teamLanguages = team	.stream()
        									.map(d -> d.getLanguages())
        									.flatMap(l -> l.stream())
        									.distinct() // required after we flatten all the languages and then remove duplicates 
        									.collect(Collectors.toList());
        
        teamLanguages.forEach(n -> System.out.println(n));
             
        
        assertTrue(teamLanguages.containsAll(polyglot.getLanguages()));
        assertTrue(teamLanguages.containsAll(busy.getLanguages()));
    
	
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
