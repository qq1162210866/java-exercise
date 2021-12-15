package priv.psq.juc;

import java.util.concurrent.*;

/**
 * ThreadPoolDemo.java
 * Description: 线程池练习demo
 *
 * @author Peng Shiquan
 * @date 2021/12/9
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        customizeThreadPoolTrain();
    }

    /**
     * Description: 使用指定的线程池
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-09
     */
    public static void executorsThreadPoolTrain() {
        ExecutorService executorService = null;
        //executorService = Executors.newSingleThreadExecutor();// 单个线程的线程池
        //executorService = Executors.newFixedThreadPool(5);//指定五个线程的线程池
        executorService = Executors.newCachedThreadPool(); //创建一个无止境的线程池，线程60秒会消失
        threadPoolExecutor(executorService);
    }

    /**
     * Description: 使用自定义的线程池
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-09
     */
    public static void customizeThreadPoolTrain() {
        ExecutorService executorService = null;
        executorService = new ThreadPoolExecutor(3, 5,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),//阻塞队列
                Executors.defaultThreadFactory(),//创建线程的工厂
                new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        threadPoolExecutor(executorService);
    }

    /**
     * Description: 线程池执行者
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-09
     */
    public static void threadPoolExecutor(ExecutorService executorService) {
        try {
            for (int i = 0; i <15; i++) {
                executorService.execute(() -> System.err.println("当前线程为：" + Thread.currentThread().getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }


}
