package priv.psq.designpatterns.singleton;

/**
 * InnerSingle.java
 * Description: 内部类单例模式
 *
 * @author Peng Shiquan
 * @date 2022/1/7
 */
public class InnerSingle {
    private InnerSingle() {

    }

    public static InnerSingle getInstance() {
        return InnerClass.INNER_SINGLE;
    }

    public static class InnerClass {
        private static final InnerSingle INNER_SINGLE = new InnerSingle();
    }
}
