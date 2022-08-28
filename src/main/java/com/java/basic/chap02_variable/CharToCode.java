package com.java.basic.chap02_variable;

class CharToCode {
    public static void main(String[] args) {
        charToCode();
    }

    private static void charToCode() {
        char ch = 'A';
        int code = (int)ch;

        System.out.printf("%c = %d (%#X) %n", ch, code, code);

        char hch = '가';

        System.out.printf("%c = %d (%#X) %n", hch, (int)hch, (int)hch);
    }
}