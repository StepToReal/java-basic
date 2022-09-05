package com.java.basic.chap12_generics_enum_annotation.generics.fruit2;


import java.util.ArrayList;

class Fruit implements Eatable {
    public String toString() { return "Fruit"; }
}

class Apple extends Fruit { public String toString() {return "Apple"; }}
class Grape extends Fruit { public String toString() {return "Grape"; }}
class Toy { public String toString() {return "Toy"; }}

interface Eatable {}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i) {return list.get(i); }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();
//        FruitBox<Grape2> grapeBox = new FruitBox<Apple2>(); error not equals type
//        FruitBox<Toy2> toyBox = new FruitBox<Toy2>();  error

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
//        appleBox.add(new Grape()); error grape is not sun of apple
        grapeBox.add(new Grape());

        System.out.println("fruitBox - " + fruitBox);
        System.out.println("appleBox - " + appleBox);
        System.out.println("grapeBox - " + grapeBox);
    }
}
