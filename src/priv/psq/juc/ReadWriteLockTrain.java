package priv.psq.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLockTrain.java
 * Description: 读写锁练习
 *
 * @author Peng Shiquan
 * @date 2021/9/13
 */
public class ReadWriteLockTrain {
    public static void main(String[] args) {
        MyCache2 myCache = new MyCache2();
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                myCache.put(Thread.currentThread().getName(), new Object());
            }, i + "").start();
        }
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                myCache.get(Thread.currentThread().getName());
            }, i + "").start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> cache = new HashMap<>();

    public void put(String key, Object value) {
        System.err.println("开始写入缓存" + key);
        cache.put(key, value);
        System.err.println("写入缓存完成" + key);
    }

    public void get(String key) {
        System.err.println("开始读取缓存" + key);
        cache.get(key);
        System.err.println("读取缓存完成" + key);
    }
}

class MyCache2 {
    private volatile Map<String, Object> cache = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.err.println("开始写入缓存" + key);
            cache.put(key, value);
            System.err.println("写入缓存完成" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.err.println("开始读取缓存" + key);
            while (cache.get(key) != null) {
                System.err.println("读取缓存完成" + key);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
