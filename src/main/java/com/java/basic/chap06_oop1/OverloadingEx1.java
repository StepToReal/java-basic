package com.java.basic.chap06_oop1;

public class OverloadingEx1 {
    //오버로딩의 조건 1. 메서드 이름이 같아야 한다. 2. 매개변수의 타입, 수, 순서가 달라야 한다.
    //return 타입은 오버로딩 구현에 영향을 끼치지 않는다. return 타입이 다르다고 해서 호출 시점에 메서드를 특정할 수 없다.

    public int add(int a, int b) {
        return a + b;
    }

    public long add(long a, int b) { //1번과 타입이 다름
        return a + b;
    }

    public long add(int a, long b) { //2번과 순서가 다름
        return a + b;
    }

    public int add(int a, int b, int c) { //1번과 개수가 다름
        return a + b + c;
    }

    public int add(int[] a) {
        int sum = 0;

        for (int item : a) {
            sum += item;
        }

        return sum;
    }
}
