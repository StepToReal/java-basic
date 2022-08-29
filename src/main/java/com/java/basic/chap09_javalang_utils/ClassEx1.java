package com.java.basic.chap09_javalang_utils;

import java.net.SocketTimeoutException;

public class ClassEx1 {
    public static void main(String[] args) throws Exception {
        Card_ClassEx c = new Card_ClassEx("HEART", 3);
        Card_ClassEx c2 = Card_ClassEx.class.newInstance();

        Class cObj = c.getClass();

        System.out.println(c);
        System.out.println(c2);
        System.out.println(cObj.getName());
        System.out.println(cObj.toGenericString());
        System.out.println(cObj.toString());
    }
}

final class Card_ClassEx {
    String kind;
    int num;

    Card_ClassEx() {
        this("SPADE", 1);
    }

    Card_ClassEx(String kind, int num) {
        this.kind = kind;
        this.num = num;
    }

    public String toString() {
        return kind + ":" + num;
    }
}

