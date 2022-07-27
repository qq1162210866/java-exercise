package priv.psq.old.paradigmtrain;

import java.util.ArrayList;
import java.util.List;

/**
 * ParadigmErrorTrain.java
 * Description:  范型错误的示范
 *
 * @author Peng Shiquan
 * @date 2020/7/22
 */
public class ParadigmErrorTrain {

    public static void main(String[] args) {

        //不能实例化参数化类型的数组
        //Pair<String>[] table = new Pair<String>[10];
        //不能构造范型数组

        List list =  new ArrayList();
        list.add(3);
        list.add("aa");
        System.err.println(list);

    }
}
