package com.java.basic.chap08_exception;

import java.io.FileNotFoundException;

public class ExceptionEx10 {
    public static void main(String[] args) {
        throw new RuntimeException("test"); // 컴파일 오류는 없음 하지만 실행 시키면 오류 발생 됨.
//        throw new FileNotFoundException(); //unhandled compile 오류 발생 FileNotFoundException 은 Runtime 자손이 아님
//        throw new Exception("error"); // unhandled compile 오류 발생

        /*
         RuntimeException 및 그 자손 예외들은 예외처리를 강제하지 않는다.
         만일 강제 했다면 배열, 참조변수 등이 사용되는 모든 곳에 예외 처리가 강제 됐어야 할 것이다. (IndexOutOfBound, NullPointException 등..)

         컴파일러가 예외처리를 확인하지 않는 RuntimException 클래스들을 unchecked 예외라 하며
         예외처리를 확인하는 Exception 클래스 들은 checked 예외 라고 부른다.
         */
    }
}
