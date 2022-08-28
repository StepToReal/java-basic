package com.java.basic.chap14.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    String getName() { return name; }
    boolean isMale() { return isMale; }
    int getHak() { return hak; }
    int getBan() { return ban; }
    int getScore() { return score; }

    public String toString() {
        return String.format("[%s, %s, %d학년, %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    enum Level { HIGH, MID, LOW }
}

public class StreamEx7 {
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

        System.out.println("1. 단순분할 (성별로 분할)");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        for (Student2 s : maleStudent) System.out.println(s);
        for (Student2 s : femaleStudent) System.out.println(s);

        System.out.println("n2. 단순분할 + 통계 (성별 학생 수)");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale, Collectors.counting()));

        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));

        System.out.println("\n3. 단순분할 + 통계 (성별 1등) ");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale, Collectors.maxBy(Comparator.comparingInt(Student2::getScore))
                ));

        System.out.println("남학생 1등 : " + topScoreBySex.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student2::getScore)), Optional::get
                        )
                ));

        System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));

        System.out.println("\n4. 다중분할 (성별 불합격자, 100점 이하)");
        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale, Collectors.partitioningBy(s -> s.getScore() <= 100)));

        List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

        for (Student2 s : failedMaleStu) System.out.println(s);
        for (Student2 s : failedFemaleStu) System.out.println(s);
    }
}
