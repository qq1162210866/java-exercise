package priv.psq.old.syncTrain;

import java.util.Arrays;

/**
 * SyncBank.java
 * Description:Java关键字synchronized 的使用
 *
 * @author Peng Shiquan
 * @date 2020/12/14
 */
public class SyncBank {
    private final double[] accounts;

    /**
     * Description: 初始化
     *
     * @param customerNum
     * @param balance
     * @return
     * @Author: Peng Shiquan
     * @Date: 2020/11/8
     */
    public SyncBank(int customerNum, double balance) {

        /**
         * 填充数值
         */
        accounts = new double[customerNum];
        Arrays.fill(accounts, balance);
    }

    /**
     * Description: 转账方法
     *
     * @param from
     * @param to
     * @param money
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/11/9
     */
    public synchronized void transfer(int from, int to, double money) throws InterruptedException {

        while (accounts[from] < money)
            wait();
        System.err.println(Thread.currentThread());
        accounts[from] -= money;
        System.out.printf(" %10.2f from %d to %d", money, from, to);
        accounts[to] += money;
        System.out.printf("the total balance is %10.2f", getTotalbalance());
        notify();
    }

    /**
     * Description: 获取所有的余额
     *
     * @param
     * @return double
     * @Author: Peng Shiquan
     * @Date: 2020/11/9
     */
    public synchronized double getTotalbalance() {
        double sum = 0;


        for (double a : accounts) {
            sum += a;
        }
        return sum;


    }

    /**
     * Description: 获取当前客户人数
     *
     * @param
     * @return int
     * @Author: Peng Shiquan
     * @Date: 2020/11/9
     */
    public int getCustomerNum() {
        return accounts.length;
    }
}
