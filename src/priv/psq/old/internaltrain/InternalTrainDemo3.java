package priv.psq.old.internaltrain;

/**
 * CountWords.java
 * Description: 练习静态内部类
 *
 * @author Peng Shiquan
 * @date 2020/4/4
 */
public class InternalTrainDemo3 {

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-09-04
     */
    public static void main(String[] args) {
        Double[] values = new Double[20];
        /**
         * 产生随机数
         */
        for (int i = 0; i < 20; i++)
            values[i] = 100 * Math.random();
        ArrayAlg.Pair p = ArrayAlg.minmax(values);
        System.err.println("min is : " + p.getFirst());
        System.err.println("max is : " + p.getSecond());
    }
}

/**
 * InternalTrainDemo3.java
 * Description:  数组排序类
 *
 * @author Peng Shiquan
 * @date 2019-09-04
 */
class ArrayAlg {

    /**
     * InternalTrainDemo3.java
     * Description:  静态内部类,不引用外部类对象
     *
     * @author Peng Shiquan
     * @date 2019-09-04
     */
    public static class Pair {
        private Double first;
        private Double second;

        public Pair(Double first, Double second) {
            this.first = first;
            this.second = second;
        }

        public Double getFirst() {
            return first;
        }

        public Double getSecond() {
            return second;
        }
    }

    public static Pair minmax(Double[] values) {
        /**
         * 默认为无穷大
         */
        Double min = Double.POSITIVE_INFINITY;
        /**
         * 默认为无穷小
         */
        Double max = Double.NEGATIVE_INFINITY;
        for (Double value : values) {
            if (min > value) min = value;
            if (max < value) max = value;
        }
        return new Pair(min, max);
    }
}
