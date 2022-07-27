package priv.psq.old.arraytrain;

/**
 * HeapTrain.java
 * Description: 堆的练习
 *
 * @author Peng Shiquan
 * @date 2020/5/2
 */
public class HeapTrain {

    private int[] arr;
    /**
     * 堆内当前堆元素
     */
    private int n;
    /**
     * 堆内最大堆元素
     */
    private int capacity;

    /**
     * Description:初始化
     *
     * @param count
     * @return
     * @Author: Peng Shiquan
     * @Date: 2020/5/2
     */
    public HeapTrain(int count) {
        capacity = count;
        arr = new int[capacity + 1];
        n = 0;
    }

    public void heapPrint() {
        for (int i = 0; i < n + 1; i++) {
            System.err.print("[" + arr[i] + "]");
        }
    }

    /**
     * Description: 换位方法
     *
     * @param a
     * @param b
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/5/2
     */
    public void swap(int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }

    /**
     * Description:向堆中插入元素
     *
     * @param value
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/5/2
     */
    public void insert(int value) {
        if (n >= capacity) {
            return;
        }
        n++;
        arr[n] = value;
        int i = n;
        /**
         * 两个判断条件，一个是i是不是标号最小的元素、节点是不是大于子节点
         */
        while (i / 2 > 0 && arr[i / 2] < arr[i]) {
            swap(i / 2, i);
            i = i / 2;
        }
    }

    /**
     * Description:删除堆顶元素
     *
     * @param
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/5/2
     */
    public void deleteMax() {
        if (n == 0) {
        }
        int tmp = arr[1];
        /**
         * 堆内可以放负数，如果arr[1]=0,负数就没法比较
         */
        int count = n;
        /**
         * 将最后的元素放到跟节点，防止数组空洞。同时将两步堆化合并为一步
         */
        arr[1] = arr[count];
        n--;
        heaply(1, n);
    }

    /**
     * Description: 堆化处理
     *
     * @param index
     * @param n
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/5/2
     */
    public void heaply(int index, int n) {
        while (true) {
            /**
             * 默认当前节点是最大节点
             */
            int maxValueIndex = index;
            /**
             *  先计算左节点
             */
            if (maxValueIndex * 2 <= n && arr[maxValueIndex] < arr[maxValueIndex * 2]) {
                maxValueIndex = maxValueIndex * 2;
            }
            /**
             * 计算右节点
             */
            if (maxValueIndex * 2 + 1 <= n && arr[maxValueIndex] < arr[maxValueIndex * 2 + 1]) {
                maxValueIndex = maxValueIndex * 2 + 1;
            }
            /**
             * 经过比较确实是最大节点
             */
            if (maxValueIndex == index) {
                break;
            }
            swap(index, maxValueIndex);
            /**
             * 把最大节点给到当前节点的子节点
             */
            index = maxValueIndex;
        }
    }

    public static void main(String[] args) {
        HeapTrain heapTrain = new HeapTrain(10);
        heapTrain.insert(3);
        heapTrain.insert(1);
        heapTrain.insert(9);
        heapTrain.heapPrint();
        System.err.println();
        heapTrain.deleteMax();
        heapTrain.heapPrint();

    }
}