package com.java.basic.chap07_oop2;

/*
 interface default method 충돌 해결 방법
 1. 여러 인터페이스의 디폴트 메서드 간의 충돌 시 - 구현 클래스에서 오버라이딩 해야함
 2. 디폴트 메서드와 조상 클래스 간에 메서드 충돌 시 - 조상 클래스 메서드 상속됨, 디폴드 메서드는 무시됨.
 */
public class DefaultMethodTest {
    public static void main(String[] args) {
        Child c = new Child();

        c.method1();
        c.method2();
        MyInterface.staticMethod();
        MyInterface2.staticMethod();
    }
}

class Child extends BindingTestParent implements MyInterface, MyInterface2 {
    public void method1() {
        System.out.println("method1() in Child");
    }
}

class Parent {
    public void method2() {
        System.out.println("method2() in Parent");
    }
}

interface MyInterface {
    default void method1() {
        System.out.println("method1() in MyInterface");
    }

    default void method2() {
        System.out.println("method2() in MyInterface");
    }

    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface");
    }
}

interface MyInterface2 {
    default void method1() {
        System.out.println("method1() in MyInterface2");
    }

    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface2");
    }
}