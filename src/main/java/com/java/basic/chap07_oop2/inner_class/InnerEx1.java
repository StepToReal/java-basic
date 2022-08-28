package com.java.basic.chap07_oop2.inner_class;

/*
내부 클래스 장점 -
1. 내부 클래스에서 외부 클래스의 맴버들을 쉽게 접근할 수 있다.
2. 외부에서 불필요한 클래스를 감춰 코드 복잡성을 줄일 수 있다.
* 내부 클래스는 외부 클래스를 제외하고는 다른 클래스에서 잘 사용되지 않는 것이어야 한다.
 */
public class InnerEx1 {
    class InstanceInner {
        int iv = 100;
        // static int cv = 100; //error! 내부 인스턴스 클래스에서 static 변수를 선언할 수 없다. (외부 클래스가 인스턴스화 되어야 내부 인스턴스 클래스가 생성되기 때문 인 듯)
        final static int CONST = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 200; // static 내부 클래스에서만 static 변수를 사용할 수 있다.
    }

    void myMethod() {
        class LocalInner {
            int iv = 300;
            // static int cv = 300; // error! 내부 지역 클래스에서 static 선언 불가
            final static int CONST = 300;
        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
    }
}
