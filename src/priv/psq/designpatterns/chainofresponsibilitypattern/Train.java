package priv.psq.designpatterns.chainofresponsibilitypattern;

/**
 * Train.java
 * Description: 责任链模式练习
 *
 * @author Peng Shiquan
 * @date 2021/12/23
 */
public class Train {
    public static void main(String[] args) {
        AbstractLogger logger = init();
        logger.submit(AbstractLogger.INFO, "this is info msg");
        logger.submit(AbstractLogger.DEBUG, "this is debug msg");
        logger.submit(AbstractLogger.ERROR, "this is error msg");


    }

    /**
     * Description: 责任链初始化
     *
     * @param
     * @return priv.psq.designpatterns.chainofresponsibilitypattern.AbstractLogger
     * @Author Peng Shiquan
     * @Date 2021-12-23
     */
    public static AbstractLogger init() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }
}
