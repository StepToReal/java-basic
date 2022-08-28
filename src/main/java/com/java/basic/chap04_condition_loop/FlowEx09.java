package com.java.basic.chap04_condition_loop;

import java.util.Scanner;

public class FlowEx09 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';

        System.out.println("Please input your score > ");

        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        score = Integer.parseInt(temp);

        switch (score / 10) {
            case 10: case 9:
                grade = 'A';
                break;
            case 8 :
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }

        System.out.println("Your grade is " + grade + ".");
    }
}
