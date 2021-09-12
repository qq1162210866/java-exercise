package priv.psq.juc;

import java.util.concurrent.*;

/**
 * ConcurrentUtilTrain.java
 * Description: Concurrent辅助工具类练习
 *
 * @author Peng Shiquan
 * @date 2021/9/12
 */
public class ConcurrentUtilTrain {
    public static void main(String[] args) {
        semaphoreTrain();
    }

    public static void countDownLatchTrain() {
        //相当于倒数计数器，可以等待线程执行完毕后更新，最后执行一个操作。需要注意，该计数器不能重置
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.err.println("线程" + Thread.currentThread().getName() + "执行完毕");
                countDownLatch.countDown();
                try {
                    TimeUnit.SECONDS.sleep(2);
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.err.println("线程" + Thread.currentThread().getName() + "释放");
                }
            }, i + "").start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("前置线程执行完毕，可以执行后续步骤");
    }

    public static void cyclicBarrierTrain() {
        //后续可以看一下源码，看看为啥和自己预想的不一样
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.err.println("已经有三个线程执行完毕");
        });
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.err.println("线程执行完毕" + Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
    }

    public static void semaphoreTrain() {
        //可以看看源码，可以试试让第五个线程不执行，直接跳出
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.err.println("线程开始执行" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    System.err.println("线程执行完毕" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, i + "").start();
        }
    }
}
