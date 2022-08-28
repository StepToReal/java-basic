package com.java.basic.chap12.generics;

import java.util.ArrayList;
import java.util.List;

class Test<T> {
    ArrayList<T> list = new ArrayList<>();

    public static <T> T getFirstValue(T t1, T t2, T t3) {
        List<T> list = new ArrayList<>();

        list.add(t1);
        list.add(t2);
        list.add(t3);

        return list.get(0);
    }

    public <E> E getLastValue(E e1, E e2) {
        return e1;
    }
}

public class GenericsEx {
}
