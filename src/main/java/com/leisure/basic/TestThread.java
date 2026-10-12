package com.leisure.basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: TestThread
 * Package: com.leisure.basic
 * Description:
 *  优点：可以多实现，任务和线程解耦，同一个任务可以交给多个线程。
 * @Author: MyLeisureLife
 * @Date: 2026/10/10:17:02:04 星期六
 */

public class TestThread {
    // 共享变量
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (TestThread.class) {
                    count++;   //  线程不安全
                }

            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (TestThread.class) {
                    count++;
                }

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}