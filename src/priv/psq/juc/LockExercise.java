package priv.psq.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockExercise.java
 * Description:重入锁练习
 *
 * @author Peng Shiquan
 * @date 2022/4/7
 */
public class LockExercise {
    public static void main(String[] args) {
        lockTest();
    }

    public static void synchronizedTest() {
        Phone phone = new Phone();
        //始终A执行完毕，B才能执行
        new Thread(() -> {
            phone.sms();
        }, "A").start();
        new Thread(() -> {
            phone.sms();
        }, "B").start();
    }
    public static void lockTest() {
        Phone2 phone = new Phone2();
        //始终A执行完毕，B才能执行
        new Thread(() -> {
            phone.sms();
        }, "A").start();
        new Thread(() -> {
            phone.sms();
        }, "B").start();
    }
}

class Phone {
    public synchronized void sms() {
        System.err.println(Thread.currentThread().getName() + "sms");
        call();
    }

    public synchronized void call() {
        System.err.println(Thread.currentThread().getName() + "call");
    }
}

class Phone2 {
    Lock lock = new ReentrantLock();

    public synchronized void sms() {
        lock.lock();
        try {
            System.err.println(Thread.currentThread().getName() + "sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public synchronized void call() {
        lock.lock();
        try {
            System.err.println(Thread.currentThread().getName() + "call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
