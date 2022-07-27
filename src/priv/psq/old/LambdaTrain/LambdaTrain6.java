package priv.psq.old.LambdaTrain;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * LambdaTrain6.java
 * Description: 博客中使用的练习demo，将方法引用汇集在一起
 *
 * @author Peng Shiquan
 * @date 2021/2/18
 */
public class LambdaTrain6 {

    /**
     * Description: 第一个<T> 声明范型的类型
     *
     * @param s
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-02-18
     */
    static <T> void hello(T s) {
        System.err.println("这是一个静态方法引用，有参数，但是没有返回值：" + s);
    }

    String put() {
        return "这是一个普通方法引用，没有参数，但是返回值";
    }

    void fun(String s) {
        System.out.println("这是特定类型的方法引用" + s);
    }

    public static void main(String[] args) {
        //静态方法引用
        Consumer<String> consumer = LambdaTrain6::hello;
        consumer.accept("hello");
        //普通方法引用
        Supplier<String> supplier = new LambdaTrain6()::put;
        System.err.println(supplier.get());
        /**
         * 1.抽象方法的第一个参数类型刚好是实例方法的类型（函数式接口的抽象方法必须要有输入参数）。2.抽象方法剩余
         * 的参数恰好可以当做实例方法的参数。如果函数式接口的实现能由上面说的实例方法调用来实现的话，
         * 那么就可以使用对象方法的引用(两个条件都要满足)
         */
        BiConsumer<LambdaTrain6, String> biConsumer = LambdaTrain6::fun;
        biConsumer.accept(new LambdaTrain6(), "hello");
    }
}
