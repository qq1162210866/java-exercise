package priv.psq.designpatterns.singleton;

/**
 * LazySingle.java
 * Description: 懒汉式单例模式
 *
 * @author Peng Shiquan
 * @date 2022/1/7
 */
public class LazySingle {
    private static boolean tmp = false;

    private LazySingle() {
        synchronized (LazySingle.class) {
            //通过反射调用无参构造函数时，tmp还没有赋值。
            if (!tmp) {
                tmp = true;
                System.err.println("获取到单例模式，线程名称为：" + Thread.currentThread().getName());
            } else {
                throw new RuntimeException("不要尝试通过反射获取单例对象");
            }
        }
    }

    private volatile static LazySingle lazySingle;

    public static LazySingle getInstance() {
        if (lazySingle == null) {
            lazySingle = new LazySingle();
        }
        return lazySingle;
    }

    public static LazySingle getInstanceDoubleLock() {
        //双重检测锁模式 DCL懒汉式模式
        if (lazySingle == null) {
            synchronized (LazySingle.class) {
                if (lazySingle == null) {
                    //因为这段代码多并发状态下可能会导致获取对象为null的情况，所以需要加volatile
                    lazySingle = new LazySingle();
                }
            }
        }
        return lazySingle;
    }
}

