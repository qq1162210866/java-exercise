package priv.psq.old.nettytrain;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * TCPClientHandler.java
 * Description: 客户端的主要业务处理类
 *
 * @author Peng Shiquan
 * @date 2020/6/19
 */
public class TCPClientHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf byteBuf;

    public TCPClientHandler() {
        /**
         * 将发送消息写入缓存区
         */
        byte[] bytes = "this is test client".getBytes();
        byteBuf = Unpooled.buffer(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
         * 当建立连接后调用这个方法
         */
        System.err.println("写入数据:" + byteBuf.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /**
         * 读取服务端返回的信息
         */
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.err.println("this is body" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        /**
         * 异常处理
         */
        ctx.close();
    }
}
