package com.java.basic.chap14.stream;

import java.util.Comparator;
import java.util.stream.Stream;

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName() { return name; }
    int getBan() { return ban; }
    int getTotalScore() { return totalScore; }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("lee", 3, 300),
                new Student("kim", 1, 200),
                new Student("an", 2, 100),
                new Student("park", 2, 150),
                new Student("so", 1, 200),
                new Student("na", 3, 290),
                new Student("kam", 3, 180)
        );

//        studentStream.sorted(Comparator.naturalOrder()).forEach(System.out::println);

        studentStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
    }
}
