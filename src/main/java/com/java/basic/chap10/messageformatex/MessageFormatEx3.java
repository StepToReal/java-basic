package com.java.basic.chap10.messageformatex;

import java.text.MessageFormat;

public class MessageFormatEx3 {

    public static void main(String[] args) throws Exception {
        String[] data = {
                "INSERT INTO CUST_INFO VALUES ('java','02-1234-1234',27,'07-09');",
                "INSERT INTO CUST_INFO VALUES ('pro','031-123-2222',29,'03-22');"
        };

        String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";
        MessageFormat mf = new MessageFormat(pattern);

        for (int i = 0; i < data.length; i++) {
            Object[] objs = mf.parse(data[i]);

            for (int j = 0; j < objs.length; j++ ) {
                System.out.println(objs[j] + ",");
            }
            System.out.println();
        }
    }
}
