package com.java.basic.chap10.messageformatex;

import java.io.File;
import java.text.MessageFormat;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class MessageFormatEx4 {
    public static void main(String[] args) throws Exception {
        String tableName = "CUST_INFO";
        String fileName = "D:\\Study\\javaBasic\\src\\main\\java\\com\\java\\basic\\chap10\\data4.txt";
        String msg = "INSERT INTO " + tableName + "VALUES ({0},{1},{2},{3});";
        Scanner s = new Scanner(new File(fileName));

        String pattern = "{0},{1},{2},{3}";
        MessageFormat mf = new MessageFormat(pattern);

        while (s.hasNextLine()) {
            String line = s.nextLine();
            Object[] objs = mf.parse(line);
            System.out.println(MessageFormat.format(msg, objs));
        }

        s.close();
    }
}