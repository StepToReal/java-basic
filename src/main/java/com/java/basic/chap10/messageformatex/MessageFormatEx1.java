package com.java.basic.chap10.messageformatex;

import java.text.MessageFormat;

public class MessageFormatEx1 {

    public static void main(String[] args) {
        String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";

        Object[] argument = {"java", "02-123-1234", "26", "07-09"};

        String result = MessageFormat.format(msg, argument);
        System.out.println(result);
    }
}
