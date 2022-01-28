package com.quyuanjin.imsevennetty.handler;

import com.quyuanjin.imsevennetty.myinterface.My;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import java.util.HashMap;



public class ProtocolProcessor {
    private ChannelGroup channelGroup;
    private HashMap hashMap;

    public ProtocolProcessor(ChannelGroup channelGroup, HashMap hashMap) {
        this.channelGroup = channelGroup;
        this.hashMap = hashMap;
    }

    public void doSomeThing(My my, String userId, String contant) {
        System.out.println("netty正在分发。。。目标userId是" + userId);
        System.out.println("netty正在分发。。。内容是" + contant);
        System.out.println("netty分发完成");

        //如果hashmap存有接收者id,给发过去
        if (hashMap.containsKey(userId)) {
            ChannelId channelid = (ChannelId) hashMap.get(userId);
            String backmsg = contant+ "\r\n";
            channelGroup.find(channelid).writeAndFlush(backmsg);
        }
        //my.say();
    }

}
