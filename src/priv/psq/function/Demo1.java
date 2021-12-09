package priv.psq.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Demo1.java
 * Description: 函数式接口练习
 *
 * @author Peng Shiquan
 * @date 2021/12/2
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.err.println("全部打印");
        print(list, integer -> true);
        System.err.println("打印偶数");
        print(list, integer -> integer % 2 == 0);
        System.err.println("打印奇数");
        print(list, integer -> integer % 2 != 0);
    }

    // 当需要一个函数实现不同当逻辑时，可以使用这样当写法
    public static void print(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
