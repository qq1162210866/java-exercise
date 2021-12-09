package priv.psq.function;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * FunctionTrain.java
 * Description: 函数式编程练习
 *
 * @author Peng Shiquan
 * @date 2021/12/3
 */
public class FunctionTrain {
    public static void main(String[] args) {
        //consumerTrain();
        //functionTrain();
        //predicateTrain();
        //supplier();
        runnableTrain();
    }

    /**
     * Description: 消费型接口练习
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-03
     */
    public static void consumerTrain() {
        Consumer<String> consumer = System.err::println;
        consumer.accept("test");
    }

    /**
     * Description: 功能型接口练习
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-03
     */
    public static void functionTrain() {
        Function<Integer, String> function = integer -> "该数字的二进制格式为：" + Integer.toString(integer, 2);
        String result = function.apply(324);
        System.err.println(result);
    }

    /**
     * Description: 断言型接口函数练习
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-03
     */
    public static void predicateTrain() {
        Predicate<Integer> predicate = o -> o % 2 == 0;
        Integer integer = new Random().nextInt(123456);
        if (predicate.test(integer)) {
            System.err.println(integer + "是一个偶数");
        }
    }

    /**
     * Description: 提供型函数接口练习，返回一个随机数
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-03
     */
    public static void supplier() {
        Supplier<Integer> supplier = () -> new Random().nextInt(12345);
        System.err.println("返回的随机数为：" + supplier.get());
    }

    /**
     * Description: Runnable
     *
     * @param
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-12-03
     */
    public static void runnableTrain() {
        Runnable runnable = () -> System.err.println(Thread.currentThread().getName() + "这是一个无参无返回的函数式接口");
        Thread thread = new Thread(runnable);
        thread.start();
        runnable.run();
    }
}
