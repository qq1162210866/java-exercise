package priv.psq.old.nativetrain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TransferHKTrain.java
 * Description: 调用海康SDK的练习
 *
 * @author Peng Shiquan
 * @date 2021/3/9
 */
public class TransferHKTrain {
    public static void main(String[] args) {
        String test = "runoooooobB";
        String pattern = "[A-Z]";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher m = pattern1.matcher(test);
        System.out.println(m.matches());

    }
}
