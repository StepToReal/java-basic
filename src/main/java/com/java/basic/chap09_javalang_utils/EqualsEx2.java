package com.java.basic.chap09_javalang_utils;

public class EqualsEx2 {
    public static void main(String[] args){
        Person p1 = new Person(123123L);
        Person p2 = new Person(123123L);

        if (p1 == p2) {
            System.out.println("p1 equals p2");
        } else {
            System.out.println("p1 and p2 other person");
        } 

        if (p1.equals(p2)) {
            System.out.println("p1 equals p2");
        } else {
            System.out.println("p1 and p2 other person");
        } 
    }
}

class Person {
    long id;

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            return id == ((Person)obj).id;
        } else {
            return false;
        }
    }

    Person (long id) {
        this.id = id;
    }
}
