package priv.psq.old.paradigmtrain;

import java.util.Date;
import java.util.function.Supplier;

/**
 * paradigmTrain3.java
 * Description: 范型方法桥方法练习
 *
 * @author Peng Shiquan
 * @date 2021/5/13
 */
public class paradigmTrain3 {
    public static void main(String[] args) {
        Base<Date> base = new Test();
        //这里调用的应该是setFirst(Date date),但是实际会调用setFirst(Object date)
        base.setFirst(new Date());
        //实例化类型变量的推荐方式
        Base<String> base1 = Base.makeBase(String::new);
    }
}

class Test extends Base<Date> {
    @Override
    public void setFirst(Date date) {
        System.err.println("这是子类的覆盖方法");
    }
    //这里编译后会生成一个桥方法，为了维持多态
//    public void setFirst(Object date){
//        setFirst((Date) date);
//    }
}

class Base<T> {
    public void setFirst(T t) {
        System.err.println("这是父类的方法");
    }

    public static <T> Base<T> makeBase(Supplier<T> tSupplier) {
        return new Base<>();
    }
}
