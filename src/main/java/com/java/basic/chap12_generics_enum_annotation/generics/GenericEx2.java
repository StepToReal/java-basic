package com.java.basic.chap12_generics_enum_annotation.generics;

public class GenericEx2 {
    public static void main(String[] args) {
        Optional<String> optional = new Optional<>("1234");

        System.out.println(optional.getValue());
        System.out.println(optional.<Integer>empty().getValue());
    }
}

class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    public Optional() {
        value = null;
    };

    public Optional (T t) {
        value = t;
    }

    public T getValue() {
        return value;
    }

    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }
}
