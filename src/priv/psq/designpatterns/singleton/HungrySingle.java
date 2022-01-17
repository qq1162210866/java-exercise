package priv.psq.designpatterns.singleton;

/**
 * HungrySingle.java
 * Description: 饿汉式单例模式
 *
 * @author Peng Shiquan
 * @date 2022/1/7
 */
public class HungrySingle {

    private HungrySingle() {

    }

    private final static HungrySingle HUNGRY_SINGLE = new HungrySingle();

    public static HungrySingle getInstance() {
        return HUNGRY_SINGLE;
    }
}
