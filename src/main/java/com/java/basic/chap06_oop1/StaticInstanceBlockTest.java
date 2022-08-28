package com.java.basic.chap06_oop1;

public class StaticInstanceBlockTest {
    private int temp = 0; //3 //7

    public static void main(String[] args) {
        StaticInstanceBlockTest basic = new StaticInstanceBlockTest(); //2
        StaticInstanceBlockTest basic2 = new StaticInstanceBlockTest(); //6
    }

    static { //클래스 초기화 블럭
        System.out.println("static { }"); //1
    }

    public StaticInstanceBlockTest() {
        System.out.println("creator { }"); //5 //9
    }

    { //인스턴스 초기화 블럭 - 모든 생성자에서 공통적으로 수행되는 코드를 넣는다.
        System.out.println("instance { }"); //4 //8
    }
    
    //클래스 변수 초기화 순서 : 기본값 -> 명시적초기화 -> 클래스 초기화 블럭
    //인스턴스 변수 초기화 순서 : 기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자
}

class Car {
    String color;
    String gearType;
    int door;

    Car() {
        this ("white", "Auto", 4);
    }

    Car(Car c) {
        // color = c.color;
        // gearType = c.gearType;
        // door = c.door;
        this (c.color, c.gearType, c.door);
    }

    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}