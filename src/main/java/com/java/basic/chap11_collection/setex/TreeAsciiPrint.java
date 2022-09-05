package com.java.basic.chap11_collection.setex;

public class TreeAsciiPrint {
    public static void main(String[] args) {
        char ch = ' ';

        for (int i = 0; i < 95; i++) {
            System.out.print(ch++);

            if (i % 30 == 0) System.out.println();
        }

        System.out.println();
    }
}
