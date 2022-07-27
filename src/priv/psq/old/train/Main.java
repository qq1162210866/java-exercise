package priv.psq.old.train;

/**
 * Main.java
 * Description: 主方法类
 *
 * @author Peng Shiquan
 * @date 2019-07-15
 */
public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        //第一中获取class对象的方法，通过对象直接获取
        Class aClass1 = student.getClass();
        //打印类的名字，同时将类的包名一起打印
        System.err.println(aClass1.getName());

        //第二种获取class对象的方法，根据forname获取class对象
        String className = "train.Student";
        Class aClass2;
        try {
            aClass2 = Class.forName(className);
            System.err.println(aClass2.getName());
            System.err.println(aClass2 == aClass1);
            //通过newInstance方法获取该class对象的实例
            Object o = aClass2.newInstance();
            Student student1 = (Student) o;
            System.err.println(student1.eat());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //第三种获取class对象的方法，T.class将代表匹配的类对象
        Class aClass3 = Student.class;
        System.err.println(aClass3.getName());
        System.err.println(aClass1 == aClass3);


    }
}
