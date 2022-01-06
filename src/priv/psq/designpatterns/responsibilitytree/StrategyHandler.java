package priv.psq.designpatterns.responsibilitytree;

/**
 * StrategyHandler.java
 * Description: 策略接口
 *
 * @author Peng Shiquan
 * @date 2021/12/29
 */
public interface StrategyHandler<T, R> {

    @SuppressWarnings("rawtypes")
    public static StrategyHandler DEFAULT = param -> null;

    R apply(T param);
}
