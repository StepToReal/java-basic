package com.java.basic.chap07_oop2.inner_class;

class OuterEx5 {
    int value = 10;

    class Inner {
        int value = 20;

        void method1() {
            int value = 30;
            System.out.println(" value : " + value);
            System.out.println(" this.value : " + this.value);
            System.out.println(" OuterEx5.this.value : " + OuterEx5.this.value);
        } // 내부 클래스와 외부 클래스에 변수 이름이 같을때 this or 외부클래스명.this 를 붙여 구분 가능
    }
}

public class InnerEx5 {
    public static void main(String[] args) {
        OuterEx5 outer = new OuterEx5();

        OuterEx5.Inner inner = outer.new Inner();

        inner.method1();
    }
}
