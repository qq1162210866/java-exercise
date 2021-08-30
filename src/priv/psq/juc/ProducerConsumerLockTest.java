package priv.psq.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProducerConsumerLockTest.java
 * Description: 生产者和消费者的Lock练习
 *
 * @author Peng Shiquan
 * @date 2021/8/30
 */
public class ProducerConsumerLockTest {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }

}

/**
 * ProducerConsumerTest.java
 * Description: 资源类，交替加一减一
 *
 * @author Peng Shiquan
 * @date 2021/8/29
 */
class Data2 {
    private Integer number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * Description: 加一
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-08-29
     */
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0)
                condition.await();
            number++;
            System.err.println("当前线程名称为：" + Thread.currentThread().getName() + ",当前number为：" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Description: 减一
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-08-29
     */
    public synchronized void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0)
                condition.await();
            number--;
            System.err.println("当前线程名称为：" + Thread.currentThread().getName() + ",当前number为：" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
