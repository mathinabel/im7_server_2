package com.quyuanjin.imsevensave.controller.friendcircle;

import com.quyuanjin.imsevensave.pojo.friendcircle.Praise;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.quyuanjin.imsevensave.session.HibernateUtil.getSession;

@RestController
public class GetPraise {
    @RequestMapping(value = "gemmyFUUID", produces = "application/json; charset=UTF-8")
    public Praise getPriselByFUUID(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String fuuids = request.getParameter("fuuids");

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Praise ust where ust.contentUUid=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, fuuids);
        Praise usermonent = (Praise) q.uniqueResult();
        tx.commit();
        session.close();
        return usermonent ;
    }
    @RequestMapping(value = "getCommByFUUIDs", produces = "application/json; charset=UTF-8")
    public Praise getPriselByFUUIDs(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Praise ust where ust.contentUUid=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        Praise usermonent = (Praise) q.uniqueResult();
        tx.commit();
        session.close();
        return usermonent;
    }
}
