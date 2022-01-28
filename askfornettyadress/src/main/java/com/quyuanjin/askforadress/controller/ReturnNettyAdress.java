package com.quyuanjin.askforadress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnNettyAdress {
    @GetMapping("/getNettyAdress")
    public String getNettyAdress() {

        return "127.0.0.1";
    }
}
