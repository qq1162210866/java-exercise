package priv.psq.designpatterns.responsibilitytree;

/**
 * NodeImpl.java
 * Description: 策略树模式节点实现类
 *
 * @author Peng Shiquan
 * @date 2021/12/29
 */
class RootRouter extends AbstractStrategyRouter<Language, String> {

    @Override
    public StrategyMapper<Language, String> registerStrategyMapper() {
        StrategyMapper<Language, String> result = (Language param) -> {
            switch (param.getType()) {
                case "english":
                    return new NodeImpl();
                case "中文":
                    return new ChineseStrategy();
                default:
                    return null;
            }
        };
        return result;
    }
}

public class NodeImpl extends AbstractStrategyRouter<Language, String> implements StrategyHandler<Language, String> {

    @Override
    public StrategyMapper<Language, String> registerStrategyMapper() {
        StrategyMapper<Language, String> result = param -> {
            switch (param.getNumber()) {
                case 1:
                    return new OneStrategy();
                case 2:
                    return new TwoStrategy();
                default:
                    return null;
            }
        };
        return result;
    }

    @Override
    public String apply(Language param) {
        String str = this.applyStrategy(param);
        return "This is " + str;
    }
}


class ChineseStrategy extends AbstractStrategyRouter<Language, String> implements StrategyHandler<Language, String> {

    @Override
    public String apply(Language param) {
        String str = this.applyStrategy(param);
        return "这是" + str;
    }


    @Override
    public StrategyMapper<Language, String> registerStrategyMapper() {
        StrategyMapper<Language, String> result = (Language param) -> {
            switch (param.getNumber()) {
                case 1:
                    return new YiStrategy();
                case 2:
                    return new ErStrategy();
                default:
                    return null;
            }
        };
        return result;
    }
}

class OneStrategy implements StrategyHandler<Language, String> {

    @Override
    public String apply(Language param) {
        return "one";
    }
}

class YiStrategy implements StrategyHandler<Language, String> {

    @Override
    public String apply(Language param) {
        return "一";
    }
}

//2
class TwoStrategy implements StrategyHandler<Language, String> {

    @Override
    public String apply(Language param) {
        return "two";
    }
}

class ErStrategy implements StrategyHandler<Language, String> {

    @Override
    public String apply(Language param) {
        return "二";
    }
}

