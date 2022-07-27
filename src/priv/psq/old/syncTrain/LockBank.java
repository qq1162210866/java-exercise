package priv.psq.old.syncTrain;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockBank.java
 * Description: 带锁的银行类
 *
 * @author Peng Shiquan
 * @date 2020/11/8
 */
public class LockBank {

    private final double[] accounts;
    /**
     * 条件锁
     */
    private Lock banlLock;
    private Condition sufficientFunds;

    /**
     * Description: 初始化
     *
     * @param customerNum
     * @param balance
     * @return
     * @Author: Peng Shiquan
     * @Date: 2020/11/8
     */
    public LockBank(int customerNum, double balance) {

        /**
         * 填充数值
         */
        accounts = new double[customerNum];
        Arrays.fill(accounts, balance);
        banlLock = new ReentrantLock();
        sufficientFunds = banlLock.newCondition();
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
    public void transfer(int from, int to, double money) throws InterruptedException {
        banlLock.lock();
        try {
            while (accounts[from] < money) {
                //等待
                sufficientFunds.await();
            }
            System.err.println(Thread.currentThread());
            accounts[from] -= money;
            System.out.printf(" %10.2f from %d to %d", money, from, to);
            accounts[to] += money;
            System.out.printf("the total balance is %10.2f", getTotalbalance());
            sufficientFunds.signalAll();
        } finally {
            banlLock.unlock();
        }
    }

    /**
     * Description: 获取所有的余额
     *
     * @param
     * @return double
     * @Author: Peng Shiquan
     * @Date: 2020/11/9
     */
    public double getTotalbalance() {
        double sum = 0;
        banlLock.lock();
        try {
            for (double a : accounts) {
                sum += a;
            }
            return sum;

        } finally {
            banlLock.unlock();
        }
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
