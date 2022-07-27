package priv.psq.old.internaltrain;

/**
 * InternalTrainDemo4.java
 * Description:  内部类的语法练习
 *
 * @author Peng Shiquan
 * @date 2021/6/4
 */
public class InternalTrainDemo4 {
    String name = "李四";
    Integer age = 15;

    public void start(int a, int b) {
        class interMethodClass {
            public void test() {
                System.err.println("a: " + a);
            }
        }
    }

    public class InterClass {
        //不能存在静态变量
        //static int a = 1;

        public InterClass() {
            name = "张三";
            age = 14;
        }

        public InternalTrainDemo4 getOuterClass() {
            //返回声明内部类的外部类对象。
            return InternalTrainDemo4.this;
        }
    }

    public static void main(String[] args) {
        //普通内部类的声明方式
        InternalTrainDemo4 outer = new InternalTrainDemo4();
        InterClass interClass = outer.new InterClass();
        //获取已经实例化的外部类对象，和outer值相等
        InternalTrainDemo4 outer2 = interClass.getOuterClass();
        System.err.println("name: " + outer2.name + "  age: " + outer.age);
    }
}
