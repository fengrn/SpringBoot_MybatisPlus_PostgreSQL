package com.xtd.ybls.util.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务初始化器
 * @author frn
 * @date 2022/9/29 10:43
 */
@Slf4j
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 解析 byte
        socketChannel.pipeline().addLast("decoder", new ByteArrayDecoder());
        socketChannel.pipeline().addLast("encoder", new ByteArrayEncoder());
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }
}