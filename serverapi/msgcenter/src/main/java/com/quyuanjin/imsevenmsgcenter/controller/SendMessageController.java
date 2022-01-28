package com.quyuanjin.imsevenmsgcenter.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @Autowired
    private RestTemplate restTemplate;

    //chat的各种消息类型都从这里走
    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String contant = request.getParameter("contant");
        System.out.println(userid);
        System.out.println(contant);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userid);
        map.put("contant", contant);


//发mysql
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userid", userid);
        params.add("contant", contant);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        String str = restTemplate.postForObject("http://im-sql-save/msgSave", request2
                , String.class);
        System.out.println(str);

        //发netty
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        return "ok";
    }
}
