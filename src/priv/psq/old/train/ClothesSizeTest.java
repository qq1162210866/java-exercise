package priv.psq.old.train;

import enumtrain.ClothesSize;

import java.util.Scanner;

/**
 * ClothesSizeTest.java
 * Description:  枚举类测试方法
 *
 * @author Peng Shiquan
 * @date 2020/6/30
 */
public class ClothesSizeTest {

    public static void main(String[] args) {
        /**
         * 打印枚举值的值和name
         */
        ClothesSize clothesSize = ClothesSize.XL;
        System.err.println("根据构造方法获取枚举类型的值：" + clothesSize.getSize());
        System.err.println("直接获取枚举类型的name" + clothesSize.toString());
        /**
         * 获取全部的枚举值
         */
        ClothesSize[] clothesSizes = ClothesSize.values();
        for (ClothesSize clothesSize1 : clothesSizes) {
            System.err.println("枚举值name为：" + clothesSize1.toString() + "，枚举值value为：" + clothesSize1.getSize());
        }
        /**
         * 根据键盘的输入取对应的枚举值
         */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toUpperCase();
        ClothesSize clothesSize1 = Enum.valueOf(ClothesSize.class, input);
        System.err.println("输入的枚举值name为：" + clothesSize1.toString() + "，输入的枚举值value为：" + clothesSize1.getSize());
    }

}
