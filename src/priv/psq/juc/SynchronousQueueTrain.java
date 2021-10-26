package priv.psq.juc;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueueTrain.java
 * Description: 同步阻塞队列的练习
 *
 * @author Peng Shiquan
 * @date 2021/10/26
 */
public class SynchronousQueueTrain {
    //默认为非公平策略，并且元素只能放一个
    private static final SynchronousQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) {
        test1();
    }

    /**
     * Description: 同步队列，只有一个线程放入或者取出，其他线程才能取出或者放入
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-10-26
     */
    public static void test1() {
        //双方等待模式
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    //放入元素会一直等待，直到其他线程取出，才会执行后续步骤
                    queue.put(Thread.currentThread().getName() + "放入元素");
                    //打印不是规律的，这个和jvm打印有关，队列还是同步的
                    System.err.println("放入成功");
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    System.err.println("异常中断");
                    e.printStackTrace();
                }
            }
        }, "Put Thread").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                for (int i = 0; i < 5; i++) {
                    String s = queue.take();
                    System.err.println("取出元素，元素为：" + s);
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (Exception e) {
                System.err.println("异常中断");
                e.printStackTrace();
            }
        }, "Put Thread").start();
    }
}
