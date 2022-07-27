package priv.psq.old.enumtrain;

/**
 * ClothesSize.java
 * Description: 衣服大小枚举类
 *
 * @author Peng Shiquan
 * @date 2019-07-13
 */
public enum ClothesSize {
    /**
     * 枚举类,利用构造方法传参。这里的四个码号其实相当于四个实例
     */
    S("S号"), L("L号"), XL("XL号"), XXL("XXL号");

    String size;

    public String getSize() {
        return size;
    }

    /**
     * Description: 构造方法，将枚举项的值赋值给枚举类的普通属性，再通过公共方法获取
     *
     * @param size
     * @return
     * @Author: Peng Shiquan
     * @Date: 2019-07-13
     */
    ClothesSize(String size) {
        this.size = size;
    }
}

