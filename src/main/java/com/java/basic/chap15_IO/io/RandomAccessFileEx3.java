package com.java.basic.chap15_IO.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx3 {
    public static void main(String[] args) {
        int sum = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile("src/main/java/com/java/basic/chap15/files/score2.dat", "r");
            int i = 4;

            while (true ) {
                raf.seek(i);
                sum += raf.readInt();
                i += 16;
            }
        } catch (EOFException eof) {
            System.out.println("sum : " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
