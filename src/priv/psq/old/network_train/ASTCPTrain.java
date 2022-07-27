package priv.psq.old.network_train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ASTCPTrain.java
 * Description: 气象站TCP链接测试demo
 *
 * @author Peng Shiquan
 * @date 2020/6/17
 */
public class ASTCPTrain extends ServerSocket {

    public ASTCPTrain(int port) throws IOException {
        super(port);

        try {
            while (true) {
                // 监听一端口，等待客户接入
                Socket socket = accept();
                // 将会话交给线程处理
                new ServerThread(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(); // 关闭监听端口
        }
    }

    //inner-class ServerThread
    class ServerThread extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        // Ready to conversation
        public ServerThread(Socket s) throws IOException {
            this.socket = s;
            // 构造该会话中的输入输出流
            in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream(), "GB2312"));
            out = new PrintWriter(socket.getOutputStream(), true);
            start();
        }

        // Execute conversation
        @Override
        public void run() {
            try {

                // Communicate with client until "bye "received.
                while (true) {
                    // 通过输入流接收客户端信息
                    String line = in.readLine();
                    if (line == null || "".equals(line.trim())) { //是否终止会话
                        break;
                    }
                    System.out.println("Received  message: " + line);
                    if (line.contains("BG") && line.contains("ED")) {
                        ARPojo arPojo = ARSwitch.LineSwitch(line);
                        System.err.println(arPojo.toString());
                    }
                    // 通过输出流向客户端发送信息
                    out.println(line);
                    out.flush();
                }
                out.close();
                in.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2020/6/17
     */
    public static void main(String[] args) {
        try {
            new ASTCPTrain(10000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
