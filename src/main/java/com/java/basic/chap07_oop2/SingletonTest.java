package com.java.basic.chap07_oop2;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        // Singleton s1 = new Singleton();
    }
}

final class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton () {}

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}