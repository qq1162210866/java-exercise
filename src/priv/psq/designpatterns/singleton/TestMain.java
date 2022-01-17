package priv.psq.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * TestMain.java
 * Description:测试方法
 *
 * @author Peng Shiquan
 * @date 2022/1/7
 */
public class TestMain {

    public static void main(String[] args) {
        enumPractice();
    }

    /**
     * Description: 懒汉式获取单例对象
     *
     * @param
     * @return void
     * @author Peng Shiquan
     * @date 2022-01-17
     */
    public static void lazyTrain() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> LazySingle.getInstance(), i + "").start();
        }
    }

    public static void reflectionPractice() {
        //LazySingle lazySingle = LazySingle.getInstance();
        LazySingle lazySingle = null;
        LazySingle lazySingle2 = null;
        try {
            //通过反射无参构造函数构建Constructor对象
            Constructor<LazySingle> constructor = LazySingle.class.getDeclaredConstructor(null);
            //设置禁止java语言访问检查，即可以访问私有变量
            constructor.setAccessible(true);
            //修改私有字段
            Field tmp = LazySingle.class.getDeclaredField("tmp");
            tmp.setAccessible(true);

            lazySingle = constructor.newInstance();

            //重置tmp字段的值
            tmp.set(constructor, false);
            lazySingle2 = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("两个单例是否一致：" + (lazySingle == lazySingle2));
    }

    public static void enumPractice() {
        EnumSingle enumSingle = EnumSingle.INSTANCE;
        EnumSingle enumSingle2 = null;
        try {
            Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            enumSingle2 = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("两个单例是否一致：" + (enumSingle == enumSingle2));
    }


}
