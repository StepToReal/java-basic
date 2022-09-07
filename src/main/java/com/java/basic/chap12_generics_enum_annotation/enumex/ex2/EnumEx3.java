package com.java.basic.chap12_generics_enum_annotation.enumex.ex2;

enum Transportation {
    BUS(100) { int fare(int distance) {return distance*BASIC_FARE;}},
    TRAIN(150) { int fare(int distance) {return distance*BASIC_FARE;}},
    SHIP(100) { int fare(int distance) {return distance*BASIC_FARE;}},
    AIRPLANE(300) { int fare(int distance) {return distance*BASIC_FARE;}};

    protected final int BASIC_FARE; // protected로 해줘야 상수에서 접근 가능

    Transportation(int fare) {
        BASIC_FARE = fare;
    }

    public int getBasicFare() {
        return BASIC_FARE;
    }

    abstract int fare(int distance); // 추상 메서드 선언시 각 상수에서 오버라이딩 해줘야 함.
}
public class EnumEx3 {
    public static void main(String[] args) {
        System.out.println("bus fare = " + Transportation.BUS.fare(100));
        System.out.println("train fare = " + Transportation.TRAIN.fare(100));
        System.out.println("ship fare = " + Transportation.SHIP.fare(100));
        System.out.println("airplane fare = " + Transportation.AIRPLANE.fare(100));

    }
}
