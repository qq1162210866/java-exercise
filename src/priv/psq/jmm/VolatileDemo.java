package priv.psq.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * VolatileDemo.java
 * Description: volatile的练习Demo
 *
 * @author Peng Shiquan
 * @date 2021/12/30
 */
public class VolatileDemo {

    //保证了该变量不同线程的可见性
    private static volatile int numA = 0;
    //也能保证可见性
    private static volatile AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) {
        //可见性测试
        visibilityTrain();
        //原子性测试
        //atomicityTrain();

    }

    /**
     * Description: 可见性测试
     *
     * @param
     * @return void
     * @author Peng Shiquan
     * @date 2022-01-06
     */
    public static void visibilityTrain() {
        new Thread(() -> {
            //java内存模型中，其他线程的修改没有通知到该线程。导致一致自旋
            while (num.get() == 0) {

            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num.set(1);
        System.err.println("变量修改完毕，目前值为：" + num);
    }

    /**
     * Description: 原子性测试
     *
     * @param
     * @return void
     * @author Peng Shiquan
     * @date 2022-01-06
     */
    public static void atomicityTrain() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    addAtomic();
                }
            }, "线程" + i).start();
        }
        //等待所有线程执行完毕
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.err.println("num的值为:" + numA);
    }

    public synchronized static void add() {
        numA++;
    }

    public static void addAtomic() {
        //后续看一下源码，具体的实现
        num.incrementAndGet();
    }
}
