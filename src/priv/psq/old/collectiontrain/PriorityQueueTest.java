package priv.psq.old.collectiontrain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * PriorityQueueTest.java
 * Description: 优先级队列练习
 *
 * @author Peng Shiquan
 * @date 2020/8/16
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> localDates = new PriorityQueue<>();
        localDates.add(LocalDate.MAX);
        localDates.add(LocalDate.MIN);
        localDates.add(LocalDate.of(1903, 12, 10));
        localDates.add(LocalDate.of(1902, 12, 10));
        localDates.add(LocalDate.of(1903, 11, 10));
        System.err.println("打印");
        for (LocalDate localDate : localDates) {
            System.err.println(localDate);
        }
        System.err.println("删除");
        /**
         * 只取出最小的删除，无论如何操作。
         */
        while (!localDates.isEmpty()) {
            System.err.println(localDates.remove());
        }


        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("1", "A");
        stringStringMap.put("2", "B");
        stringStringMap.put("3", "C");
        stringStringMap.put("4", "D");

        System.err.println(stringStringMap);

        stringStringMap.remove("4");

        stringStringMap.put("1", "AA");
        System.err.println(stringStringMap.get("1"));
        //IdentityHashMap

        /**
         * 还是需要再了解和使用lambda表达式
         */
        stringStringMap.forEach((k, v) -> System.err.println("key" + k + "===" + "value" + v));

    }
}
