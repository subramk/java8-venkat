package com.java8.dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Admin on 10/08/2019.
 */
public class DatesAndFormatters {

    LocalDate date = LocalDate.of(2019,3,22);
    LocalTime time = LocalTime.of(12,45,46);
    LocalDateTime dateTime = LocalDateTime.of(date,time);



    public static void main(String[] args) {
        DatesAndFormatters dfs = new DatesAndFormatters();
       //  dfs.formatDateAndTimeOptions();
         dfs.dateTimeFormatters() ;


    }

    private void formatDateAndTimeOptions() {

        LocalDate date = LocalDate.of(2019,3,22);
        LocalTime time = LocalTime.of(12,45,46);
        LocalDateTime dateTime = LocalDateTime.of(date,time);

        System.out.println( date.format(DateTimeFormatter.ISO_DATE));
        System.out.println( time.format(DateTimeFormatter.ISO_TIME));
        System.out.println( dateTime.format(DateTimeFormatter.ISO_DATE_TIME));



    }

    private void dateTimeFormatters() {

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        Duration dd =  Duration.of(1, ChronoUnit.HALF_DAYS);



    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof DatesAndFormatters)) return false;

        final DatesAndFormatters that = (DatesAndFormatters) o;

        return new EqualsBuilder()
                .append(date, that.date)
                .append(time, that.time)
                .append(dateTime, that.dateTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(date)
                .append(time)
                .append(dateTime)
                .toHashCode();
    }
}
