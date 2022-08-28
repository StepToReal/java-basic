package com.java.basic.chap11.setex;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx4 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);
    }
}

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Person2) {
            Person2 temp = (Person2)obj;
            return name.equals(temp.name) && age == temp.age;
        }

        return false;
    }

    public int hashCode() {
//        return (name + age).hashCode();
        return Objects.hash(name, age); //java 8 부터 추가된 형식 위 형식보다는 아래 형식을 사용하자
    }

    public String toString() {
        return name + ":" + age;
    }
}
