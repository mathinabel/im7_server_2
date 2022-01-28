package com.quyuanjin.imsevensave.controller;


import com.google.gson.Gson;
import com.quyuanjin.imsevensave.pojo.User;
import com.quyuanjin.imsevensave.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.Timer;

import static com.quyuanjin.imsevensave.session.SessionAndCommit.getSession;


@RestController
public class RegisterController {

    @RequestMapping(value = "register", produces = "application/json; charset=UTF-8")
    public String register(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String chineseName = request.getParameter("name");
        System.out.println("chineseName is:" + chineseName);

        User user = new User();
        user.setName(chineseName);
        user.setUser(userid);
        user.setCreateAt(new Timer().toString());
        //getSessionAndCommit(user);
        boolean is = HibernateUtil.add(user);
        Gson gson = new Gson();
        if (is) {

            return gson.toJson(user);

        }
        return gson.toJson(new User());
    }
}
