package com.java.basic.chap12_generics_enum_annotation.generics;

import org.jetbrains.annotations.NotNull;

public class GenericEx4 {
    // GenericEx3 번에 대해 .. 그냥 아래처럼 하면 되는거 아닌가? MyClass <T extends MyClass<T>> 를 하면 어떤 이점이 있는거지?
    // 차이점 1: 위의 제네릭 형식은 Enum 에 선언된 제네릭 형식으로 자식 클래스들 간 비교가 아닌 동일한 자식 클래스들 끼리만 비교가 가능하게 하기 위함.
    // 차이점 2: 동일 자식 클래스들 끼리만 비교를 하게 하려면 compareTo를 자식 클래스 마다 오버라이딩 해줘야 하는데 위 제네릭 방식을 사용하면 코드 중복을 줄일 수 있다.

    public static void main(String[] args) {
        PlanA a = new PlanA();
        PlanB b = new PlanB();

        System.out.println(a.compareTo(b));
    }
}

class MyPlan implements Comparable<MyPlan> {
    static int id = 0;
    int ordinal;

    MyPlan() {
        ordinal = id;
        id++;
    }

    @Override
    public int compareTo(@NotNull MyPlan o) {
        return ordinal - o.ordinal;
    }
}

class PlanA extends MyPlan {
}

class PlanB extends MyPlan {
}