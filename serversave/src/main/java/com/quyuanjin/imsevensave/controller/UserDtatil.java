package com.quyuanjin.imsevensave.controller;

import com.google.gson.Gson;
import com.quyuanjin.imsevensave.pojo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.quyuanjin.imsevensave.session.HibernateUtil.getSession;

@RestController

public class UserDtatil {

    @RequestMapping(value = "PullUserDetail", produces = "application/json; charset=UTF-8")
    public String PullUserDetail(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        System.out.println("开始打印phone" + phone);

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User rct where rct.phone=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, phone);
        List<User> userList = q.getResultList();
        tx.commit();
        session.close();
        //  System.out.println(user.getPhone());
        if (userList.size() == 0) {
            return "0";
        } else {
            Gson gson2 = new Gson();
            String str = gson2.toJson(userList);
            return str;
        }

    }

    @RequestMapping(value = "PullUserDetailByOne", produces = "application/json; charset=UTF-8")
    public User PullUserDetailByOne(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        User user;
        if (name.equals("00")) {//来自二维码扫描结果，此时的phone里面的值其实是user的uuid
            Session session = getSession();
            Transaction tx = session.beginTransaction();
            String hql = "from User rct where rct.user=?1 ";
            Query q = session.createQuery(hql);
            q.setParameter(1, phone);

            user = (User) q.uniqueResult();
        } else {
            Session session = getSession();
            Transaction tx = session.beginTransaction();
            String hql = "from User rct where rct.phone=?1 and  rct.name=?2";
            Query q = session.createQuery(hql);
            q.setParameter(1, phone);
            q.setParameter(2, name);

            user = (User) q.uniqueResult();
            tx.commit();
            session.close();
            //  System.out.println(user.getPhone());

        }
        return user;

    }

}
