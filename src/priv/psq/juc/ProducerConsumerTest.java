package priv.psq.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProducerConsumerTest.java
 * Description: 生产者和消费者的练习
 *
 * @author Peng Shiquan
 * @date 2021/8/29
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Data data = new Data();
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
class Data {
    private Integer number = 0;
    Lock lock = new ReentrantLock();

    /**
     * Description: 加一
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-08-29
     */
    public synchronized void increment() throws InterruptedException {
        //消除虚假唤醒
        if (number != 0) {
            this.wait();
        }
        number++;
        System.err.println("当前线程名称为：" + Thread.currentThread().getName() + ",当前number为：" + number);
        this.notifyAll();
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
        if (number == 0) {
            this.wait();
        }
        number--;
        System.err.println("当前线程名称为：" + Thread.currentThread().getName() + ",当前number为：" + number);
        this.notifyAll();
    }
}
