package com.java.basic.chap15.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/com/java/basic/chap15/files/123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
