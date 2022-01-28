package com.quyuanjin.imsevensave.controller.friendcircle.friendcirclebeans;




public class CommentBean {

    private int commentType;

    private String parentUserName;

    private String childUserName;

    private int parentUserId;

    private int childUserId;

    private String commentContent;

    public CommentBean(int commentType, String parentUserName, String childUserName, int parentUserId, int childUserId, String commentContent) {
        this.commentType = commentType;
        this.parentUserName = parentUserName;
        this.childUserName = childUserName;
        this.parentUserId = parentUserId;
        this.childUserId = childUserId;
        this.commentContent = commentContent;
    }

    public CommentBean() {
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public String getParentUserName() {
        return parentUserName;
    }

    public void setParentUserName(String parentUserName) {
        this.parentUserName = parentUserName;
    }

    public String getChildUserName() {
        return childUserName;
    }

    public void setChildUserName(String childUserName) {
        this.childUserName = childUserName;
    }

    public int getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(int parentUserId) {
        this.parentUserId = parentUserId;
    }

    public int getChildUserId() {
        return childUserId;
    }

    public void setChildUserId(int childUserId) {
        this.childUserId = childUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
