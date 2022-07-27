package priv.psq.old.LambdaTrain;

import java.util.Arrays;

/**
 * LambdaTrain1.java
 * Description: 练习lambda表达式的demo
 *
 * @author Peng Shiquan
 * @date 2019-07-18
 */
public class LambdaTrain1 {

    /**
     * Description:主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-18
     */
    public static void main(String[] args) {
        LambdaTrain1 lambdaTrain1 = new LambdaTrain1();
        /**
         * lambda语法线程练习
         */
        lambdaTrain1.runnableTrain();
        /**
         * lambda语法的数组排序练习
         */
        lambdaTrain1.arraySort();
        /**
         *lambda语法的函数式接口练习
         */
        lambdaTrain1.eatTrain();

    }

    /**
     * Description: 使用lambda表达式作为转换为函数式接口传递到Arrays.sort中第二个参数
     *
     * @param
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-18
     */
    public void arraySort() {
        String[] arrays = {"1237", "123"};
        Arrays.sort(arrays, (first, second) -> second.length() - first.length());
        System.err.println(arrays[0]);
    }

    /**
     * Description: 使用lambda来新启线程
     *
     * @param
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-18
     */
    public void runnableTrain() {
        Runnable runnable = () -> System.out.println("这是lambda语法启动的线程");
        new Thread(runnable, "线程1").start();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是正常启动的线程");
            }
        };
        new Thread(runnable1, "线程2").start();
    }

    /**
     * Description: 使用lambda表达式作为对象的练习
     *
     * @param
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-18
     */
    public void eatTrain() {
        //使用lambda表达式作为对象
        Eat eat = () -> System.out.println("使用lambda表达式的eat!");
        eat.eatFood();
        //正常的函数式接口调用
        Eat eat1 = new Eat() {
            @Override
            public void eatFood() {
                System.out.println("使用内部匿名类的eat!");
            }
        };
        eat1.eatFood();
    }

    /**
     * LambdaTrain1.java
     * Description: 函数式接口（只有一个抽象方法的接口）
     *
     * @author Peng Shiquan
     * @date 2019-07-18
     */
    interface Eat {
        void eatFood();
    }
}
