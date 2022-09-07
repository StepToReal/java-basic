package com.java.basic.chap12_generics_enum_annotation.enumex.ex2;

/*
enum에 생성자를 추가하고 변수를 추가하는 것은 각 enum item 마다 추가적인 다른 값을 주기 위한 것임.
실제 생성자를 이용해 enum 객체를 생성한다던가 새로운 item을 추가한다던가 하는 작업은 없음.
enum 상수 하나하나가 enum 선언에 대한 객체라고 보면 이해가 조금 됨..
 */
enum Direction2 {
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

    private static final Direction2[] DIR_ARR = Direction2.values();
    private final int value; // 맴버변수는 final 이 아니어도 되나 enum 특성 상 변경 불가하게 제한자 붙임.
    private final String symbol;

    Direction2(int value, String symbol) { // 묵시적 접근 권한자는 private 이다.
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() { return value; }
    public String getSymbol() { return symbol; }

    public static Direction2 of(int dir) {
        if (dir < 1 || dir > 4) {
            throw new IllegalArgumentException("Invalid value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    public Direction2 rotate(int num) {
        num = num % 4;

        if (num < 0) num += 4;

        return DIR_ARR[(value - 1 + num) % 4];
    }

    public String toString() {
        return name() + getSymbol();
    }
}

public class EnumEx2 {
    public static void main(String[] args) {
        for (Direction2 d : Direction2.values()) {
            System.out.printf("%s=%d%n", d.name(), d.getValue());
        }

        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1); // south 여야 하는거 아닌가? > of 에서 dir-1 값으로 arr 찾음.

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());

        System.out.println(Direction2.EAST.rotate((1))); 
        System.out.println(Direction2.EAST.rotate((2)));
        System.out.println(Direction2.EAST.rotate((-1)));
        System.out.println(Direction2.EAST.rotate((-2)));
    }
}
