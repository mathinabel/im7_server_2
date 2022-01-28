package com.quyuanjin.imsevensave.pojo.friendcircle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Praise {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    private String contentUUid;
    private String praiseUserNameList;
    private String praiseUserIdList;

    public Praise() {
    }

    public Praise(String contentUUid, String praiseUserNameList, String praiseUserIdList) {
        this.contentUUid = contentUUid;
        this.praiseUserNameList = praiseUserNameList;
        this.praiseUserIdList = praiseUserIdList;
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

    public String getPraiseUserNameList() {
        return praiseUserNameList;
    }

    public void setPraiseUserNameList(String praiseUserNameList) {
        this.praiseUserNameList = praiseUserNameList;
    }

    public String getPraiseUserIdList() {
        return praiseUserIdList;
    }

    public void setPraiseUserIdList(String praiseUserIdList) {
        this.praiseUserIdList = praiseUserIdList;
    }
}
