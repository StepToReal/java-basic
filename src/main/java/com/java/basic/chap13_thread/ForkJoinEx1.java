package com.java.basic.chap13_thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {
    static final ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        long from = 1L;
        long to = 100_000_000L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);

        System.out.println("Elapsed time (4core) : " + (System.currentTimeMillis() - start));

        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis();

        for (long i = from; i <= to; i++) {
            result += i;
        }

        System.out.println("Elapsed time (1core) : " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
    }
}

class SumTask extends RecursiveTask<Long> {
    long from, to;

    SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    public Long compute() {
        long size = from - to + 1;

        if (size <= 5)
            return sum();

        long half = (from + to) / 2;

        SumTask leftSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half + 1, to);

        leftSum.fork();

        return rightSum.compute() + leftSum.join();
    }

    long sum() {
        long temp = 0L;

        for (long i = from; i <= to; i++) {
            temp += i;
        }

        return temp;
    }
}

