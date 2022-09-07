package com.java.basic.chap12_generics_enum_annotation.enumex.ex2;

enum Direction{EAST, SOUTH, WEST, NORTH}

public class EnumEx1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1 == d2 ? " + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//        System.out.println("d2 > d3 ? " + (d1 > d3)); // error 열거형 간 <, > 등 비교 불가, compareTo 는 가능
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
        System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));

        switch (d1) {
            case EAST : //switch 문 case에 사용할 때는 Enum의 값만 쓴다. Direction.EAST 아님.
                System.out.println("the direction is EAST.");
                break;
            case SOUTH :
                System.out.println("the direction is SOUTH.");
                break;
            case WEST :
                System.out.println("the direction is WEST.");
                break;
            case NORTH :
                System.out.println("the direction is NORTH.");
                break;
            default:
                System.out.println("invalid direction.");
                break;
        }

        Direction[] dArr = Direction.values();

        for (Direction d : dArr) {
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        }
    }
}
