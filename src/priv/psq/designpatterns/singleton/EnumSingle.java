package priv.psq.designpatterns.singleton;

/**
 * EnumSingle.java
 * Description: 枚举类单例对象
 *
 * @author Peng Shiquan
 * @date 2022/1/17
 */
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}
