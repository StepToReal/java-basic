package com.java.basic.chap09_javalang_utils;

import java.util.StringJoiner;

public class StringEx1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        System.out.println(str1 == str2);

        str2 = "abcd";

        System.out.println(str1 == str2);

        str2 = "abc";

        System.out.println(str1 == str2);

        
    }
}
