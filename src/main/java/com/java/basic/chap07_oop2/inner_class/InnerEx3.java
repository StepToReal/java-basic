package com.java.basic.chap07_oop2.inner_class;

public class InnerEx3 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv; // 외부 클래스 private 맴버도 접근 가능하다.
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // int siv = outerIv; //static 클래스는 외부 클래스의 인스턴스 맴버에 접근 불가.
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0;
        final int LV = 0;

        class LocalInner {
            // 지역 클래스 에서는 외부 클래스의 인스턴스 맴버와 static 맴버 모두 접근 가능
            // 지역 변수도 접근 가능하나 final (상수) 만 접근가능
            // - 메서드가 수행을 마쳐 지역변수가 소멸된 시점에도 지역 클래스의 인스턴스가 소멸된 지역 변수를 참조하려는 경우 때문
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv; // JDK1.8 부터 에러 아님. 그전에는 에러 (lv는 final이 아님 JDK 1.8 부터는 컴파일러가 final 붙여줌)
            int liv4 = LV;
        }

//        lv = 10; // 이렇게 하면 위에 liv3 = lv 에서 에러남 lv 가 final이 아니게 되기 때문.
    }
}
