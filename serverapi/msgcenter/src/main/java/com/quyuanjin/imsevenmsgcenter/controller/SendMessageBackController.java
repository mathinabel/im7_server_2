package com.quyuanjin.imsevenmsgcenter.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController

public class SendMessageBackController {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("/sendMessageBack")
    public String sendMessageBack(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String contant = request.getParameter("contant");
        String msguuid = request.getParameter("msguuid");

        Map<String, Object> map = new HashMap<>();
        map.put("msguuid",msguuid);
        map.put("userId",userid);
        map.put("contant",contant);

        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        return "ok";
    }
}
