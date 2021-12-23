package priv.psq.designpatterns.chainofresponsibilitypattern;

/**
 * AbstractLogger.java
 * Description: 责任链抽象类
 *
 * @author Peng Shiquan
 * @date 2021/12/23
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void submit(int level, String msg) {
        //当级别大于等于当前logger级别时，当前logger需要打印
        if (this.level <= level) this.write(msg);
        //只要有下一个logger，就需要打印
        if (this.nextLogger != null) nextLogger.submit(level, msg);
    }

    abstract protected void write(String msg);
}
