package priv.psq.old.LambdaTrain;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * LambdaTrain4.java
 * Description: lambda表达式练习，练习指向特定类型任意对象实例方法的引用
 *
 * @author Peng Shiquan
 * @date 2019-08-07
 */
public class LambdaTrain4 {

    /**
     * 抽象方法的第一个参数类型刚好是实例方法的类型（函数式接口的抽象方法必须要有输入参数），抽象方法剩余
     * 的参数恰好可以当做实例方法的参数。如果函数式接口的实现能由上面说的实例方法调用来实现的话，
     * 那么就可以使用对象方法的引用(两个条件都要满足)
     * <p>
     * 语法：类名::instMethod
     */

    /**
     * Description: 因为方法没有参数，所以无法使用特定对象引用
     *
     * @param
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-08-12
     */
    public void notUseObjectMethod() {
        /**
         * 比如下面函数式接口，都是无法使用特定对象引用
         */
        Runnable r = () -> {
        };
        Closeable c = () -> {
        };
        Supplier<String> s = () -> " ";
    }


    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-08-07
     */
    public static void main(String[] args) {
        /**
         * 抽象方法的类型恰好是实例方法的类型
         * 参数巧合是Too1类型，调用的方法也是Too的方法（Too too 与 new Too()是同种类型）
         * 剩余的参数恰好可以当做实例方法的参数（Consumer<T>函数式接口没有返回值，Too中的foo也没有返回值）
         */
        Consumer<Too1> consumer = (Too1 too) -> new Too1().foo();
        consumer.accept(new Too1());

        /**
         * 使用双冒号的格式
         */
        Consumer<Too1> consumer1 = Too1::foo;
        consumer1.accept(new Too1());

        /**
         * 普通形式
         */
        BiConsumer<Too2, String> biConsumer = (Too2 too, String s) -> new Too2().fun(s);
        biConsumer.accept(new Too2(), "this is method reference ");
        /**
         * 双冒号形式
         */
        BiConsumer<Too2, String> biConsumer1 = Too2::fun;
        biConsumer1.accept(new Too2(), "this is second method reference");

        /**
         * 接收三个类型参数，对后两个参数操作，返回第一个参数类型对值
         */
        BiFunction<Prod, String, Integer> biFunction = (Prod prod, String s) -> new Prod().fun(s);
        Integer result = biFunction.apply(new Prod(), "test");
        /**
         * 双冒号形式
         */
        BiFunction<Prod, String, Integer> biFunction1 = Prod::fun;
        Integer result1 = biFunction1.apply(new Prod(), "test1");

        System.out.println("this is first method referenc:" + result);
        System.out.println("this is second method referenc:" + result1);

        /**
         * 使用自定义对函数式接口
         */
        Execute2<Prod, String, String> execute2 = (Prod prod, String s1, String s2) -> new Prod().fun2(s1, s2);
        Execute2<Prod, String, String> execute21 = Prod::fun2;
        execute2.run(new Prod(), "haha", "haha");
        execute21.run(new Prod(), "haha", "haha");


    }


}

class Prod {
    Integer fun(String s) {
        return s.length();
    }

    void fun2(String s1, String s2) {
        System.err.println("this is prod's fun2 method");
    }
}

/**
 * 不符合对象方法引用，因为第一个参数是自定义对，不能是java自带对对象类型
 */
@FunctionalInterface
interface Execute1 {
    void run(String name, String size);
}

interface Execute2<T, R, U> {
    void run(T t, R name, U size);
}

class Too1 {
    void foo() {
        System.out.println("invoke method");
    }
}

class Too2 {
    void foo() {
        System.out.println("this is Too2's foo method");
    }

    void fun(String s) {
        System.out.println(s);
    }

}