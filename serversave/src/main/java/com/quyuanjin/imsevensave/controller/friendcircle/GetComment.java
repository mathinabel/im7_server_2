package com.quyuanjin.imsevensave.controller.friendcircle;

import com.quyuanjin.imsevensave.pojo.friendcircle.Comment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.quyuanjin.imsevensave.session.HibernateUtil.getSession;

@RestController
public class GetComment {
    @RequestMapping(value = "getCommentlB", produces = "application/json; charset=UTF-8")
    public Comment getCommentlByFUUID(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Comment cmt where cmt.contentUUid=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        Comment usermonent = (Comment) q.uniqueResult();
        tx.commit();
        session.close();
        return usermonent;
    }
    @RequestMapping(value = "getComlByFUUIDs", produces = "application/json; charset=UTF-8")
    public Comment getCommentlByFUUIDs(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from UserMoment ust where ust.userId=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        Comment usermonent = (Comment) q.uniqueResult();
        tx.commit();
        session.close();
        return usermonent;
    }
}
