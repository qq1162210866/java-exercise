package priv.psq.old.train;

/**
 * Student.java
 * Description: 继承person抽象类
 *
 * @author Peng Shiquan
 * @date 2019-07-12
 */
public class Student extends Person implements Comparable<Student> {

    /**
     * Description: 必需要重写的方法，不重写的情况就是子类也是抽象类
     *
     * @param
     * @return java.lang.String
     * @Author: Peng Shiquan
     * @Date: 2019-07-12
     */
    @Override
    public String eat() {

        return "学生需要在食堂中吃饭!";
    }

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-07-12
     */
    public static void main(String[] args) {

        //可以定义一个抽象类的对象变量，但是它只能引用非抽象子类的对象。
        Person person = new Student();
        System.out.printf(person.eat());
    }

    /**
     * Description: 实现Comparable接口需要提供compareTo方法（根据学生的年龄排大小）
     *
     * @param otherStudent
     * @return int
     * @Author: Peng Shiquan
     * @Date: 2019-07-17
     */
    @Override
    public int compareTo(Student otherStudent) {
        //o的年纪小则返回正数，大则返回负数，相等返回0
        return Double.compare(getAge(), otherStudent.getAge());
    }
}
