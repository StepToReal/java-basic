package com.java.basic.chap13_thread.ex2;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitEx4 {
    public static void main(String[] args) throws InterruptedException {
        Table4 table = new Table4();
        new Thread(new Cook4(table), "COOK1").start();
        new Thread(new Customer4(table, "donut"), "CUST1").start();
        new Thread(new Customer4(table, "burger"), "CUST2").start();

        Thread.sleep(200000);
        System.exit(0);
    }
}

class Customer4 implements Runnable {
    private Table4 table;
    private String food;

    Customer4(Table4 table, String food) {
        this.table = table;
        this.food = food;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String name = Thread.currentThread().getName();
            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

class Cook4 implements Runnable {
    private Table4 table;

    Cook4(Table4 table) {
        this.table = table;
    }

    public void run() {
        while (true) {
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Table4 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void add(String dish) { //cook 에서만 일어남
        lock.lock();

        try {
            while (dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");

                try {
                    forCook.await(); // dishes 사이즈가 MAX 값과 크거나 같으면 까지 cook wait
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            dishes.add(dish); // 음식을 추가로 놓고
            forCust.signal(); // 고객을 깨움
            System.out.println("Dishes: " + dishes.toString());
        } finally {
            lock.unlock();
        }
    }

    public void remove(String dishName) { //customer 에서만 일어남
        lock.lock();
        String name = Thread.currentThread().getName();

        try {
            while (dishes.size() == 0) {
                System.out.println(name + " is waiting");
                try {
                    forCust.await(); // customer thread 만 접근하여 wait
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal(); // dishes 사이즈가 줄면 Cook thread 들을 깨움 (먹었으니 채워 넣으라고 알림)
                        return;
                    }
                }

                try {
                    System.out.println(name + " is waiting"); // dishes 를 전부 검색했는데 먹을 수 있는 음식이 없으면 cust wait
                    forCust.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}
