package com.quyuanjin.imsevenregister;


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
import java.util.UUID;

import static com.quyuanjin.imsevenregister.utils.RandomName.randomName;


@RestController
public class RegisterController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "register", produces = "application/json; charset=UTF-8")
    public String register(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();
        String chineseName = randomName(false, 3);


        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userid",uuid);
        params.add("name",chineseName);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        String str = restTemplate.postForObject("http://im-sql-save/register",request2
                ,String.class);
        System.out.println(str);
        return str;

    }
}
