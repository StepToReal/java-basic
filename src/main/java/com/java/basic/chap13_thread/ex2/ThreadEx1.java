package com.java.basic.chap13_thread.ex2;

public class ThreadEx1 {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Runnable r = new Thread2();
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(new Thread3());

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.start();
        t2.start();
        t2.join();

        t3.start();
        t3.join();

        System.out.println("main close");
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        try {
            this.join(100);
        } catch (InterruptedException e) {
            System.out.println("Thread1 join error");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class Thread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(i);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}