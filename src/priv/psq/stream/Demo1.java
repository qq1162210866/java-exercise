package priv.psq.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Demo1.java
 * Description: Stream练习
 *
 * @author Peng Shiquan
 * @date 2021/9/26
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        ordinary(numbers);
        streamTrain(numbers);


    }

    public static void ordinary(List<Integer> arr) {

        //查找特殊的，for循环遍历
        List<Integer> result = new ArrayList<>();
        long tmp = System.currentTimeMillis();
        for (Integer integer : arr) {
            if (integer > 5) {
                result.add(integer);
            }
        }
        System.err.println(System.currentTimeMillis() - tmp);
        System.err.println(result);

        result.clear();
        //java的Lambda表达式本质是匿名内部类，在匿名的内部类中不能访问局部变量，只能访问常量。
        tmp = System.currentTimeMillis();
        arr.forEach(integer -> {
            if (integer > 5) result.add(integer);
        });
        System.err.println(System.currentTimeMillis() - tmp);
        System.err.println(result);
    }

    public static void streamTrain(List<Integer> arr) {
        long tmp = System.currentTimeMillis();
        List<Integer> result = arr.stream().filter(integer -> integer > 5).collect(Collectors.toList());
        System.err.println(System.currentTimeMillis() - tmp);
        System.err.println(result);

    }

}
