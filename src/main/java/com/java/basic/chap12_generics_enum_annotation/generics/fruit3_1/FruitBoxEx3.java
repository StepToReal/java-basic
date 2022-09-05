package com.java.basic.chap12_generics_enum_annotation.generics.fruit3_1;

import java.util.ArrayList;

class Fruit { public String toString() {return "Fruit";}}
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}

class Juice {
    String name;

    Juice(String name) { this.name = name + "Juice"; }
    public String toString() { return name; }
}

class Juicer {
    /*
    static 메서드에는 타입변수 사용 불가로 지네릭을 사용하지 않던가 특정 타입을 지정해 줘야 함.
    단 이렇게 하면 Fruit<Fruit> 로 지정한 경우 Fruit<Apple>은 매개변수로 받을 수 없음. (지네릭 타입간 다형성은 적용안됨)
    이때 와일드카드 "?" 를 사용함. 와일드카드는 어떤 타입도 될 수 있음 <Object>와 동일함.
    <? extends Fruit> 는 와일드카드의 상한 제한 - Fruit 와 그 자손만 올 수 있음.
    <? super Fruit> 는 와일드카드 하한 제한 - Fruit 와 그의 조상들만 올 수 있음.
     */
    static Juice makeJuice(FruitBox<? extends Fruit> box) {
        String temp = "";

        for (Fruit f : box.getList()) {
            temp += f + " ";
        }

        return new Juice(temp);
    }
}

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    }
}

class FruitBox <T extends Fruit> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) { list.add(item); }
    ArrayList<T> getList() { return list; }
    T get(int i) { return list.get(i); }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}