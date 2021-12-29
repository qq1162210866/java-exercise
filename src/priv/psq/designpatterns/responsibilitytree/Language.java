package priv.psq.designpatterns.responsibilitytree;

/**
 * Language.java
 * Description: 语言，参数类
 *
 * @author Peng Shiquan
 * @date 2021/12/29
 */
public class Language {
    private String type;
    private int number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Language(String type, int number) {
        this.type = type;
        this.number = number;
    }
}
