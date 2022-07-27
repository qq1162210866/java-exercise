package priv.psq.old.network_train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * NetWorkTrain.java
 * Description: 网络测试demo
 *
 * @author Peng Shiquan
 * @date 2020/6/14
 */
public class NetWorkTrain {
    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/6/15
     */
    public static void main(String[] args) {
        String ipAddress = "192.168.16.125";


        try {
            /**
             * Jdk1.5的InetAddresss方式
             */
            System.err.println("Jdk1.5的InetAddresss方式");
            System.err.println("主机的状态，" + pingforInetAddresss(ipAddress));

            /**
             * 直接调用CMD
             */
            System.err.println("直接调用CMD");
            //pingForCMD(ipAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("更加完善的调用CMD方法");
        System.err.println("主机的状态" + pingForExec(ipAddress, 5, 1000));
    }

    /**
     * Description: Jdk1.5的InetAddresss方式，返回值是true时，说明host是可用的
     *
     * @param ipAddress
     * @return boolean
     * @Author: Peng Shiquan
     * @Date: 2020/6/15
     */
    public static boolean pingforInetAddresss(String ipAddress) throws Exception {
        //超时应该在3秒以上
        int timeOut = 3000;
        // 当返回值是true时，说明host是可用的，false则不可。
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);
        return status;
    }

    /**
     * Description: 直接调用CMD,方法直接将CMD窗口的信息打印出来
     *
     * @param ipAddress
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/6/15
     */
    public static void pingForCMD(String ipAddress) throws Exception {
        String line = null;
        try {
            Process pro = Runtime.getRuntime().exec("ping " + ipAddress);
            BufferedReader buf = new BufferedReader(new InputStreamReader(
                    pro.getInputStream()));
            while ((line = buf.readLine()) != null)
                System.out.println(line);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Description: 更加完善的调用CMD方法
     *
     * @param ipAddress
     * @param pingTimes
     * @param timeOut
     * @return boolean
     * @Author: Peng Shiquan
     * @Date: 2020/6/15
     */
    public static boolean pingForExec(String ipAddress, int pingTimes, int timeOut) {
        BufferedReader in = null;
        // 将要执行的ping命令,此命令是windows格式的命令
        Runtime r = Runtime.getRuntime();

        String pingCommand = "ping " + "-c " + pingTimes + " " + ipAddress;

        try {   // 执行命令并获取输出
            System.out.println(pingCommand);
            Process p = r.exec(pingCommand);
            if (p == null) {
                return false;
            }
            // 逐行检查输出,计算类似出现=23ms TTL=62字样的次数
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int connectedCount = 0;
            String line = null;
            while ((line = in.readLine()) != null) {
                connectedCount += getCheckResult(line);
                // 如果出现类似=23ms TTL=62这样的字样,出现的次数=测试次数则返回真
            }
            return connectedCount == pingTimes;
        } catch (Exception ex) {
            ex.printStackTrace();   // 出现异常则返回假
            return false;
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Description: 若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.
     *
     * @param line
     * @return int
     * @Author: Peng Shiquan
     * @Date: 2020/6/15
     */
    private static int getCheckResult(String line) {
        //System.out.println("控制台输出的结果为:" + line);
        String trueZF = "time=";
        if (line.contains(trueZF)) {
            return 1;
        } else {
            return 0;
        }
    }
}
