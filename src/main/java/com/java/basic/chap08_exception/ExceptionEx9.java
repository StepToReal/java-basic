package com.java.basic.chap08_exception;

public class ExceptionEx9 {
    public static void main(String[] args) {
        try {
            // Exception e = new Exception("error occurred");
            // throw e;
            throw new Exception("error occurred");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Program end");
    }
}
