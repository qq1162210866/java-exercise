package priv.psq.old.LambdaTrain;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * LambdaTrain2.java
 * Description:  练习lambda表达式的方法引用的静态方法引用
 *
 * @author Peng Shiquan
 * @date 2019-07-26
 */
public class LambdaTrain2 {

    /**
     * 如果函数式接口的实现恰好可以通过调用一个静态方法来实现，那么就可以使用静态方法引用
     * 语法：类名::staticMethod
     * 注意：
     * 1.方法的引用不需要括号，因为其仅仅是方法的引用，并没有执行
     * 2.使用的函数式接口输入输出必须与定义的函数式接口一致
     */

    static <T> String hello(T s) {
        return s.toString();
    }

    static String ret() {
        return "hello";
    }

    static void getSize(String s) {
        System.out.println(s.length());
    }

    static String toUpCase(String s) {
        return s.toUpperCase();
    }

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-26
     */
    public static void main(String[] args) {
        /**
         * Supplier是用来提供一个对象,至于提供的对象的构造则由其来定义.
         * 这里的Supplier只有一个函数式接口，所以可以使用lambda表达式
         */
        /**
         * 下面就是标准的lambda表达式，调用的是本类的静态方法，所以是静态方法调用
         */
        Supplier<String> supplier = () -> hello("hello");
        System.err.println("静态方法调用,但是使用普通的lambda表达式。" + supplier.get());
        /**
         * 也可以使用以下方式,但是Supplier不支持参数的输入，只支持参数的输出。所以会报错
         */
        //Supplier<String> supplier1 = LambdaTrain2::hello("hello");
        /**
         * 没有参数的输入，只有参数的输出
         */
        Supplier<String> supplier1 = LambdaTrain2::ret;
        System.out.println("静态方法调用，但是使用lambda表达式的双冒号形式。" + supplier1.get());
        /**
         * Function是一个函数式接口，类似于数学中的函数。(具体可以看Function的源码)
         * 函数式编程的思想是先不去考虑具体的行为，而是先去考虑参数，具体的方法我们可以后续再设置
         */
        Function<Integer, String> function = LambdaTrain2::hello;
        System.out.println("这是调用Function的函数式接口，" + function.apply(5));

        /**
         * 普通的lambda表达式，没有使用双冒号.
         * Consumer支持参数的输入，没有输出。
         */
        Consumer<String> consumer = size -> LambdaTrain2.getSize(size);
        System.out.printf("这是普通的lambda表达式,");
        consumer.accept("1111111");
        /**
         * 也可以写成以下的形式,方法引用
         */
        Consumer<String> consumer1 = LambdaTrain2::getSize;
        System.out.println("这是双冒号的lambda表达式,");
        consumer1.accept("11111111111111");
    }
}
