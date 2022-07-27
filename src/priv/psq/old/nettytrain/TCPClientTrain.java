package priv.psq.old.nettytrain;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * TCPClientTrain.java
 * Description:  netty客户端练习
 *
 * @author Peng Shiquan
 * @date 2020/6/19
 */
public class TCPClientTrain {
    public void connect(int port, String host) throws Exception {
        //配置客户端的线程组，客户端只有一个线程组
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //放入自己的业务Handler
                            socketChannel.pipeline().addLast(new TCPClientHandler());
                        }
                    });
            //发起异步连接操作，同步阻等待结果
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            //等待客户端链路关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            //释放NIO线程组
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 10000;
        if (args != null && args.length > 0) {
            try {
                //获取输入的port
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        new TCPClientTrain().connect(8008, "192.168.1.166");
    }
}
