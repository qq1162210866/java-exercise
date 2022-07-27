package priv.psq.old.filestreamtrain;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * ReadFileDemo.java
 * Description:读取文件的demo
 *
 * @author Peng Shiquan
 * @date 2019-07-11
 */
public class ReadFileDemo {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(Paths.get("/Users/pengshiquan/Desktop/任务.md"));
            while (scanner.hasNext()) {
                String rows = scanner.nextLine();
                System.err.println(rows);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
