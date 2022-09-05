package com.java.basic.chap10_date_time.dateformatex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx1 {

    public static void main(String[] args) {
        Date toDay = new Date();

        SimpleDateFormat[] formats = {
                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("''yy년 MMM dd일 E요일"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"),
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a"),
                new SimpleDateFormat("올해의 D 번째 날"),
                new SimpleDateFormat("이달의 d 번째 날"),
                new SimpleDateFormat("올해의 w 번째 주"),
                new SimpleDateFormat("이달의 W 번째 주"),
                new SimpleDateFormat("이달의 F 번째 E요일")
        };

        for (SimpleDateFormat format : formats) {
            System.out.println(format.format(toDay));
        }
    }
}
