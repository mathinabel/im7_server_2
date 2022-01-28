package com.quyuanjin.imsevenlogin;


import com.quyuanjin.imsevenlogin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "login", produces = "application/json; charset=UTF-8")
    public String login(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String password = request.getParameter("pwd");


        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userid",userid);
        params.add("pwd",password);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        String str = restTemplate.postForObject("http://im-sql-save/loginsave",request2
                ,String.class);
        System.out.println(str);
        return str;

    }
}
