package priv.psq.juc;

import java.util.*;
import java.util.concurrent.*;

/**
 * Test2.java
 * Description: 练习并发包下面的一些线程安全数据结构
 *
 * @author Peng Shiquan
 * @date 2021/9/8
 */
public class Test2 {
    public static void main(String[] args) {
        CallableTrain();
    }

    public static void listTrain() {
        List<String> tmp = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                tmp.add(UUID.randomUUID().toString().substring(0, 5));
                System.err.println(tmp);
            }).start();
        }
    }

    public static void listConcurrentTrain() {
        List<String> tmp = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                tmp.add(UUID.randomUUID().toString().substring(0, 5));
                System.err.println(tmp);
            }).start();
        }
    }

    public static void setTrain() {
        //主要区别就是不能存储重复的元素
        Set<String> tmp = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                tmp.add(UUID.randomUUID().toString().substring(0, 5));
                System.err.println(tmp);
            }).start();
        }
    }

    public static void setConcurrentTrain() {
        Set<String> tmp = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                tmp.add(UUID.randomUUID().toString().substring(0, 5));
                System.err.println(tmp);
            }).start();
        }
    }

    public static void mapTrain() {
        Map<String, String> tmp = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                tmp.put(UUID.randomUUID().toString().substring(0, 5), "null");
                System.err.println(tmp);
            }).start();
        }
    }

    public static void mapConcurrentTrain() {
        Map<String, String> tmp = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                tmp.put(UUID.randomUUID().toString().substring(0, 5), "null");
                System.err.println(tmp);
            }).start();
        }
    }

    public static void CallableTrain() {
        //不知道为什么打印的在后面
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            System.err.println("this is callable");
            return 1;
        });
        new Thread(ft, "A").start();
        System.err.println(ft.isDone() ? "线程执行完毕" : "线程为执行完毕");
        try {
            System.err.println(ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
