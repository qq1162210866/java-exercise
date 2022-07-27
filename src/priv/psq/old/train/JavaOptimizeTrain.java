package priv.psq.old.train;

import java.util.*;

/**
 * JavaOptimizeTrain.java
 * Description:  Java优化练习
 *
 * @author Peng Shiquan
 * @date 2020/3/25
 */
public class JavaOptimizeTrain {

    public static void main(String[] args) {
        /**
         * 不正确的方式，会新建多个String对象
         */
        String s = "a" + "b";
        System.out.println(s);
        /**
         * 使用StringBuilder/StringBuffer的方法来拼接字符串
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b");
        System.out.println(stringBuilder);

        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            //频繁调用了arr.length方法
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            //比上一个少调用了length方法
        }

        for (int var = 0; var < 100; var += 5) {
            int a = var * 8;
            int b = var / 2;
            //System.err.println("a=" + a + ": b=" + b);
        }
        for (int var = 0; var < 100; var += 5) {
            int a = var << 3;
            int b = var >> 1;
            //System.err.println("a=" + a + ": b=" + b);
        }

        ArrayList arrayList = new ArrayList<String>(100);
        if (arrayList instanceof RandomAccess) {
            /**
             *  先判断list是不是RandomAccess的实现类，如果是使用for循环，否则使用迭代器
             */
            int listLength = arrayList.size();
            for (int i = 0; i < listLength; i++) {
            }
        } else {
            Iterator<String> stringIterator = arrayList.iterator();
            while (stringIterator.hasNext()) {
                stringIterator.next();
            }
        }

        Long aLong = 123456789012345L;
        //int i = (int) aLong;
        System.out.println();


        int loopTime = 50000;
        Integer i = 0;
        Long startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = i.toString();
        }
        System.out.println("toString:" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = String.valueOf(i);
        }
        System.out.println("String.valueOf():" + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = i + "";
        }
        System.out.println("+\"\":" + (System.currentTimeMillis() - startTime) + "ms");

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("aaa", "111");
        /**
         * 先获取map中各个键值对映射关系的集合，再使用迭代器来遍历这个集合达到遍历map的作用
         * 如果只是想遍历一下这个Map的key值，可以使用 Set keySet = hm.keySet;
         */
        Set<Map.Entry<String, String>> entrySet = stringStringHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> stringStringEntry = iterator.next();
            System.out.println(stringStringEntry.getKey() + "\t" + stringStringEntry.getValue());
        }


    }
}
