package com.xtd.ybls.util.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 服务处理器
 * @author frn
 * @date 2022/9/29 10:44
 */
@Slf4j
@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    public static final ChannelGroup CLIENTS = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static NettyServerHandler nettyServerHandler;

    public static final  String HEXES = "0123456789ABCDEF";


    @PostConstruct
    public void init() {
        nettyServerHandler = this;
    }

    /**
     * 客户端连接成功会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接成功："+ctx.channel().id().asShortText());
    }
    /**
     * 客户端注销会触发
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
        log.info("客户端注销： " + ctx.channel().id().asShortText());
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] req = (byte[]) msg;
        //此处为解析tcp参数所需要的方法！！！自定义
        String code = getCode(req);
        log.info("服务器收到消息: {}", code);
        String[] split = code.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str : split) {
            sb.append((char) Integer.parseInt(str, 16));
        }
        log.info("服务器解析消息: {}", sb.toString());
    }


    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
    /**
     * 客户端链接会出发
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端连接： " + ctx.channel().id().asShortText());
        CLIENTS.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        CLIENTS.remove(ctx.channel());
    }

    /**
     * 解析为十六进制数据
     */
    private String getCode(byte[] req) {
        final StringBuilder hex = new StringBuilder(2 * req.length);

        for (int i = 0; i < req.length; i++) {
            byte b = req[i];
            hex.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F))).append(" ");
        }
        return hex.toString();
    }
}