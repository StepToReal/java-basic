package com.java.basic.chap13_thread;

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t = new ThreadEx3_1();
        t.run();
    }
}

class ThreadEx3_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
