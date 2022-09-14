package com.java.basic.chap15_IO.io;

import java.io.IOException;

public class StandardIOEx1 {
    public static void main(String[] args) {
        try {
            int input = 0;

            while ((input = System.in.read()) != -1) {
                System.out.print("input : " + input + ", (char)input : " + (char)input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
