package com.java.basic.chap10.messageformatex;

import java.text.MessageFormat;

public class MessageFormatEx2 {
    public static void main(String[] args) {
        String tableName = "CUST_INFO";
        String msg = "INSERT INTO " + tableName + " VALUES (''{0}'',''{1}'',{2},''{3}'');";

        Object[][] arguments = {
                {"java", "02-1234-1234", "27", "07-09"},
                {"pro", "031-123-2222", "29", "03-22"},
        };

        for (int i = 0; i < arguments.length; i++) {
            String result = MessageFormat.format(msg, arguments[i]);
            System.out.println(result);
        }
    }
}
