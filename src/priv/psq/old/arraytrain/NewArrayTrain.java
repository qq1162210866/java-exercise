package priv.psq.old.arraytrain;

import priv.psq.old.enumtrain.ClothesSize;

import java.util.ArrayList;

/**
 * NewArrayTrain.java
 * Description: 新建数组练习
 *
 * @author Peng Shiquan
 * @date 2019-07-13
 */
public class NewArrayTrain {

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-13
     */
    public static void main(String[] args) {
        //静态方法中无法调用普通方法
        NewArrayTrain newArrayTrain = new NewArrayTrain();
        Double result = newArrayTrain.max(1.2, 2.2, 3.3, 5.8, 0.1);
        System.err.println(result);

        ClothesSize clothesSize = ClothesSize.XL;
        System.err.println(clothesSize.getSize());
        newArrayTrain.selectClothesSize(clothesSize);
    }

    /**
     * Description: 枚举类练习，选择衣服的尺寸大小
     *
     * @param clothesSize
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-13
     */
    public void selectClothesSize(ClothesSize clothesSize) {
        switch (clothesSize) {
            case L:
                System.err.println("选择的是L号");
                break;
            case S:
                System.err.println("选择的是S号");
                break;
            case XL:
                System.err.println("选择的是XL号");
                break;
            case XXL:
                System.err.println("选择的是XXL号");
                break;
            default:
                System.err.println("没有这个尺寸");
        }
    }

    /**
     * Description:求出最大的数（参数数量可变）
     *
     * @param doubles
     * @return java.lang.Double
     * @Author: Peng Shiquan
     * @Date: 2019-07-13
     */
    public Double max(double... doubles) {
        //接收可变参数使用数组接收
        Double result = Double.NEGATIVE_INFINITY;
        for (Double aDouble : doubles) {
            result = aDouble > result ? aDouble : result;
        }
        return result;
    }

    /**
     * Description:数组方法练习
     *
     * @param
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-13
     */
    public void arrayMethodTrain() {
        //jdk7后面可以不使用new ArrayList<String>()
        ArrayList<String> strings = new ArrayList<>();
        strings.add("测试1");
        //将数组大小调整，将多余的空间回收（最好在确定长度的时候使用该方法）
        strings.trimToSize();
        //仍然可以添加新元素，但是需要重新移动存储块
        strings.add("aaa");
        System.err.println(strings.size());
    }
}
