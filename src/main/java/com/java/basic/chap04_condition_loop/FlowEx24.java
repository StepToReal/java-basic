package com.java.basic.chap04_condition_loop;

public class FlowEx24 {
    public static void main(String[] args) {
        int i = 11;

        System.out.println("start count down");

        while (i-- != 0)
        {
            System.out.println(i);

            for (int j = 0; j < 2_000_000_000; j++ )
            {
                ;
            }
        }

        System.out.println("Game over");
    }
}
