package com.java.basic.chap06_oop1;

public class FactorialTest {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        long result = 0;

        for (int i = 1; i <= n; i++) {
            result += power(x, i);
        }

        System.out.println(result);

        // int result = factorial(5);

        // System.out.println(result);

        // result = factorialWhile(5);

        // System.out.println(result);
    }

    private static long power (int x, int n) {
        if (n == 1) return x;
        return x * power(x, n-1);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n-1);        
    }

    private static int factorialWhile(int n) {
        int result = 1;

        while (n != 0) {
            result *= n--;
        }

        return result;
    }
}
