package com.java.basic.chap09_javalang_utils;

import java.util.StringTokenizer;

public class StringTokenizerEx4 {

    public static void main(String[] args) {
        String input = "삼십만삼천백십오";
        System.out.println(input);
        System.out.println(hangulToNum(input));
    }

    private static long hangulToNum(String input) {
        long result = 0;
        long tempResult = 0;
        long num = 0;

        final String NUMBER = "영일이삼사오육칠팔구";
        final String UNIT = "십백천만억조";
        final long[] UNIT_NUM = {10, 100, 1000, 10000, (long) 1e8, (long) 1e12};

        StringTokenizer st = new StringTokenizer(input, UNIT, true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            int check = NUMBER.indexOf(token);

            if (check == -1) { //단위 이면
                if ("만억조".indexOf(token) == -1) {
                    tempResult += (num != 0 ? num : 1) * UNIT_NUM[UNIT.indexOf(token)];
                } else {
                    tempResult += num;
                    result += (tempResult != 0 ? tempResult : 1) * UNIT_NUM[UNIT.indexOf(token)];
                    tempResult = 0;
                }
                num = 0;
            } else {
                num = check;
            }
        }

        return result + tempResult + num;
    }
}
