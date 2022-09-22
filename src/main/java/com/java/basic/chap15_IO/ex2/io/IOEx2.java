package com.java.basic.chap15_IO.ex2.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length); // 읽어온 데이터를 temp에 담는다.
        output.write(temp, 5, 5); // temp[5] 부터 5개 데이터를 write 한다. outputStream이 일종의 버퍼? 스트림에 담아놓기?

        outSrc = output.toByteArray();

        System.out.println("input source : " + Arrays.toString(inSrc));
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("output source : " + Arrays.toString(outSrc));
    }
}
