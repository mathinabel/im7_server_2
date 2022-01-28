package com.quyuanjin.imsevensave.controller.setting;

import com.quyuanjin.imsevensave.constant.Constant;
import com.quyuanjin.imsevensave.pojo.Msg;
import com.quyuanjin.imsevensave.pojo.User;
import com.quyuanjin.imsevensave.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.quyuanjin.imsevensave.session.SessionAndCommit.getSession;

@RestController

public class SettingDetail {
    @RequestMapping(value = "changePhone", produces = "application/json; charset=UTF-8")
    public String changePhone(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String phone = request.getParameter("phone");

        //查询数据库是否有该uuid
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User  u where u.user=?1";//即user的uuid
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        User user = (User) q.uniqueResult();
        tx.commit();
        session.close();
        if (user != null) {
             user.setPhone(phone);
            HibernateUtil.update(user);

        }



        return "ok";

    }

    @RequestMapping(value = "changePwd", produces = "application/json; charset=UTF-8")
    public String changePwd(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");

        //查询数据库是否有该uuid
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User  u where u.user=?1";//即user的uuid
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        User user = (User) q.uniqueResult();
        tx.commit();
        session.close();
        if (user != null) {
            user.setPwd(pwd);
            HibernateUtil.update(user);

        }



        return "ok";

    }
    @RequestMapping(value = "changePer", produces = "application/json; charset=UTF-8")
    public String changePer(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String per = request.getParameter("per");

        //查询数据库是否有该uuid
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User  u where u.user=?1";//即user的uuid
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        User user = (User) q.uniqueResult();
        tx.commit();
        session.close();
        if (user != null) {
            user.setDescription(per);
            HibernateUtil.update(user);

        }



        return "ok";

    }
    @RequestMapping(value = "changeNickName", produces = "application/json; charset=UTF-8")
    public String changeNickName(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String nickname = request.getParameter("nickname");

        //查询数据库是否有该uuid
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User  u where u.user=?1";//即user的uuid
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        User user = (User) q.uniqueResult();
        tx.commit();
        session.close();
        if (user != null) {
            user.setName(nickname);
            HibernateUtil.update(user);

        }



        return "ok";

    }
    @RequestMapping(value = "changePortrait", produces = "application/json; charset=UTF-8")
    public String changePortrait(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String portrait = request.getParameter("portrait");

        //查询数据库是否有该uuid
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User  u where u.user=?1";//即user的uuid
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        User user = (User) q.uniqueResult();
        tx.commit();
        session.close();
        if (user != null) {
            user.setPortrait(portrait);
            HibernateUtil.update(user);

        }



        return "ok";

    }

}
