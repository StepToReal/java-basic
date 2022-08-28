package com.java.basic.chap07_oop2.inner_class;

public class InnerEx2 {
    class InstanceInner {}
    static class StaticInner{}

    // 인스턴스 맴버간에 직접 접근이 가능하다.
    InstanceInner iv = new InstanceInner();

    // static 맴버간에 직접 접근이 가능하다.
    StaticInner cv = new StaticInner();
    static StaticInner staticCv = new StaticInner();

    static void staticMethod() {
        //static 맴버는 인스턴스 맴버에 접근할 수 없다.
        // InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        //굳이 접근하려면 아래와 같이 객체를 생성해야 한다. 인스턴스 클래스는 외부 클래스를 먼저 생성해야만 생성 할 수 있다.
        InnerEx2 outer = new InnerEx2();
        InstanceInner obj1 = outer.new InstanceInner();
    }

    void instanceMethod() {
        // 인스턴스 메서드에서는 인스턴스 맴버와 static 맴버 모두 접근 가능하다.
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        //메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없다.
        // LocalInner lv = new LocalInner();
    }

    void myMethod() {
        class LocalInner {}
        LocalInner lv = new LocalInner();
    }
}
