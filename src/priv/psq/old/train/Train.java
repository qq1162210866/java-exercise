package priv.psq.old.train;


public class Train {
    static volatile Integer i = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable a = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (i != 0) {
                            i.wait();
                        }
                        synchronized (i) {
                            if (i == 0) {
                                i = 1;
                                System.err.println("A");
                            }
                        }
                        i.notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable b = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (i != 1) {
                            i.wait();
                        }
                        synchronized (i) {
                            if (i == 1) {
                                i = 2;
                                System.err.println("B");
                            }
                        }
                        i.notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable c = () -> {
            try {
                while (true) {
                    if (i != 2) {
                        i.wait();
                    }
                    synchronized (i) {
                        if (i == 2) {
                            i = 0;
                            System.err.println("C");
                        }
                    }
                    i.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);
        Thread threadC = new Thread(c);
        threadA.start();
        threadB.start();
        threadC.start();


    }

    public int test() {
        Train t = null;
        t.test11();
        return 0;
    }

    public static void test11() {
        System.err.println("aaa");
    }
}
