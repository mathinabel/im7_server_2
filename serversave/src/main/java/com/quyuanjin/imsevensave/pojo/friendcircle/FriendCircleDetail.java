package com.quyuanjin.imsevensave.pojo.friendcircle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FriendCircleDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    private String contentUUid;
    private String contentViewTpye;
    private String content;
    private String time;

    public FriendCircleDetail() {
    }

    public FriendCircleDetail(String contentUUid, String contentViewTpye, String content, String time) {
        this.contentUUid = contentUUid;
        this.contentViewTpye = contentViewTpye;
        this.content = content;
        this.time = time;
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

    public String getContentViewTpye() {
        return contentViewTpye;
    }

    public void setContentViewTpye(String contentViewTpye) {
        this.contentViewTpye = contentViewTpye;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
