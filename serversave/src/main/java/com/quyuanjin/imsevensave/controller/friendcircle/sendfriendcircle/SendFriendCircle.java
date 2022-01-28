package com.quyuanjin.imsevensave.controller.friendcircle.sendfriendcircle;

import com.quyuanjin.imsevensave.pojo.UserRelationShip;
import com.quyuanjin.imsevensave.pojo.friendcircle.FriendCircleDetail;
import com.quyuanjin.imsevensave.pojo.friendcircle.UserMoment;
import com.quyuanjin.imsevensave.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

import static com.quyuanjin.imsevensave.session.HibernateUtil.getSession;

@RestController

public class SendFriendCircle {
    @RequestMapping(value = "sendFriedCircle", produces = "application/json; charset=UTF-8")
    public String sendFriedCircle(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String content = request.getParameter("content");
        //生成fuuid，存入friendcircledetails，查询好友关系表，对所有的好友包括自己都插入一条fuuid消息
        FriendCircleDetail friendCircleDetail = new FriendCircleDetail();
        String fuuid = UUID.randomUUID().toString();
        friendCircleDetail.setContent(content);
        friendCircleDetail.setContentUUid(fuuid);
        HibernateUtil.add(friendCircleDetail);

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from UserRelationShip urs where urs.userId=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        List<UserRelationShip> ursList = q.getResultList();
        for (UserRelationShip anUrsList : ursList) {
            String hql1 = "from UserMoment usm where usm.userId=?1";
            Query q1 = session.createQuery(hql1);
            q1.setParameter(1, anUrsList.getUserFriends());
            if (q1.uniqueResult() != null) {
                UserMoment userMoment = (UserMoment) q1.uniqueResult();
                userMoment.setContentUUidList(userMoment.getContentUUidList() + "|" + fuuid);
                HibernateUtil.update(userMoment);
            } else {
                UserMoment userMoment = new UserMoment(anUrsList.getUserFriends(), fuuid, "");
                HibernateUtil.add(userMoment);
            }
        }
        //好友表都插入完成后，自己也要添加
        UserMoment userMoment = new UserMoment(userid, fuuid, "");
        HibernateUtil.update(userMoment);
        tx.commit();
        session.close();
        return "ok";
    }
}
