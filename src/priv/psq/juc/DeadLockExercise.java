package priv.psq.juc;

import java.util.concurrent.TimeUnit;

/**
 * DeadLockExercise.java
 * Description: 死锁练习
 *
 * @author Peng Shiquan
 * @date 2022/4/7
 */
public class DeadLockExercise {
    public static void main(String[] args) {
        deadLockTest();
    }

    public static void deadLockTest() {
        String resourceA = "A";
        String resourceB = "B";
        new Thread(new MyThread(resourceA, resourceB), "T1").start();
        new Thread(new MyThread(resourceB, resourceA), "T2").start();
    }
}

class MyThread implements Runnable {
    private final String resourceA;
    private final String resourceB;

    public MyThread(String resourceA, String resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        synchronized (resourceA) {
            System.err.println(Thread.currentThread().getName() + "lock" + resourceA + "===.get" + resourceB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceB) {
                System.err.println(Thread.currentThread().getName() + "lock" + resourceB);
            }
        }
    }
}