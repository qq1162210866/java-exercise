package priv.psq.old.collectiontrain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * IteratorTrain.java
 * Description:  迭代器练习demo
 *
 * @author Peng Shiquan
 * @date 2020/8/5
 */
public class IteratorTrain {
    public static void main(String[] args) {
        //创建一个继承了Collection的接口
        List<String> stringList = new ArrayList<>();
        stringList.add("hahaha");
        stringList.add("hehehe");
        //Collection接口扩展了Iterator接口
        Iterator iterator = stringList.iterator();
        //调用Iterator的forEachRemaining方法，传入一个lambda表达式，直接打印
        //iterator.forEachRemaining(s -> System.err.println(s));
        iterator.next();
        iterator.remove();
        System.err.println("目前还剩下的元素");
        iterator.forEachRemaining(s -> System.err.println(s));
    }
}
