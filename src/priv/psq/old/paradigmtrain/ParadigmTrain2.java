package priv.psq.old.paradigmtrain;

/**
 * ParadigmTrain2.java
 * Description:  综合练习，把范型知识点串联起来
 *
 * @author Peng Shiquan
 * @date 2020/7/22
 */
public class ParadigmTrain2 {
    public static void main(String[] args) {
        Manager ceo = new Manager("zhangshan", 8000, 24);
        Manager cfo = new Manager("lisi", 9000, 25);
        Pair<Manager> managerPair = new Pair<>(ceo, cfo);
        printBuddies(managerPair);

        ceo.setMoney(10000);
        cfo.setMoney(20000);
        Manager[] managers = {ceo, cfo};
        Pair<Manager> managerPair1 = new Pair<>();
        minMaxBonus(managers, managerPair1);
        System.err.println("minMaxBonus:" + managerPair1.getFirst().getName() + "==" + managerPair1
                .getSecond().getName());
        maxMinBonus(managers, managerPair1);
        System.err.println("minMaxBonus:" + managerPair1.getFirst().getName() + "==" + managerPair1
                .getSecond().getName());


    }

    /**
     * Description: 通配符类型
     *
     * @param pair
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/7/22
     */
    public static void printBuddies(Pair<? extends Employee> pair) {
        Employee employee = pair.getFirst();
        Employee employee1 = pair.getSecond();
        System.err.println("printBuddies" + employee.getName() + "====" + employee1.getName() + "=====");
    }

    /**
     * Description: 通配符的超类型限定，限定父类
     *
     * @param managers
     * @param pair
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/7/22
     */
    public static void minMaxBonus(Manager[] managers, Pair<? super Manager> pair) {
        if (managers.length == 0) {
            return;
        }
        Manager min = managers[0];
        Manager max = managers[1];
        for (int i = 0; i < managers.length; i++) {
            if (min.getMoney() > managers[i].getMoney()) min = managers[i];
            if (max.getMoney() < managers[i].getMoney()) max = managers[i];
        }
        pair.setFirst(min);
        pair.setSecond(max);
    }

    public static void maxMinBonus(Manager[] managers, Pair<? super Manager> pair) {
        minMaxBonus(managers, pair);
        PairAlg.swapHelper(pair);
    }
}

class PairAlg {
    /**
     * Description: 无限定通配符
     *
     * @param pair
     * @return boolean
     * @Author: Peng Shiquan
     * @Date: 2020/7/22
     */
    public static boolean hasNull(Pair<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    public static void swap(Pair<?> pair) {

    }

    public static <T> void swapHelper(Pair<T> tPair) {
        T t = tPair.getFirst();
        tPair.setFirst(tPair.getSecond());
        tPair.setSecond(t);
    }
}
