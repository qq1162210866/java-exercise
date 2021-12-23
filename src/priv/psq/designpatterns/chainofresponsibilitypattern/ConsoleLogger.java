package priv.psq.designpatterns.chainofresponsibilitypattern;

/**
 * ConsoleLogger.java
 * Description: 控制台打印logger实现类
 *
 * @author Peng Shiquan
 * @date 2021/12/23
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("Standard Console::Logger: " + msg);
    }
}
