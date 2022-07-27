package priv.psq.old.ThreadTrain;

/*
 * 第一种创建线程的方法，通过继承Thread类创建线程类
 */
public class demo1 extends Thread {
    private int i;//计数器

    //run方法就是线程执行体
    @Override
    public void run() {
        for (; i < 100; i++) {
            /*
             * 当线程类继承Thread类时，直接使用this可以获得当前线程
             */
            //获取当前线程的名字
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            /*
             * 运行的时候发现main的i不一定会到20，线程的启动是计算机调度的，具有一定的随机性
             * 两个子线程的i不是共享的，不会连续打印
             */
            //currentThread()总是返回当前正在执行的线程对象
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                //通过start()方法启动第一个线程
                new demo1().start();
                //启动第二个线程
                new demo1().start();
            }
        }
    }
}
