package com.java.basic.chap15_IO.ex2.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class BufferedReaderEx1 {
    public static void main(String[] args) {
        String path = Paths.get(FileExamConstant.IO_PATH, "BufferedReaderEx1.java").toAbsolutePath().toString();

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line = "";

            for (int i = 1; (line = br.readLine()) != null; i++) {
                if (line.indexOf(";") != -1) {
                    System.out.println(i + ":" + line);
                }
            }

            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
