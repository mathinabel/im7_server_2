package com.quyuanjin.imsevensave.controller;

import com.google.gson.Gson;
import com.quyuanjin.imsevensave.constant.Constant;
import com.quyuanjin.imsevensave.pojo.AllTypeMsg;
import com.quyuanjin.imsevensave.pojo.UnReadAddFriendRequest;
import com.quyuanjin.imsevensave.pojo.User;
import com.quyuanjin.imsevensave.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class AddFriend {
    @RequestMapping(value = "addFriendSave", produces = "application/json; charset=UTF-8")
    public String addFriendSave(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String contant = request.getParameter("contant");

        Gson gson = new Gson();
        AllTypeMsg allTypeMsg = gson.fromJson(contant, AllTypeMsg.class);

        HibernateUtil.add( allTypeMsg.getUnReadAddFriendRequest() );

        return "ok";

    }
}
