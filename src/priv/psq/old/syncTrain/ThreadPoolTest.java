package priv.psq.old.syncTrain;

/**
 * ThreadPoolTest.java
 * Description:  线程池的练习
 *
 * @author Peng Shiquan
 * @date 2021/1/5
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        Runnable target1 = ThreadPoolTest::test;
        Runnable target2 = ThreadPoolTest::test4;
        Thread t = new Thread(target1);
        t.start();
        Thread t2 = new Thread(target2);
        t2.start();
    }

    public synchronized static void test() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("这是一个静态测试方法1");
        }
    }

    public void test2() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("这是一个普通测试方法2");
        }
    }

    public static void test3() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("这是一个静态测试方法3");
        }
    }

    public synchronized static void test4() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("这是一个静态测试方法4");
        }
    }

}
