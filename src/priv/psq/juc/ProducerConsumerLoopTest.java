package priv.psq.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProducerConsumerLoopTest.java
 * Description: 三个线程循环打印ABC
 *
 * @author Peng Shiquan
 * @date 2021/8/31
 */
public class ProducerConsumerLoopTest {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                data.printA();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                data.printB();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                data.printC();
        }, "C").start();
    }
}

class Data3 {
    private Integer number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (number != 1)
                condition1.await();
            number++;
            condition2.signal();
            System.err.println(Thread.currentThread().getName() + "线程打印：AAAAAAAA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number != 2)
                condition2.await();
            number++;
            condition3.signal();
            System.err.println(Thread.currentThread().getName() + "线程打印：BBBBBBB");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number != 3)
                condition3.await();
            number = 1;
            condition1.signal();
            System.err.println(Thread.currentThread().getName() + "线程打印：CCCCCCC");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
