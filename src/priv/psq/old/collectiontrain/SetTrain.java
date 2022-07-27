package priv.psq.old.collectiontrain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * SetTrain.java
 * Description: Set练习
 *
 * @author Peng Shiquan
 * @date 2020/8/13
 */
public class SetTrain {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long l = 0;
        try {
            Scanner in = new Scanner(System.in);
            while (!in.hasNext("eof")) {
                String word = in.next();
                //因为电脑的性能不同，这里可能会是0
                long callTime = System.currentTimeMillis();
                System.err.println(callTime);
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                System.err.println(callTime);
                l += callTime;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = words.iterator();
        for (int i = 0; i <= 20 && iterator.hasNext(); i++) {
            System.err.println(iterator.next());
        }
        System.err.println("==============");
        System.err.println(words.size() + "时间花费" + l + "时间");
    }
}
