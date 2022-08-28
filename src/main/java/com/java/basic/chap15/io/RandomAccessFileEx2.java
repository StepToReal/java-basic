package com.java.basic.chap15.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {
    public static void main(String[] args) {
//                     번호, 국어, 영어, 수학
        int[] score = {1, 100, 90, 90,
                       2, 70, 90, 100,
                       3, 100, 100, 100,
                       4, 70, 60, 80,
                       5, 70, 90, 100};

        try {
            RandomAccessFile raf = new RandomAccessFile("src/main/java/com/java/basic/chap15/files/score2.dat", "rw");
            for (int i = 0; i < score.length; i++) {
                raf.writeInt(score[i]);
            }

            raf.seek(0);
            while (true) {
                System.out.println(raf.readInt());
            }
        } catch (EOFException eof) {
            //readInt() 를 호출했을 때 더이상 읽을 내용이 없으면 발생
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
