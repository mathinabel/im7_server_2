package com.quyuanjin.imsevensave.pojo.friendcircle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Comment  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    private String contentUUid;
    private int commentType;
    private String parentUserName;
    private String childUserName;
    private int parentUserId;
    private int childUserI;
    private String commentContent;

    public Comment() {
    }

    public Comment(String contentUUid, int commentType, String parentUserName, String childUserName, int parentUserId, int childUserI, String commentContent) {
        this.contentUUid = contentUUid;
        this.commentType = commentType;
        this.parentUserName = parentUserName;
        this.childUserName = childUserName;
        this.parentUserId = parentUserId;
        this.childUserI = childUserI;
        this.commentContent = commentContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentUUid() {
        return contentUUid;
    }

    public void setContentUUid(String contentUUid) {
        this.contentUUid = contentUUid;
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

    public int getChildUserI() {
        return childUserI;
    }

    public void setChildUserI(int childUserI) {
        this.childUserI = childUserI;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
