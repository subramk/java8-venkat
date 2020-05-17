package com.java8.comparator.example;

import java.util.Comparator;

/**
 * Created by Admin on 27/07/2019.
 */
public class SquirrelComparator implements Comparator<Squirell> {

    @Override
    public int compare(final Squirell sq1, final Squirell sq2) {
         return 0 ;
           // Comparator<Squirell> comparator = Comparator.comparing(s -> s.getWeight()).thenComparing( sq1.getName()) ;

    }

    @Override
    public Comparator<Squirell> reversed() {

            return null;

    }


}
