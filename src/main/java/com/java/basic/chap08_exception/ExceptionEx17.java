package com.java.basic.chap08_exception;

public class ExceptionEx17 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("main 메서드에서 예외가 처리되었습니다.");
        }

        System.out.println(method2());
    }

    // 예외 처리 후 예외를 던져 호출한 메서드에서도 예외 처리를 할 수 있다. 이를 예외 되던지기 라고 한다.
    static void method1() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("method1 메서드에서 예외가 처리되었습니다.");
            throw e;
        }
    }

    //finally 블럭에 return 문을 사용하게 되면 try, catch 에 내용에 상관없이 finally 블럭의 return 값이 반환된다.
    static int method2() {
        try {
            throw new Exception();
//            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            return 2;
        }
    }
}
