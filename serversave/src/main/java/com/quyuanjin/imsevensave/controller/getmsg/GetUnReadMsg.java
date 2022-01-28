package com.quyuanjin.imsevensave.controller.getmsg;

import com.google.gson.Gson;
import com.quyuanjin.imsevensave.constant.Constant;
import com.quyuanjin.imsevensave.pojo.Msg;
import com.quyuanjin.imsevensave.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.quyuanjin.imsevensave.session.SessionAndCommit.getSession;
@RestController

public class GetUnReadMsg {

    @RequestMapping(value = "getUnReadMsg", produces = "application/json; charset=UTF-8")
    public String getUnReadMsg(HttpServletRequest request) {
        String  uuid = request.getParameter("userid");


        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Msg  m where m.receiveId=?1 and m.sendState=?2";
        Query q = session.createQuery(hql);
        q.setParameter(1, uuid);
        q.setParameter(2, Constant.un_send);

        List<Msg> msgList =   q.getResultList();
        tx.commit();
        session.close();
        System.out.println(".................................."+msgList.size()+".."+uuid);
        if (msgList.size()>0){
            Gson gson =new Gson();
            String s=gson.toJson(msgList);
           for(Msg msg:msgList) {
                msg.setSendState(Constant.already_send);
                HibernateUtil.update(msg);
            }
            return s;
        }else {
            return "01";
        }







    }
}
