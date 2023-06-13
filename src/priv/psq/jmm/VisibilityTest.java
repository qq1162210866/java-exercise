package priv.psq.jmm;

import java.util.concurrent.locks.LockSupport;

public class VisibilityTest {
    //  使用volatile修饰的变量，保证了该变量的可见性
    //private volatile boolean flag = true;
    private boolean flag = true;
    private int count = 0;

    public void refresh() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag:" + flag);
    }

    public void load() {
        System.out.println(Thread.currentThread().getName() + "开始执行.....");
        while (flag) {
            //TODO  业务逻辑
            count++;

            //Thread.yield();

            //System.out.println(count);

            //LockSupport.unpark(Thread.currentThread());

            shortWait(1000000);

//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(Thread.currentThread().getName() + "跳出循环: count=" + count);
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest test = new VisibilityTest();
        // 线程threadA模拟数据加载场景
        Thread threadA = new Thread(test::load, "threadA");
        threadA.start();
        // 让threadA执行一会儿
        Thread.sleep(1000);
        // 线程threadB通过flag控制threadA的执行时间
        Thread threadB = new Thread(test::refresh, "threadB");
        threadB.start();
    }

    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
