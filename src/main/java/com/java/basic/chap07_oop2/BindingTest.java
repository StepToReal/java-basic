package com.java.basic.chap07_oop2;

/*
 다형성을 이용하여 자식 인스턴스를 부모 타입에 대입할때 변수는 익히 알다 싶이 실제 인스턴스 변수의 매서드가 실행된다.
 하지만 같은 이름의 변수를 호출했을 때는 타입에 따라 호출되는 변수가 다르다.
 ( 부모 타입 변수 --> 부모 클래스에 정의된 변수, 자식 타입 변수 --> 자식 클래스에 정의된 변수)
 지정된 타입에 상관없이 동작하는건 인스턴스 메서드 밖에 없다 (타입에 상관없이 실제 저장된 객체의 메서드가 실행 됨)
 그 밖에 인스턴수 변수, static 변수, static 메서드 등은 타입에 따라 호출되는 결과가 달라진다.
 */
public class BindingTest {
    public static void main(String[] args) {
        BindingTestParent p = new BindingTestChild();
        BindingTestParent p2 = new BindingTestChild(30);
        BindingTestChild c = new BindingTestChild();

        System.out.println(p.x + ", " + p2.x + ", " + c.x);

        p.method();
        c.method();

        //객체로 static method를 호출하는게 안되는건 아닌데 사실 이러면 안된다.
        //static method는 class.staticMethod() 형식으로 접근해야 옳다.
        p.staticMethod();
        c.staticMethod();
    }
}

class BindingTestParent {
    int x = 100;

    BindingTestParent() {
        this(200);
    }

    BindingTestParent(int x) {
        this.x = x;
    }

    void method() {
        System.out.println("Parent method");
    }

    static void staticMethod() {
        System.out.println("Parent static method");
    }
}

class BindingTestChild extends BindingTestParent {
    int x = 10;

    BindingTestChild() {
        this(20);
    }

    BindingTestChild(int x) {
        this.x = x;
    }

    void method() {
        System.out.println("Child method");
    }

    static void staticMethod() {
        System.out.println("Child static method");
    }
}
