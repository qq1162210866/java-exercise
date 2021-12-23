package priv.psq.designpatterns.chainofresponsibilitypattern;

/**
 * ErrorLogger.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2021/12/23
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("Error Console::Logger: " + msg);
    }
}
