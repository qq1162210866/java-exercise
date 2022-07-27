package priv.psq.old.nettytrain;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Iterator;

/**
 * ByteBufTrain.java
 * Description: ByteBuf的练习
 *
 * @author Peng Shiquan
 * @date 2020/6/20
 */
public class ByteBufTrain {

    public void bufferTrain() {
        //堆缓存区
        ByteBuf byteBuf = Unpooled.buffer(8);
        //堆外缓存区
        ByteBuf byteBuf1 = Unpooled.directBuffer(16);
        //复合缓存区
        CompositeByteBuf byteBuf2 = Unpooled.compositeBuffer();
        //将堆和堆外添加到复合中
        byteBuf2.addComponents(byteBuf, byteBuf1);
        //删除堆缓存区
        byteBuf2.removeComponent(0);

        //使用迭代器循环bytebuf
        Iterator<ByteBuf> iterator = byteBuf2.iterator();
        while (iterator.hasNext()) {
            System.err.println(iterator.next().toString()+" -----  ");
            System.err.println("可读字节"+iterator.next());
        }


    }

    public static void main(String[] args) {
        ByteBufTrain byteBufTrain = new ByteBufTrain();
        byteBufTrain.bufferTrain();
    }
}
