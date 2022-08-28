package com.java.basic.chap08_exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResourceEx2 {
    public static void main(String[] args) {
        // try, finally에 모두 예외가 발생하면 try 블럭의 예외는 무시된다는 내용 (p.436) Test
        try {
            throw new IOException("IO Exception occurred");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                throw new Exception("Exception occurred");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // try, finally 두 블럭에 예외 모두 정상 처리 됨..

        try {
            testException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 위와 같은 경우는 finally Exception만 보여짐.
    }
    
    static void testException() throws Exception {
        try {
            throw new Exception("try Exception");
        } finally {
            throw new Exception("finally Exception");
        }
    }
}
