package com.quyuanjin.imsevenaddfriend.controller;

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

@RestController

public class PullUserDetail {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "PullUserDetail", produces = "application/json; charset=UTF-8")
    public String PullUserDetail(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String contant = request.getParameter("contant");
        String phone = request.getParameter("phone");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userid",userid);
        params.add("contant",contant);
        params.add("phone",phone);

//发mysql
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        String str = restTemplate.postForObject("http://im-sql-save/PullUserDetail",request2
                ,String.class);
        System.out.println(str);
        return  str;
    }
}
