package com.java.basic.chap13_thread.ex2;

public class ThreadEx21 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx21();
        new Thread(r).start();
        new Thread(r).start();

        // 두개의 thread 에서 account 에 접근하게 되어서 잔고가 마이너스인 상황이 발생한다.
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= money;
        }
    }
}

class RunnableEx21 implements Runnable {
    Account account = new Account();

    public void run() {
        while (account.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100; //100,200,300 을 랜덤하게 반환
            account.withdraw(money);
            System.out.println("balance : " + account.getBalance());
        }
    }
}