package priv.psq.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueueTrain.java
 * Description: 阻塞队列练习
 *
 * @author Peng Shiquan
 * @date 2021/10/26
 */
public class BlockingQueueTrain {

    private static final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        test4();
    }

    /**
     * Description: 队列中会抛出异常的API
     *
     * @param
     * @Author Peng Shiquan
     * @Date 2021-10-26
     */
    public static void test1() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    //当队列满了时，会抛出异常
                    blockingQueue.add("Hello " + Thread.currentThread().getName() + i);
                    System.err.println("放入成功");
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    System.err.println("队列可以接收的元素" + blockingQueue.remainingCapacity());
                    e.printStackTrace();
                }
            }
        }, "Put Thread").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    //当队列为null时，会抛出异常
                    String s = blockingQueue.remove();
                    System.err.println(s);
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    System.err.println("队列可以接收的元素" + blockingQueue.remainingCapacity());
                    e.printStackTrace();
                }

            }
        }, "Take Thread").start();
    }

    /**
     * Description: 队列中会返回布尔值和null的API
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-10-26
     */
    public static void test2() {
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                //当队列满了时，会返回false
                System.err.println(blockingQueue.offer("Hello " + Thread.currentThread().getName() + i) ? "放入成功" : "放入失败");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Put Thread").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                //不会抛出异常的，但是会返回为空
                String s = blockingQueue.poll();
                System.err.println(s == null ? "队列为空" : s);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Take Thread").start();
    }

    /**
     * Description: 队列中会一直等待的API
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-10-26
     */
    public static void test3() {
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                try {
                    //当队列满了时，会一直等待
                    blockingQueue.put("Hello " + Thread.currentThread().getName() + i);
                    System.err.println("放入成功");
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Put Thread").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    //不会抛出异常的，但是会一直等待
                    String s = blockingQueue.take();
                    //队列不能放null元素
                    System.err.println("取出元素成功，元素为：" + s);
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Take Thread").start();
    }

    /**
     * Description: 等待超过一定时间会返回布尔值或者null
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-10-26
     */
    public static void test4() {
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                try {
                    //当队列满了时，会返回false
                    System.err.println(blockingQueue.offer("Hello " + Thread.currentThread().getName() + i, 10, TimeUnit.SECONDS) ? "放入成功" : "放入失败");
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Put Thread").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    //不会抛出异常的，但是会返回为空
                    String s = blockingQueue.poll(10, TimeUnit.SECONDS);
                    System.err.println(s == null ? "队列为空" : s);
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Take Thread").start();
    }
}
