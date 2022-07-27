package priv.psq.old.internaltrain;

import java.util.ArrayList;


/**
 * CountWords.java
 * Description: 内部类练习2
 *
 * @author Peng Shiquan
 * @date 2020/4/4
 */
public class InternalTrainDemo2 {
    

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-09-04
     */
    public static void main(String[] args) {
        /**
         * 双括号的使用方法，匿名列表，适用于只使用一次的数组列表。
         */
        ArrayList<String> test = new ArrayList<String>() {{
            add("hah");
            add("test");
        }};
        System.err.println(test.toString());
    }

}
