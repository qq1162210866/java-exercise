package priv.psq.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * MyLockExercise.java
 * Description: 自建锁练习
 *
 * @author Peng Shiquan
 * @date 2022/4/7
 */
public class MyLockExercise {
    public static void main(String[] args) {
        myLockTest();
    }

    public static void myLockTest() {
        MyLock myLock = new MyLock();
        new Thread(() -> {
            myLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.myUnLock();
            }
        }, "A").start();

        //
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            myLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.myUnLock();
            }
        }, "B").start();
    }
}

class MyLock {
    //默认为null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.err.println(thread.getName() + "==>myLock");
        //交换成功后才会执行后续代码，即退出
        while (!atomicReference.compareAndSet(null, thread)) {

        }
        System.err.println(thread.getName() + "拿到了锁");
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.err.println(thread.getName() + "==>myUnLock");
        //其他线程就算执行，也不影响当前线程
        atomicReference.compareAndSet(thread, null);
    }

}
