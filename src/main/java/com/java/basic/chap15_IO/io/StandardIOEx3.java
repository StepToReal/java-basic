package com.java.basic.chap15_IO.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx3 {
    public static void main(String[] args) {
        PrintStream ps = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("src/main/java/com/java/basic/chap15/files/test2.txt");
            ps = new PrintStream(fos);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
        System.out.println("Hello by System.out");
        System.err.println("Hello by System.err");
    }
}
