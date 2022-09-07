package com.java.basic.chap12_generics_enum_annotation.enumex.ex2;

import org.jetbrains.annotations.NotNull;

public class EnumEx4 {
    public static void main(String[] args) {
        MyEnum<MyEnum2> myEnum;
    }
}

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0;
    int ordinal;
    String name = "";

    public int ordinal() { return ordinal; }

    MyEnum(String name) {
        this.name = name;
        ordinal = id++;
    }

    public int compareTo(T t) {
        return ordinal - t.ordinal;
    }
}

class MyEnum2 extends MyEnum<MyEnum2> {

    MyEnum2(String name) {
        super(name);
    }
}

abstract class MyTransportation extends MyEnum<MyTransportation> {
    static final MyTransportation BUS = new MyTransportation("BUS", 100) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 300) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };

    protected final int BASIC_FARE;
    abstract int fare(int distance);

    private MyTransportation(String name, int basicFare) {
        super(name);
        BASIC_FARE = basicFare;
    }

    public String name() {
        return name;
    }

    public String toString() {
        return name;
    }
}