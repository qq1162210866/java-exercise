package priv.psq.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo1.java
 * Description: 范型的练习
 *
 * @author Peng Shiquan
 * @date 2021/12/21
 */
public class Demo1 {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        List<String> tmp = new ArrayList<>();
        tmp.add("haha");
        tmp.add("呵呵");
        demo1.getIndexData(tmp);
    }

    public <T> void getIndexData(List<T> list) {
        Map<String, T> result = doStr(list);
        System.err.println(result.toString());
        result.values().forEach(integer -> System.err.println(integer.getClass()));
    }

    private <U> Map<String, U> doStr(List<U> list) {
        Map<String, U> result = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            result.put(list.get(i).hashCode() + "", (U) list.get(i));
        }
        return result;
    }
}
