package com.java.basic.chap04_condition_loop;

import java.util.Scanner;

public class FlowEx25 {
    public static void main(String[] args) {
        int num = 0, sum = 0;
        System.out.println("input number > ");

        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        num = Integer.parseInt(temp);

        for (; num != 0; num /= 10)
        {
            sum += num % 10;
            System.out.printf("sum = %3d num = %d%n", sum, num);
        }
    }
}
