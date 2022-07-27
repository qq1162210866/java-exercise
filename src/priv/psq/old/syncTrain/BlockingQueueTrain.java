package priv.psq.old.syncTrain;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueueTrain.java
 * Description:  阻塞队列的练习
 *
 * @author Peng Shiquan
 * @date 2020/12/26
 */
public class BlockingQueueTrain {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Input your directory eg: /Users/pengshiquan/Desktop/Developmentcache/JavaTrain/src/syncTrain");
            String directory = in.nextLine();
            System.out.println("Input your keyword eg volatile");
            String keyword = in.nextLine();
            Runnable enumerator = () -> {
                try {
                    enumrate(new File(directory));
                    //通过添加"包尾"来达到通知的效果
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(enumerator).start();
            for (int i = 1; i < SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else search(file, keyword);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    /**
     * Description: 列举目录下所有的文件或者目录，添加到队列中.会循环遍历目录的目录
     *
     * @param directory 需要列举的文件夹或者文件。
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/12/26
     */
    public static void enumrate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) enumrate(file);
            else queue.put(file);
        }
    }

    /**
     * Description: 搜索文件中是否含有关键字，有就打印出来
     *
     * @param file    需要搜索的文件
     * @param keyword 搜索时的关键字
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/12/26
     */
    public static void search(File file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                    //想法是测试队列的公平性，但是测试结果和预想的不太一样
                    //System.err.println(Thread.currentThread().getId());
                }
            }
        }
    }

}
