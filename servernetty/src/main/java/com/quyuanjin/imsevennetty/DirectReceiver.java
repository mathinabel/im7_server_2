package com.quyuanjin.imsevennetty;


import com.quyuanjin.imsevennetty.chat.ChatServerHandler;
import com.quyuanjin.imsevennetty.myinterface.My;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.B")//监听的队列名称 TestDirectQueue
public class DirectReceiver implements My {

    @RabbitHandler
    public void process(Map<String,Object> testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
        doEvent((String)testMessage.get("userId"),(String)testMessage.get("contant"));
    }

    public void doEvent(String userid,String contant) {
        ChatServerHandler.pp.doSomeThing(this, userid,contant);


    }

    @Override
    public void say() {
        System.out.println("say 了");
    }
}
