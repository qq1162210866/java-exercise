package priv.psq.old.train;

/**
 * Person.java
 * Description: 人类抽象类
 *
 * @author Peng Shiquan
 * @date 2019-07-12
 */
public abstract class Person {

    private Integer age;

    private String name;

    /**
     * Description: 吃东西
     *
     * @param
     * @return java.lang.String
     * @Author: Peng Shiquan
     * @Date: 2019-07-12
     */
    public abstract String eat();

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
