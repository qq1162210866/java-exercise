package priv.psq.old.LambdaTrain;


import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * LambdaTrain3.java
 * Description: 练习lambda表达式的方法引用的实例方法引用
 *
 * @author Peng Shiquan
 * @date 2019-07-27
 */
public class LambdaTrain3 {
    /**
     * 如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
     * 语法： new instMethod()::method
     * 注意：后面不需要加括号也不需要加参数
     */

    String put() {
        return "hello";
    }

    public String toUpCase(String s) {
        //转换为大写
        return s.toUpperCase();
    }

    void test() {
        /**
         * UnaryOperator是java8的新特新，继承了Function.功能是对数据进行操作，生成一个与同类型对象。
         * 方法只有一个static UnaryOperator identity()，该方法返回一个UnaryOerator对象，并且apply()方法中直接返回范型对象。
         */
        /**
         * 使用双冒号，调用实例的方法。
         */
        UnaryOperator<String> unaryOperator = this::toUpCase;
        System.out.println(unaryOperator.apply("this is example method"));

    }

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-27
     */
    public static void main(String[] args) {
        /**
         * 调实例的方法
         */
        Supplier<String> supplier = () -> new LambdaTrain3().put();
        System.out.println(supplier.get());
        /**
         * 普通lambda表达式的写法
         */
        Supplier<String> supplier1 = () -> {
            return new LambdaTrain3().put();
        };
        System.out.println(supplier1.get());
        /**
         * 使用双冒号的形式
         */
        Supplier<String> supplier2 = new LambdaTrain3()::put;
        System.out.println(supplier2.get());
        /**
         * UnaryOperator中有唯一的方法，但是需要输入参数
         */
        UnaryOperator<String> unaryOperator = new LambdaTrain3()::toUpCase;
        /**
         * 对象引用
         */
        LambdaTrain3 lambdaTrain3 = new LambdaTrain3();
        UnaryOperator<String> unaryOperator1 = lambdaTrain3::toUpCase;

        System.out.println("实例引用："+unaryOperator.apply("this is example method")+"对象引用"+unaryOperator1.apply("this is example method"));

    }
}
