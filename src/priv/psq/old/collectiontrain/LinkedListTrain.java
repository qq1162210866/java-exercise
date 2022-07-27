package priv.psq.old.collectiontrain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedListTrain.java
 * Description:  链表练习
 *
 * @author Peng Shiquan
 * @date 2020/8/13
 */
public class LinkedListTrain {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("A");
        a.add("C");
        a.add("E");
        List<String> b = new LinkedList<>();
        b.add("B");
        b.add("D");
        b.add("F");
        b.add("G");
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            /**
             * 在当前位置前添加一个元素
             */
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.err.println(a);
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                //删除前一个元素
                bIter.remove();
            }
        }
        System.err.println(b);

        a.removeAll(b);
        System.err.println(a);
    }
}
