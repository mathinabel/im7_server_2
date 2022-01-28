package com.quyuanjin.imsevensave.controller.friendcircle;

import com.google.gson.Gson;
import com.quyuanjin.imsevensave.controller.friendcircle.friendcirclebeans.*;
import com.quyuanjin.imsevensave.pojo.User;
import com.quyuanjin.imsevensave.pojo.friendcircle.Comment;
import com.quyuanjin.imsevensave.pojo.friendcircle.FriendCircleDetail;
import com.quyuanjin.imsevensave.pojo.friendcircle.Praise;
import com.quyuanjin.imsevensave.pojo.friendcircle.UserMoment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static com.quyuanjin.imsevensave.session.HibernateUtil.getSession;

@RestController

public class GetFriendCircleBeans {
    @RequestMapping(value = "getFriendCircleBeans", produces = "application/json; charset=UTF-8")
    public String getFriendCircleBeans(HttpServletRequest request) {
        String userid = request.getParameter("userid");

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        //查询uid所对应的fuuids
        String hql = "from UserMoment u where u.userId=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, userid);
        UserMoment usermonent = (UserMoment) q.uniqueResult();

        String[] fuuids = usermonent.getContentUUidList().split("\\|");
        List<FriendCircleBean> fcbs = new ArrayList<>();
        for (int i = 0; i <= fuuids.length-1; i++) {
            FriendCircleBean friendCircleBean = new FriendCircleBean();
            UserBean userBean = new UserBean();
            OtherInfoBean otherInfoBean = new OtherInfoBean();
            List<CommentBean> commentBeanList = new ArrayList<>();
            List<PraiseBean> praiseBeanArrayList = new ArrayList<>();

            //用fuuids进行多表查询 ,后期应改用join等联合查询
            String hql1 = " from FriendCircleDetail  f where f.contentUUid=?1";
            Query q1 = session.createQuery(hql1);
            q1.setParameter(1, fuuids[i]);
            FriendCircleDetail f = (FriendCircleDetail) q1.uniqueResult();

            f.getContentUUid();

            f.getTime();
            friendCircleBean.setContent(f.getContent());
//            friendCircleBean.setViewType(Integer.valueOf(f.getContentViewTpye()));


            String hql2 = " from Comment  c where c.contentUUid=?1";
            Query q2 = session.createQuery(hql2);
            q2.setParameter(1, fuuids[i]);
            List<Comment> cc = q2.list();
            for (int j = 0; j < cc.size(); j++) {
                Comment c = cc.get(j);
                CommentBean commentBean = new CommentBean();

                commentBean.setChildUserId(c.getChildUserI());
                commentBean.setChildUserName(c.getChildUserName());
                commentBean.setCommentContent(c.getCommentContent());
                commentBean.setCommentType(c.getCommentType());
                commentBean.setParentUserId(c.getParentUserId());
                commentBean.setParentUserName(c.getParentUserName());
                commentBeanList.add(commentBean);
            }
            friendCircleBean.setCommentBeans(commentBeanList);

            String hql3 = " from Praise  p where p.contentUUid=?1";
            Query q3 = session.createQuery(hql3);
            q3.setParameter(1, fuuids[i]);
            Praise p = (Praise) q3.uniqueResult();
            if (p != null) {
                String[] praiseUsers = p.getPraiseUserIdList().split("\\|");
                String[] praiseUserNames = p.getPraiseUserNameList().split("\\|");
                for (int k = 0; k < praiseUsers.length; k++) {
                    PraiseBean praiseBean = new PraiseBean();

                    praiseBean.setPraiseUserId(praiseUsers[k]);
                    praiseBean.setPraiseUserName(praiseUserNames[k]);
                    praiseBeanArrayList.add(praiseBean);

                }
                friendCircleBean.setPraiseBeans(praiseBeanArrayList);
            }


            fcbs.add(friendCircleBean);
        }
        tx.commit();
        session.close();
        Gson gson = new Gson();

        return gson.toJson(fcbs);
    }

}
