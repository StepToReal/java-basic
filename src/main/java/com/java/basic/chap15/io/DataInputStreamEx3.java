package com.java.basic.chap15.io;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx3 {
    public static void main(String[] args) {
        int sum = 0;
        int score = 0;

        try (FileInputStream fis = new FileInputStream("src/main/java/com/java/basic/chap15/files/score.dat");
             DataInputStream dis = new DataInputStream(fis)) {

            while (true) {
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
        } catch (EOFException e) {
            System.out.println("점수의 총합은 " + sum + " 입니다.");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
