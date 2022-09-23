package com.java.basic.chap15_IO.ex2.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileViewer {
    public static void main(String[] args) throws IOException {
        String path =  "FileViewer.java";

        Path path1 = Paths.get(FileExamConstant.IO_PATH, path);

        System.out.println(path1.toAbsolutePath());

        FileInputStream fis = new FileInputStream(path1.toAbsolutePath().toString());
        int data = 0;

        while ((data = fis.read()) != -1) {
            char c = (char) data;
            System.out.print(c);
        }
    }
}
