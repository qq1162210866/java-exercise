package priv.psq.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Demo1.java
 * Description: 异步调用的Demo
 *
 * @author Peng Shiquan
 * @date 2021/12/29
 */
public class Demo1 {
    public static void main(String[] args) {
        supplyAsync();
    }

    /**
     * Description: 无返回值的异步回调
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-29
     */
    public static void voidAsync() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("this is completableFuture runAsync");
        });
        System.err.println(" this is main synchronize");
        try {
            completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 有参返回值
     *
     * @param
     * @return void
     * @author Peng Shiquan
     * @date 2021-12-30
     */
    public static void supplyAsync() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() ->
        {
            System.err.println("this is completableFuture supplyAsync");
            int i = 1 / 0;
            return 1024;
        }).whenComplete((integer, throwable) -> {
            //完成时执行
            System.err.println("异步调用完成");
            System.err.println(integer);
            System.err.println(throwable);
        }).exceptionally(throwable -> {
            //异常时执行
            System.err.println("异步调用发生异常");
            System.err.println(throwable.getMessage());
            return 233;
        });
        System.err.println(" this is main synchronize");

        try {
            System.err.println("获取到异步回调到返回值：" + completableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
