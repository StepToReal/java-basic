package com.java.basic.chap03_operator;

public class OperatorEx30 {
    public static void main(String[] args) {
        int a = 8;

        String zero = "00000000000000000000000000000000";
        String temp = zero + Integer.toBinaryString(a);
        String temp1 = zero + Integer.toBinaryString(~a);

        System.out.println(temp.substring(temp.length() - 32));
        System.out.println(temp1.substring(temp1.length() - 32));

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(~a));
    }   
}
