package priv.psq.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Test3.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/3/11
 */
public class Test3 {
    public static void main(String[] args) {

        Byte tmp = (byte) 0;
        Byte tmp2 = (byte) 0;
        System.err.println(tmp | tmp2);

        Lock lock = new ReentrantLock();
        lock.lock();

        new Thread(() -> {
            lock.lock();
        }).start();

    }
}
