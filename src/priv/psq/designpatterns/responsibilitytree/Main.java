package priv.psq.designpatterns.responsibilitytree;

/**
 * Main.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2021/12/29
 */
public class Main {
    public static void main(String[] args) {
        //Language enLanguage = new Language("english", 1);
        Language cnLanguage = new Language("中文", 2);

        RootRouter root = new RootRouter();
        String applyStrategy = root.applyStrategy(cnLanguage);
        System.out.println(applyStrategy);
    }
}
