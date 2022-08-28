package com.java.basic.chap14.stream;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class StreamEx8 {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("najava", true, 1, 1, 300),
                new Student2("kimjimi", false, 1, 1, 250),
                new Student2("kimjava", true, 1, 1, 200),
                new Student2("leejimi", false, 1, 2, 150),
                new Student2("namjava", true, 1, 2, 100),
                new Student2("anjimi", false, 1, 2, 50),
                new Student2("hwangjimi", false, 1, 3, 100),
                new Student2("kangjimi", false, 1, 3, 150),
                new Student2("leejava", true, 1, 3, 200),

                new Student2("najava", true, 2, 1, 300),
                new Student2("kimjimi", false, 2, 1, 250),
                new Student2("kimjava", true, 2, 1, 200),
                new Student2("leejimi", false, 2, 2, 150),
                new Student2("namjava", true, 2, 2, 100),
                new Student2("anjimi", false, 2, 2, 50),
                new Student2("hwangjimi", false, 2, 3, 100),
                new Student2("kangjimi", false, 2, 3, 150),
                new Student2("leejava", true, 2, 3, 200),
        };

        System.out.println("1. 단순 그룹화(반별로 그룹화)");
        Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student2::getBan));

        for (List<Student2> ban : stuByBan.values()) {
            for (Student2 s : ban) {
                System.out.println(s);
            }
        }

        System.out.println("\n2. 단순 그룹화 (성적별로 그룹화)");
        Map<Student2.Level, List<Student2>> stuByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                    if (s.getScore() >= 200) return Student2.Level.HIGH;
                    else if (s.getScore() >= 100) return Student2.Level.MID;
                    else return Student2.Level.LOW;
                }));
        TreeSet<Student2.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student2.Level key : keySet) {
            System.out.println("[" + key + "]");

            for (Student2 s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.println("\n3. 단순 그룹화 + 통계 (성적별 학생 수) ");
        Map<Student2.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                    if (s.getScore() >= 200) return Student2.Level.HIGH;
                    else if (s.getScore() >= 100) return Student2.Level.MID;
                    else return Student2.Level.LOW;
                }, Collectors.counting()));

        for (Student2.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        }
        System.out.println();

        System.out.println("\n4. 다중그룹화 (학년별, 반별)");
        Map<Integer, Map<Integer, List<Student2>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student2::getHak,
                         Collectors.groupingBy(Student2::getBan)
                ));

        for (Map<Integer, List<Student2>> hak : stuByHakAndBan.values()) {
            for (List<Student2> ban : hak.values()) {
                System.out.println();
                for (Student2 s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.println("\n5. 다중그룹화 + 통계(학년별, 반별1등)");
        Map<Integer, Map<Integer, Student2>> topStuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student2::getHak,
                        Collectors.groupingBy(Student2::getBan,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student2::getScore))
                                        , Optional::get
                                )
                        )
                ));

        for (Map<Integer, Student2> ban : topStuByHakAndBan.values()) {
            for (Student2 s : ban.values()) {
                System.out.println(s);
            }
        }

        System.out.println("\n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)");
        Map<String, Set<Student2.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        Collectors.mapping(s -> {
                            if (s.getScore() >= 200) return Student2.Level.HIGH;
                            else if (s.getScore() >= 100) return Student2.Level.MID;
                            else return Student2.Level.LOW;
                        }, toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for (String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }
    }
}
