package com.java.basic.chap12_generics_enum_annotation.generics.fruit1_2;

import java.util.ArrayList;

class Fruit { public String toString() {return "Fruit";}}
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}
class Toy { public String toString() { return "Toy"; }}

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
//        Box<Grape> grapeBox = new Box<Apple>(); //error 타입 불일치
//        Box<Fruit> fruitBox1 = new Box<Apple>(); // 타입매개변수에서는 상속관계 적용 안됨
        Box<? extends Fruit> fruitBox1 = new Box<Apple>(); // 와일드 카드를 사용하면 지네릭 타입 매개변수에 다형성 적용 가능
        Box<Toy> toyBox = new Box<>();
        Box<Apple> smallBox = new SmallBox<Apple>(); // 상속관계 클래스에 같은 타입 적용은 가능.

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
//        appleBox.add(new Toy()); // error AppleBox 에는 Apple 타입만 가능

        System.out.println(fruitBox);
        System.out.println(appleBox);
    }
}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}

class SmallBox<T> extends Box<T> {

}