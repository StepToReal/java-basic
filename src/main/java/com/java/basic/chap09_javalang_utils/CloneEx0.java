package com.java.basic.chap09_javalang_utils;

import java.util.Arrays;

// clone은 인스턴스 변수의 값을 복사하여 새로운 인스턴스를 생성
// 때문에 인스턴스 변수에 참조변수가 있으면 완전한 인스턴스 복제가 이루어 지지 않음.
public class CloneEx0 {
    public static void main(String[] args) {
        UserC user1 = new UserC("kim", 17);
        UserC user2 = (UserC)user1.clone();

        user2.name = "park";
        user2.age = 20;

        System.out.println(user1.toString());
        System.out.println(user2.toString());

        ScoreC score1 = new ScoreC("Math", new int[] {50, 20, 60, 10, 100});
        ScoreC score2 = score1.clone(); //공변 반환 타입 적용

        score2.scoreName = "English";
        score2.scoreArr[0] = 90; // 여기서 변경하면 score1 도 바뀜.
                                 // clone은 변수의 값을 복사하기 때문에 참조 변수의 경우 원하지 않게 원본 데이터를 수정하게 됨.
                                 // clone method 에서 배열에 대해서는 신규 배열을 생성하고 내용을 복사하도록 처리가 필요함.

        System.out.println(score1.toString());
        System.out.println(score2.toString());

        CloneTest test = new CloneTest("clone");
        CloneTest test2 = test.clone(); //공변 반환 타입

        test2.name = "clone2";

        System.out.println(test.toString());
        System.out.println(test2.toString());
    }
}

class UserC implements Cloneable{ //인스턴스 데이터 보호를 위해 Cloneable을 구현한 클래스에서만 super.clone() 호출 가능함. 구현 없이 clone 호출하면 error
    String name;
    int age;

    UserC(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }

    @Override
    public Object clone() {
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        return obj;
    }
}

class ScoreC implements Cloneable {
    String scoreName;
    int[] scoreArr;

    ScoreC(String name, int[] scores) {
        scoreName = name;
        scoreArr = scores;
    }

    @Override
    public String toString() {
        return "name: " + scoreName + ", " + Arrays.toString(scoreArr);
    }

    @Override
    public ScoreC clone() { //공변반환 타입
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        return (ScoreC) obj;
    }
}

class CloneTest {
    String name;

    CloneTest(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public CloneTest clone() { //공변반환 타입 적용
        return new CloneTest(name);
    }
}
