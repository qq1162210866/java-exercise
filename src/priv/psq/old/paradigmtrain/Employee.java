package priv.psq.old.paradigmtrain;

/**
 * Employee.java
 * Description:  雇员类
 *
 * @author Peng Shiquan
 * @date 2020/7/22
 */
public class Employee {
    String name;
    Integer money;
    Integer age;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Employee.java
 * Description: 经理类
 *
 * @author Peng Shiquan
 * @date 2020/7/22
 */
class Manager extends Employee {
    public Manager(String name, Integer money, Integer age) {
        this.name = name;
        this.money = money;
        this.age = age;

    }
}
