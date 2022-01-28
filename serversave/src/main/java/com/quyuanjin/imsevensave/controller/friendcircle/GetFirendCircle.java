package com.quyuanjin.imsevensave.controller.friendcircle;

import com.quyuanjin.imsevensave.pojo.User;
import com.quyuanjin.imsevensave.pojo.friendcircle.UserMoment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.quyuanjin.imsevensave.session.HibernateUtil.getSession;

@RestController
public class GetFirendCircle {
    @RequestMapping(value = "getFriendCircle", produces = "application/json; charset=UTF-8")
    public String getFirendCircle(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from UserMoment ust where ust.userId=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        UserMoment usermonent = (UserMoment) q.uniqueResult();
        tx.commit();
        session.close();
        return usermonent.getContentUUidList();
    }
}
