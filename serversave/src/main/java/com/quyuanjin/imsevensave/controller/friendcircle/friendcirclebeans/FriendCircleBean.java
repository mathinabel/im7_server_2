package com.quyuanjin.imsevensave.controller.friendcircle.friendcirclebeans;


import java.util.List;


public class FriendCircleBean {

    private int viewType;

    private String content;

    private List<CommentBean> commentBeans;

    private List<PraiseBean> praiseBeans;

    private List<String> imageUrls;

    private UserBean userBean;

    private OtherInfoBean otherInfoBean;

    private boolean isShowPraise;

    private boolean isExpanded;

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    private boolean isShowComment;

    private boolean isShowCheckAll;


    public FriendCircleBean(int viewType, String content, List<CommentBean> commentBeans, List<PraiseBean> praiseBeans, List<String> imageUrls, UserBean userBean, OtherInfoBean otherInfoBean, boolean isShowPraise, boolean isExpanded, boolean isShowComment, boolean isShowCheckAll) {
        this.viewType = viewType;
        this.content = content;
        this.commentBeans = commentBeans;
        this.praiseBeans = praiseBeans;
        this.imageUrls = imageUrls;
        this.userBean = userBean;
        this.otherInfoBean = otherInfoBean;
        this.isShowPraise = isShowPraise;
        this.isExpanded = isExpanded;
        this.isShowComment = isShowComment;
        this.isShowCheckAll = isShowCheckAll;
    }

    public FriendCircleBean() {
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentBean> getCommentBeans() {
        return commentBeans;
    }

    public void setCommentBeans(List<CommentBean> commentBeans) {
        this.commentBeans = commentBeans;
    }

    public List<PraiseBean> getPraiseBeans() {
        return praiseBeans;
    }

    public void setPraiseBeans(List<PraiseBean> praiseBeans) {
        this.praiseBeans = praiseBeans;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public OtherInfoBean getOtherInfoBean() {
        return otherInfoBean;
    }

    public void setOtherInfoBean(OtherInfoBean otherInfoBean) {
        this.otherInfoBean = otherInfoBean;
    }

    public boolean isShowPraise() {
        return isShowPraise;
    }

    public void setShowPraise(boolean showPraise) {
        isShowPraise = showPraise;
    }

    public boolean isShowComment() {
        return isShowComment;
    }

    public void setShowComment(boolean showComment) {
        isShowComment = showComment;
    }

    public boolean isShowCheckAll() {
        return isShowCheckAll;
    }

    public void setShowCheckAll(boolean showCheckAll) {
        isShowCheckAll = showCheckAll;
    }
}
