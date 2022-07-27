package priv.psq.old.streamtrain;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * CountWords.java
 * Description: 统计流中长单词的数量，流的简单练习
 *
 * @author Peng Shiquan
 * @date 2020/4/4
 */
public class CountWords {
    public static void main(String[] args) throws Exception {
        String wordsString = new String(Files.readAllBytes(Paths.get("/Users/Desktop/dev/aaa.txt")), StandardCharsets.UTF_8);
        //以非字母分隔符
        List<String> wordsList = Arrays.asList(wordsString.split("\\PL+"));
        /**
         * 使用迭代的方式查询大于12的单词
         */
        long count = 0;
        for (String word : wordsList) {
            if (word.length() > 12) count++;
        }
        System.err.println("使用迭代的方式来统计大于十二的单词" + count);
        /**
         * 使用流的方式查询大于12的单词
         */
        /**
         * 流是使用stream和parallelStream方法来创建的，filter方法用来对流进行转化，count
         * 方法用来终结操作
         */
        //单线程运行
        count = wordsList.stream().filter(w -> w.length() > 12).count();
        System.err.println("使用单线程的流的方式来统计大于十二的单词" + count);
        //多线程运行
        count = wordsList.parallelStream().filter(w -> w.length() > 12).count();
        System.err.println("使用多线程的流的方式来统计大于十二的单词" + count);
    }
}
