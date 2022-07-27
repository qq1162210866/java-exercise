package priv.psq.old.nettytrain;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * TCPServerTrain.java
 * Description:  netty服务端的练习
 *
 * @author Peng Shiquan
 * @date 2020/6/18
 */
public class TCPServerTrain {
    //默认端口
    private Integer port = 10000;

    public TCPServerTrain(Integer port) {
        this.port = port;
    }

    public void run() throws Exception {
        // 接收传入的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //处理传入的连接，一般是bossGroup的二倍
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //服务端应用开发的入口
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //设置主从线程池
            serverBootstrap.group(bossGroup, workGroup)
                    //指定通道channel的类型，因为是服务端，所以是NioServerSocketChannel
                    .channel(NioServerSocketChannel.class)
                    //设置子通道也就是SocketChannel的处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new TCPServerHandler());
                        }
                    })
                    //配置ServerSocketChannel的选项
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //配置子通道也就是SocketChannel的选项
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            //绑定并侦听某个端口
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //如何没有客户端连接就会关闭Channel和两个线程池
            channelFuture.channel().closeFuture().sync();
        } finally {
            /**
             * 关闭线程池
             */
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        int port = 10000;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new TCPServerTrain(port).run();

    }

}
