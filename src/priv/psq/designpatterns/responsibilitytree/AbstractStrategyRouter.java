package priv.psq.designpatterns.responsibilitytree;

/**
 * AbstractStrategyRouter.java
 * Description: 责任树模式router，完成对策略对分发
 *
 * @author Peng Shiquan
 * @date 2021/12/29
 */
public abstract class AbstractStrategyRouter<T, R> {

    public interface StrategyMapper<T, R> {
        StrategyHandler<T, R> get(T param);
    }


    private StrategyMapper<T, R> strategyMapper;

    public AbstractStrategyRouter() {
        strategyMapper = registerStrategyMapper();
    }

    @SuppressWarnings("unchecked")
    private StrategyHandler<T, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R applyStrategy(T param) {
        final StrategyHandler<T, R> strategyHandler = strategyMapper.get(param);
        if (strategyHandler != null) {
            return strategyHandler.apply(param);
        }
        return defaultStrategyHandler.apply(param);
    }

    public abstract StrategyMapper<T, R> registerStrategyMapper();
}
