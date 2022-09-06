package com.java.basic.chap12_generics_enum_annotation.generics;

public class GenericMethodEx1 {
    public static void main(String[] args) {
        Type<String> stringType = new Type<>("abcd");
        Type<Integer> intType = new Type<>(100);

        System.out.println(stringType.getValue());
        System.out.println(intType.getValue());

        stringType.print(200);
        intType.print("intType");

        Type.StaticPrint(300);
        Type.StaticPrint("Type");
        Type.StaticPrint(10.2);
        Type.<Float>StaticPrint(20.1f);
    }
}

class Type <T> {
    T value;

    public Type (T t) {
        value = t;
    }

    public T getValue() {
        return value;
    }

    public <T> void print(T t){
        System.out.println(t.toString());
    }

    public static <T> void StaticPrint(T t) {
        System.out.println(t.toString());
    }
}
