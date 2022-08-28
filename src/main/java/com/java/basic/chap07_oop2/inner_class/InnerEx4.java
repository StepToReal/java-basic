package com.java.basic.chap07_oop2.inner_class;

class Outer {
    class InstanceInner {
        int iv = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }

    void myMethod() {
        class LocalInner {
            int iv = 400;
        }
    }
}

public class InnerEx4 {
    public static void main(String[] args) {
        // 인스턴스 클래스의 인스턴스를 생성하려면 외부 클래스의 인스턴스를 먼저 생성해야 함.
        Outer oc = new Outer();
        Outer.InstanceInner ii = oc.new InstanceInner();

        System.out.println("ii.iv : " + ii.iv);
        System.out.println("outer.staticInner cv : " + Outer.StaticInner.cv);

        // static 내부 클래스 인스턴스는 외부 클래스 인스턴스를 먼저 생성하지 않아도 된다. (외부 클래스에서 바로 접근 가능)
        Outer.StaticInner si = new Outer.StaticInner();
        System.out.println("si.iv" + ": " + si.iv);
    }
}
