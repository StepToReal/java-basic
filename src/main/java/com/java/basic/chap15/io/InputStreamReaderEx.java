package com.java.basic.chap15.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
    public static void main(String[] args) {
        String line = "";

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("사용중인 OS의 인코딩 : " + isr.getEncoding());

            do {
                System.out.print("문장을 입력하게요. 마치려면 q를 입력하세요.>");
                line = br.readLine();
                System.out.println("입력하신 문장 : " + line);
            } while (!line.equalsIgnoreCase("q"));

            br.close();
            System.out.println("프로그램을 종료 합니다.");
        } catch (IOException e) {}
    }
}
