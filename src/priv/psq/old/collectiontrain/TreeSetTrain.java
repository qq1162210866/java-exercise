package priv.psq.old.collectiontrain;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSetTrain.java
 * Description: 树集练习
 *
 * @author Peng Shiquan
 * @date 2020/8/16
 */
public class TreeSetTrain {
    public static void main(String[] args) {
        /**
         * 代码写完，还是不明白，后续了解。
         */
        SortedSet<ItemTest> itemTests = new TreeSet<>();
        itemTests.add(new ItemTest("A", 123));
        itemTests.add(new ItemTest("B", 456));
        itemTests.add(new ItemTest("C", 789));
        System.err.println(itemTests);

        NavigableSet<ItemTest> itemTests1 = new TreeSet<>(Comparator.comparing(ItemTest::getDescription));
        itemTests1.addAll(itemTests);
        System.err.println(itemTests1);


        String s= "5b706c61796c6973745d0d0a6974656d5f6e6f203d20310d0a6974656d30203d203130302c20312c20362c205c433030303030305c6673323432345c63323535303030303030303030b1a3b3d6b3b5bee05c6ed7a2d2e2b0b2c8ab0d0a";

    }
}
