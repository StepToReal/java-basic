package com.java.basic.chap05_array;

public class MultiArrEx03 {
    public static void main(String[] args) {
        multiArrEx03();
    }

    private static void multiArrEx03() {
        int[][] m1 = { 
                        {1,2,3},
                        {4,5,6,}
                    };
        int[][] m2 = { 
                        {1,2},
                        {3,4},
                        {5,6}
                    };

        int m1Row = m1.length;
        int m2Col = m2[0].length;
        int m2Row = m2.length;

        int[][] result = new int[m1Row][m2Col];

        for (int i = 0; i < m1Row; i++) {
            for (int j = 0; j < m2Col; j++) {
                for (int k = 0; k < m2Row; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        for (int i = 0; i < m1Row; i++) {
            for (int j = 0; j < m2Col; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
