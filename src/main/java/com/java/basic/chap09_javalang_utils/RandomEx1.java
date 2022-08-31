package com.java.basic.chap09_javalang_utils;

import java.util.Random;

public class RandomEx1 {
    public static void main(String[] args) {
        Random rand = new Random(1); //인자는 seed (난수를 만드는 기준 값, seed 가 같으면 같은 난수가 발생함)
        Random rand2 = new Random(1);//인자를 주지 않으면 seed는 System.currentTimeMills() 임

        //Math.random() 도 내부적으로 Random 클래스의 인스턴스를 생성하여 사용함.
        //무엇을 사용하던지 상관은 없는데 Random 인스턴스를 사용하면 nextInt, nextDouble 등 타입을 지정할 수 있기 때문에 형변환을 하지 않아도 된다는 장점이 있다.

        System.out.println("==rand==");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " : " + rand.nextInt());
        }

        System.out.println();
        System.out.println("==rand2==");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " : " + rand2.nextInt());
        }
    }
}
