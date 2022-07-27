package priv.psq.old.train;

import java.net.Socket;

/**
 * CountWords.java
 * Description: 统计流中长单词的数量，流的简单练习
 *
 * @author Peng Shiquan
 * @date 2020/4/4
 */
public class test {

    public static void socketClient() {
        try {
            Socket socket = new Socket("192.168.1.171", 8001);
            socket.getOutputStream();

            Thread.sleep(2000);
            System.out.println("aaa");
            socket.close();

            socket.getOutputStream();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        byte result = addressSwitch(23, 2);
        System.err.println(result);
    }

    public static byte parameterSwitch(int brightness, int colour) {
        brightness = (brightness << 5) & 0xE0;
        colour = (colour << 2) & 0xC;
        return (byte) (brightness | colour);
    }

    public static byte addressSwitch(int address, int time) {
        address = (address << 3) & 0xF8;
        time = (time << 1) & 0x6;
        return (byte) (address | time);

    }

}
