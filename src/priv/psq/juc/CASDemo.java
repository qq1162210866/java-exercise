package priv.psq.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

;

/**
 * CASDemo.java
 * Description: CAS的练习demo
 *
 * @author Peng Shiquan
 * @date 2022/4/7
 */
public class CASDemo {

    public static void main(String[] args) {
        testABA();
    }

    public static void testCAS() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.compareAndSet(0, 1);
        System.err.println(atomicInteger.compareAndSet(0, 1));
    }

    public static void testABA() {
        //Integer超过128会导致==为false
        AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(1, 1);
        new Thread(() -> {
            int stamp = atomicReference.getStamp();
            System.err.println("A1" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //修改为2
            boolean result = atomicReference.compareAndSet(1, 2, atomicReference.getStamp(), atomicReference.getStamp() + 1);
            System.err.println("A修改结果1" + result);
            System.err.println("A2" + atomicReference.getStamp());
            //设置为1
            result = atomicReference.compareAndSet(2, 1, atomicReference.getStamp(), atomicReference.getStamp() + 1);
            System.err.println("A修改结果2" + result);
            System.err.println("A3" + atomicReference.getStamp());
        }, "A").start();
        new Thread(() -> {
            int stamp = atomicReference.getStamp();
            System.err.println("B1" + atomicReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //修改为2
            boolean result = atomicReference.compareAndSet(1, 2, stamp, stamp + 1);
            System.err.println("B修改结果" + result);
            System.err.println("B2" + atomicReference.getStamp());
        }, "B").start();
    }

}
