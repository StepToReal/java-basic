package com.java.basic.chap15_IO.io;

import java.io.*;

public class FileReaderEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "src/main/java/com/java/basic/chap15/files/test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;

            while ((data = fis.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            fis.close();

            while ((data = fr.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
