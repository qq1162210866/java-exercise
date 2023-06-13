package priv.psq.juc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

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
        //因为线程的启动㤇时间，先执行的主方法，后续才执行这个线程的方法
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            System.err.println("this is callable");
            return 1;
        });
        new Thread(ft, "A").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(ft.isDone() ? "线程执行完毕" : "线程未执行完毕");
        try {
            System.err.println(ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
