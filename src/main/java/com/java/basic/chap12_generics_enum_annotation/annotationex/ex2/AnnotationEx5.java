package com.java.basic.chap12_generics_enum_annotation.annotationex.ex2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.sql.SQLOutput;

@Deprecated
@SuppressWarnings("111")
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"), count = 2, testTools = {"1", "2", "3"})
public class AnnotationEx5 {
    public static void main(String[] args) {
        Class<AnnotationEx5> cls = AnnotationEx5.class;
        TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);

        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());

        for (String s : anno.testTools()) {
            System.out.println("testTools = " + s);
        }

        System.out.println();

        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation a : annoArr) {
            System.out.println(a);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME) //실행 시 사용 가능하도록 지정
@interface TestInfo {
    int id = 10; //상수 선언과 같다. = static final int id = 10;
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType {FIRST, FINAL,}