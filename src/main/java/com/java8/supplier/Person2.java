package com.java8.supplier;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Deprecated
public class Person2
{
    final String name;
    private final LocalDate dateOfBirth;
    private final LocalDate currentDate;

    
    public Person2(String name, LocalDate dateOfBirth) {
        this(name, dateOfBirth, LocalDate.now());
    }

    // Visible for test
    public Person2(String name, LocalDate dateOfBirth, LocalDate currentDate) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.currentDate = currentDate;
    }

    long getAge() {
        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }
}