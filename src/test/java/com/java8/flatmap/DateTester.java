package com.java8.flatmap;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;


import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class DateTester {

  @Test
  public void when_Input_Date_Is_Today_Then_XXXXXX() {

    LocalDate inputDateToday = LocalDate.now();

    LocalDate currentDate = LocalDate.now();

    // Use Period to determine if InputDate is same as Today or Not
    Period periodBetween = Period.between(inputDateToday, currentDate);

    if (periodBetween.getDays() > 1) {
      System.out.println(" Input date is NOT Today  ....");
      LocalDate ninetyDaysFromNow = inputDateToday.plusDays(90);
      Assert.assertTrue(ninetyDaysFromNow.isAfter(inputDateToday));

    } else {
      assertThat(periodBetween.getDays(), is(0));
      System.out.println(" input date IS Today ....");
    }

  }

  @Test
  public void when_Input_Date_Is_Date_in_The_Past_Then_XXXXXX() {

    LocalDate dateInThePast = LocalDate.now().minusDays(40) ;

    // Use Period to determine if InputDate is same as Today or Not
    Period periodBetween = Period.between(dateInThePast, LocalDate.now());

    if (periodBetween.getDays() > 1) {
      System.out.println(" Input date is NOT Today  ....");
      assertTrue(periodBetween.getDays() > 0);
      // Your logic here
    }
  }

  @Test
  public void when_Input_Date_Is_Date_in_The_Future_Then_XXXXXX() {

    LocalDate dateInTheFuture  = LocalDate.now().plusDays(75) ;

    LocalDate currentDate = LocalDate.now();

    Period periodBetween = Period.between(dateInTheFuture, currentDate);

    if (periodBetween.getDays() > 1 && currentDate.isBefore(dateInTheFuture)){
      assertTrue( currentDate.isBefore(dateInTheFuture));
      assertFalse( dateInTheFuture.isAfter(currentDate));
    }

  }
}
