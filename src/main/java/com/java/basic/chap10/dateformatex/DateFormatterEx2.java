package com.java.basic.chap10.dateformatex;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterEx2 {
    public static void main(String[] args) {
        LocalDate newYear = LocalDate.parse("2022-01-01", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date = LocalDate.parse("2021-01-01");
        LocalTime time = LocalTime.parse("23:01:23");
        LocalDateTime dateTime = LocalDateTime.parse("2021-03-02T23:59:59");

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endOfYear = LocalDateTime.parse("2021-12-31 23:59:59", pattern);

        System.out.println(newYear);
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(endOfYear);
    }
}
