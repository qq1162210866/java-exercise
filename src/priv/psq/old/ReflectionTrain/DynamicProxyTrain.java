package priv.psq.old.ReflectionTrain;

import java.lang.reflect.Proxy;

/**
 * DynamicProxyTrain.java
 * Description: 动态代理练习，反射的小练习
 *
 * @author Peng Shiquan
 * @date 2021/5/30
 */
public class DynamicProxyTrain {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        System.err.println("目标对象：" + target.getClass());
        //通过原始类为参数创建一个代理类，让代理类做具体的事。要注意代理模式的三个要素：接口、原始类、代理类
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.err.println("代理对象：" + proxy.getClass());
        proxy.find();
        proxy.save();
    }
}

interface IUserDao {
    void save();

    void find();
}

class UserDao implements IUserDao {

    @Override
    public void save() {
        System.err.println("保存了用户");
    }

    @Override
    public void find() {
        System.err.println("查询了用户");
    }
}

class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //返回指定接口代理类的实例
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy1, method, args) -> {
                    String methodName = method.getName();
                    Object result = null;
                    if ("find".equals(methodName)) {
                        //调用原始类对象的方法，这一块目前不是很清楚
                        result = method.invoke(target, args);
                    } else {
                        System.err.println("开启事务");
                        result = method.invoke(target, args);
                        System.err.println("提交事务");
                    }
                    return result;
                });
        return proxy;
    }
}
