package com.java.basic.chap10.dateformatex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateFormatEx4 {

    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
        Scanner s = new Scanner(System.in);

        Date inDate = null;

        System.out.println("날짜를 " + pattern + "의 형식으로 입력해 주세요.");

        while (s.hasNextLine()) {
            try {
                inDate = df.parse(s.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("날짜를 " + pattern + "의 형식으로 다시시 입력해 주세요.");
           }
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);
        Calendar toDay = Calendar.getInstance();
        long day = (cal.getTimeInMillis() - toDay.getTimeInMillis()) / (60 * 60 * 1000);

        System.out.println("입력하신 날짜는 현재와 " + day + "시간 차이가 있습니다.");
    }
}
