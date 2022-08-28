package com.java.basic.chap10.calendarex;

import java.util.Calendar;

public class CalendarEx1 {

    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();

        System.out.println("year : " + today.get(Calendar.YEAR));
        System.out.println("month : " + today.get(Calendar.MONTH));
        System.out.println("week of year: " + today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("week of month : " + today.get(Calendar.WEEK_OF_MONTH));

        System.out.println("day of month: " + today.get(Calendar.DATE));
        System.out.println("day of month: " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("day of year: " + today.get(Calendar.DAY_OF_YEAR));
        System.out.println("요일 (1~7): " + today.get(Calendar.DAY_OF_WEEK));
        System.out.println("이 달의 몇째 요일: " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM(0) or PM(1): " + today.get(Calendar.AM_PM));
        System.out.println("time (0~11): " + today.get(Calendar.HOUR));
        System.out.println("time (0~23): " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("minute : " + today.get(Calendar.MINUTE));
        System.out.println("sec : " + today.get(Calendar.SECOND));
        System.out.println("milli sec: " + today.get(Calendar.MILLISECOND));

        System.out.println("TimeZone (-12~12): " + (today.get(Calendar.ZONE_OFFSET) / (60*60*1000)));
        System.out.println("이 달의 마지막 날: " + today.getActualMaximum(Calendar.DATE));
    }
}
