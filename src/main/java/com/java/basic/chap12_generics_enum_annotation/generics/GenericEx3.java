package com.java.basic.chap12_generics_enum_annotation.generics;

import org.jetbrains.annotations.NotNull;

public class GenericEx3 {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.ordinal = 10;

        MyClass mc2 = new MyClass();
        mc2.ordinal = 20;

        System.out.println(mc.compareTo(mc2));

        MyClass<MyClassChild> mc3 = new MyClass<>();
        mc3.ordinal = 10;

        MyClass<MyClassChild> mc4 = new MyClass<>();
        mc4.ordinal = 20;

        // error - mc2 의 compareTo 인자는 MyClassChild 여야하는데 mc3는 MyClass 임.
//        System.out.println(mc3.compareTo(mc4));

        MyClassChild mcc = new MyClassChild();
        MyClassChild mcc2 = new MyClassChild();
        MyClassChild2 mcc3 = new MyClassChild2();

        mcc.ordinal = 10;
        mcc2.ordinal = 20;
        mcc3.ordinal = 30;

        System.out.println(mcc.compareTo(mcc2));
        System.out.println(mcc3.compareTo(mcc));
    }
}

class MyClass <T extends MyClass<T>> implements Comparable<T> {
    // T 는 MyClass<T> 의 자손이어야 한다.
    // MyClass는 자신을 구현한 자손타입을 제네릭 인자로 받아 자손타입끼리 ordinal을 비교할 수 있게 해준다.
    // MyClass는 자기 스스로 객체를 만드는게 큰 의미가 없으므로
    T value;
    int ordinal;

    @Override
    public int compareTo(@NotNull T o) {
        return ordinal - o.ordinal;
    }
}

class MyClassChild extends MyClass<MyClassChild> {
    // MyClass<MyClassChild> 를 상속받아 아래와 같은 구조를 상속 받는다.
    // MyClassChild 는 MyClass를 상속받고, MyClass는 MyClassChild를 인스턴스 변수 및 compareTo 의 매개변수 타입을 갖는다.
//    MyClassChild value;
//    int ordinal;
//
//    @Override
//    public int compareTo(MyClassChild o) {
//        return ordinal - o.ordinal;
//    }
}

class MyClassChild2 extends MyClass<MyClassChild> {

}
