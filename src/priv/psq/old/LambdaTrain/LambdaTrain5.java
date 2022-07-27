package priv.psq.old.LambdaTrain;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * LambdaTrain5.java
 * Description: lambda表达式练习，练习方法引用的构造方法引用
 *
 * @author Peng Shiquan
 * @date 2019-08-13
 */
public class LambdaTrain5 {
    /**
     * 如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用
     * 语法
     * 类名::new
     */

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-08-13
     */
    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person();
        Supplier<Person> supplier1 = Person::new;
        supplier.get();
        supplier1.get();

        Consumer<Integer> consumer = (i) -> new Student(i);
        Consumer<Integer> consumer1 = Student::new;
        consumer.accept(1);
        consumer1.accept(2);

        /**
         * 有参构造器
         */
        Function<String, Integer> function = s -> s.length();
        Function<String, Integer> function1 = String::length;

        System.out.println("this method have one parameter" + function.apply("hello"));
        System.out.println("this method have one parameter" + function1.apply("test"));

        Function<String, Student> function2 = Student::new;
        function2.apply("hahahah");


    }

}

class Person {
    /**
     * Description: 重写构造方法
     *
     * @param
     * @return
     * @Author: Peng Shiquan
     * @Date: 2019-08-13
     */
    public Person() {
        System.out.println("this is Person's construction method");
    }
}

class Student {
    public Student() {
        System.out.println("this method have no parameter ");
    }

    public Student(int i) {
        System.out.println("this method have one parameter" + i);
    }

    public Student(String s) {
        System.out.println("this method have one parameter" + s);
    }
}
