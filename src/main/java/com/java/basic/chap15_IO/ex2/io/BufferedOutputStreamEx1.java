package com.java.basic.chap15_IO.ex2.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        String path = Paths.get(FileExamConstant.FILE_PATH, "123.txt").toAbsolutePath().toString();

        try {
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
