package com.java.basic.chap15_IO.ex2.io;

import java.io.*;
import java.nio.file.Paths;

public class FileReaderEx1 {
    public static void main(String[] args) {
        String path = Paths.get(FileExamConstant.FILE_PATH, "test.txt").toAbsolutePath().toString();

        try {
            FileInputStream fis = new FileInputStream(path);
            FileReader fr = new FileReader(path);

            int data = 0;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
            fis.close();

            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
