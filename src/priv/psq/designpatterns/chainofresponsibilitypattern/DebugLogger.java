package priv.psq.designpatterns.chainofresponsibilitypattern;

/**
 * DebugLogger.java
 * Description: Debug实现类
 *
 * @author Peng Shiquan
 * @date 2021/12/23
 */
public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("DEBUG::Logger: " + msg);
    }
}
