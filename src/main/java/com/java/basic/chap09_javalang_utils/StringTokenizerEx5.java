package com.java.basic.chap09_javalang_utils;

import java.util.StringTokenizer;

public class StringTokenizerEx5 {

    public static void main(String[] args) {
        String data = "100,,,200,300";

        String[] result = data.split(",");
        StringTokenizer st = new StringTokenizer(data, ",");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + "|");
        }

        System.out.println("cont:" + result.length);

        int i = 0;
        for (i = 0; st.hasMoreTokens(); i++) {
            System.out.println(st.nextToken() + "|");
        }

        System.out.println("count : " + i);
    }
}
