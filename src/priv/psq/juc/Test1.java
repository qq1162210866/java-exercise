package priv.psq.juc;

/**
 * Test1.java
 * Description: juc练习
 *
 * @author Peng Shiquan
 * @date 2021/8/29
 */
public class Test1 {
    public static void main(String[] args) {
        Ticker ticker = new Ticker();
        new Thread(() -> {
            for (int i = 0; i < 40; i++)
                ticker.sellTickets();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++)
                ticker.sellTickets();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++)
                ticker.sellTickets();
        }, "C").start();

    }
}

class Ticker {
    private Integer ticket = 30;

    public void sellTickets() {
        if (ticket > 0)
            System.err.println("当前线程为" + Thread.currentThread().getName() + "当前售票为第" + ticket + "张。还剩余：" + (ticket--) + "张");
    }
}
