package com.java.basic.chap12_generics_enum_annotation.generics.fruit2_1;

import org.w3c.dom.html.HTMLParagraphElement;

import java.util.ArrayList;

interface Eatable {}

class Fruit implements Eatable {
    public String toString() { return "Fruit"; }
}
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}
class Toy { public String toString() { return "Toy"; }}

public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // error FruitBox 지네릭 조건에 맞지 않음.
        Box<Toy> toyBox = new Box<>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
//        appleBox.add(new Grape()); // Grape는 Apple의 자손이 아님
    }
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {} //지네릭 타입으로 Fruit 와 Eatable 을 상속받은 타입만 올 수 있다.
                                                            //지네릭 타입에 extends 조건으로 or가 올 수는 없음.

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}