package com.java.basic.chap15_IO.ex2.io;

import java.io.*;
import java.nio.file.Paths;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = Paths.get(FileExamConstant.IO_PATH, "FileCopy.java").toAbsolutePath().toString();
        String targetPath = Paths.get(FileExamConstant.IO_PATH, "FileCopy.back").toAbsolutePath().toString();

        try {
            FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(targetPath);

            int data = 0;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
