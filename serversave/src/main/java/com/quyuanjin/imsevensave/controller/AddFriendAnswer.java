package com.quyuanjin.imsevensave.controller;

import com.google.gson.Gson;
import com.quyuanjin.imsevensave.pojo.AllTypeMsg;
import com.quyuanjin.imsevensave.session.HibernateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddFriendAnswer {
    @RequestMapping(value = "addFriendAnswerSave", produces = "application/json; charset=UTF-8")
    public String addFriendAnswerSave(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String contant = request.getParameter("contant");

        Gson gson = new Gson();
        AllTypeMsg allTypeMsg = gson.fromJson(contant, AllTypeMsg.class);

        HibernateUtil.update(allTypeMsg.getUnReadAddFriendRequest() );

        return "ok";

    }
}
