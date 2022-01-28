package com.quyuanjin.imsevensave.controller.friendcircle;

import com.quyuanjin.imsevensave.pojo.friendcircle.FriendCircleDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.quyuanjin.imsevensave.session.HibernateUtil.getSession;

@RestController
public class GetFriendCircleDetail {
    @RequestMapping(value = "getFirendetailByFUUID", produces = "application/json; charset=UTF-8")
    public FriendCircleDetail getFirendCircleDetailByFUUID(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String fuuid = request.getParameter("fuuid");

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from FriendCircleDetail fcd where fcd.contentUUid=?1";

        Query q = session.createQuery(hql);
        q.setParameter(1, fuuid);
        FriendCircleDetail usermonentdetail = (FriendCircleDetail) q.uniqueResult();
        tx.commit();
        session.close();
        return usermonentdetail;
    }

    @RequestMapping(value = "getFircleDetailByFUUIDs", produces = "application/json; charset=UTF-8")
    public List getFirendCircleDetailByFUUIDs(HttpServletRequest request) {

        String userid = request.getParameter("userid");
        String fuuids = request.getParameter("fuuids");

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from FriendCircleDetail fcd where fcd.contentUUid=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, fuuids);
        List usermonentdetailList =  q.getResultList();
        tx.commit();
        session.close();
        return usermonentdetailList;
    }
}
