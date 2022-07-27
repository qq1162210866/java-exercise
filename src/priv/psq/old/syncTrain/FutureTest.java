package priv.psq.old.syncTrain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * FutureTest.java
 * Description: Future的练习
 *
 * @author Peng Shiquan
 * @date 2021/1/5
 */
public class FutureTest {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Input your directory eg: /Users/pengshiquan/Desktop/Developmentcache/JavaTrain/src/syncTrain");
            String directory = in.nextLine();
            System.out.println("Input your keyword eg volatile");
            String keyword = in.nextLine();
            MathCounter mathCounter = new MathCounter(new File(directory), keyword);
            FutureTask<Integer> task = new FutureTask<Integer>(mathCounter);
            Thread t = new Thread(task);
            t.start();
            try {
                System.err.println(task.get() + "符合的行数");
            } catch (Exception e) {

            }
        }
    }
}

/**
 * FutureTest.java
 * Description:  计数类，实现了Callable接口
 *
 * @author Peng Shiquan
 * @date 2020/12/29
 */
class MathCounter implements Callable<Integer> {
    private File directory;
    private String keyword;

    public MathCounter(File file, String keyword) {
        this.directory = file;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> result = new ArrayList<>();
        for (File file : files)
            if (file.isDirectory()) {
                MathCounter mathCounter = new MathCounter(file, keyword);
                FutureTask<Integer> task = new FutureTask<Integer>(mathCounter);
                result.add(task);
                Thread t = new Thread(task);
                t.start();
            } else {
                if (search(file)) count++;
            }
        for (Future<Integer> integerFuture : result) {
            count += integerFuture.get();

        }
        return count;
    }

    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
