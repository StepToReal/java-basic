package com.java.basic.chap04_condition_loop;

import java.util.Scanner;

public class FlowEx08 {
    public static void main(String[] args) {
        System.out.println("Please input your identity number > ");

        Scanner scanner = new Scanner(System.in);
        String regNo = scanner.nextLine();

        char gender = regNo.charAt(7);

        switch (gender) {
            case '1': case '3':
                System.out.println("you are a man");
                break;
            case '2': case '4':
                System.out.println("you are a woman");
                break;
            default:
                System.out.println("wrong number");
        }
    }
}
