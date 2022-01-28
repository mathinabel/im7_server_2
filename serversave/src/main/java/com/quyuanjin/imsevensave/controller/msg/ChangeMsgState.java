package com.quyuanjin.imsevensave.controller.msg;

import com.google.gson.Gson;
import com.quyuanjin.imsevensave.constant.Constant;
import com.quyuanjin.imsevensave.pojo.AllTypeMsg;
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

public class ChangeMsgState {

    @RequestMapping(value = "changeMsgState", produces = "application/json; charset=UTF-8")
    public String changeMsgState(HttpServletRequest request) {
        String msguuid = request.getParameter("msguuid");

        //查询数据库是否有该uuid
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Msg  m where m.msgUUID=?1";//即user的uuid
        Query q = session.createQuery(hql);
        q.setParameter(1, msguuid);
        Msg msg = (Msg) q.uniqueResult();
        tx.commit();
        session.close();
        if (msg != null) {
            msg.setSendState(Constant.already_send);
            HibernateUtil.update(msg);

        }



        return "ok";

    }
}
