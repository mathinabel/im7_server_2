package com.quyuanjin.imsevensave.controller;


import com.google.gson.Gson;
import com.quyuanjin.imsevensave.pojo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import static com.quyuanjin.imsevensave.session.SessionAndCommit.getSession;


@RestController
public class LoginController {

    @RequestMapping(value = "loginsave", produces = "application/json; charset=UTF-8")
    public String loginsave(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String password = request.getParameter("pwd");
        System.out.println("password is:" + password);

        //查询数据库是否有该phone
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User user where user.user=?1";//即user的uuid
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        User user = (User) q.uniqueResult();
        if (user!=null){
            if (user.getPwd().equals(password)) {

                tx.commit();
                session.close();
                Gson gson = new Gson();
                return gson.toJson(user);
            }

        }
        Gson gson = new Gson();
        tx.commit();
        session.close();
        return gson.toJson(new User("","",
                "","","","",
                "","","",""));

    }
}
