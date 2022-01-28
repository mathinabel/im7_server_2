package com.quyuanjin.imsevennetty.chat;

import com.quyuanjin.imsevennetty.handler.ProtocolProcessor;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {
    final ChannelGroup channelGroup;
    public static HashMap hashMap = new HashMap<String, ChannelId>();
    public static ProtocolProcessor pp;

    public ChatServerHandler(ChannelGroup channels) {
        this.channelGroup = channels;
        pp = new ProtocolProcessor(channelGroup, hashMap);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        log.info("channelgroup当前连接个数为：" + channelGroup.size());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.remove(ctx.channel());
        hashMap.remove(getKey(hashMap, ctx.channel().id()));

        //   log.info(ctx.channel().id()+":离线了");
        //   log.info("hashmap当前连接个数为："+hashMap.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        if (StringUtil.isNullOrEmpty(s)) {
            return;
        }
        System.out.println(s);
        String[] strings = splitSWithI(s);
        switch (strings[0]) {
            case "token":
                hashMap.put(strings[1], channelHandlerContext.channel().id());
                System.out.println("新连接建立，hashmap。put：key是" + strings[1] + "  value是：" + channelHandlerContext.channel());
                break;

        }
    }

    private String[] splitSWithI(String s) {
        return s.split("\\|");
    }

    //根据value值获取到对应的一个key值
    public static String getKey(HashMap<String, ChannelId> map, ChannelId value) {
        String key = null;
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for (String getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                key = getKey;
            }
        }
        return key;
        //这个key肯定是最后一个满足该条件的key.
    }
}
