package com.java.basic.chap07_oop2;

public class OverridingTest {
    public static void main(String[] args) {

    }
}

class IntegerPoint {
    int a;
    int b;

    public int sum() {
        return a + b;
    }

    public IntegerPoint returnObject() {
        return this;
    }

    protected void testOverriding() {

    }
}

class DoublePoint extends IntegerPoint {
    double c;

    //error - return type 변경 불가
//    public double sum() {
//        return a + b + c;
//    }

    public DoublePoint returnObject() { //공변 반환타입은 조상 메서드가 자신을 return 할때 자손 메서드가 자손 타입으로 반환할 수 있는것
        return this;
    }

    //error - return type 변경 불가
//    public DoublePoint testOverwriting() {
//        return this;
//    }

    @Override
    public void testOverriding() {

    }

    //error - 접근 제한자는 부모타입 메서드보다 넓은 범위만 가능하다.
//    @Override
//    private void testOverriding() {
//
//    }
}
