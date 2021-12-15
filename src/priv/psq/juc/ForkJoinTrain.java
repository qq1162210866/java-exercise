package priv.psq.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * ForkJoinTrain.java
 * Description: ForkJoin练习demo
 *
 * @author Peng Shiquan
 * @date 2021/12/15
 */
public class ForkJoinTrain {


    public static void main(String[] args) {
        Long begin = 1L;
        Long end = 10_0000_0000L;

        long beginTime = System.currentTimeMillis();
        //Long result= accumulate(begin, end); //5219
        //Long result = forkJoinAccumulate(begin, end);//5188
        //后续看看代码实现
        Long result = streamAccumulate(begin, end);//176
        System.err.println(result);
        long endTime = System.currentTimeMillis();
        System.err.println("花费了:" + (endTime - beginTime));
    }

    public static Long accumulate(Long begin, Long end) {
        Long sum = 0L;
        for (Long i = begin; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static Long forkJoinAccumulate(Long begin, Long end) {
        ForkJoinPool joinPool = new ForkJoinPool();
        ComputeTask task = new ComputeTask(begin, end);
        ForkJoinTask<Long> task1 = joinPool.submit(task);
        try {
            return task1.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public static Long streamAccumulate(Long begin, Long end) {
        return LongStream.rangeClosed(begin, end).parallel().reduce(0, Long::sum);
    }
}

class ComputeTask extends RecursiveTask<Long> {
    private Long begin, end;
    private final Long criticalValue = 10000L;

    public ComputeTask(Long begin, Long end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - begin > criticalValue) {
            Long sum = 0L;
            for (Long i = begin; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (end + begin) / 2;
            ComputeTask task1 = new ComputeTask(begin, middle);
            ComputeTask task2 = new ComputeTask(middle + 1, end);
            return task1.fork().join() + task2.fork().join();
        }
    }
}
