package com.quyuanjin.imsevensave.pojo.friendcircle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserMoment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String userId;
    private String contentUUidList;
    private String time;

    public UserMoment() {
    }

    public UserMoment(String userId,  String contentUUidList,  String time) {
        this.userId = userId;

        this.contentUUidList = contentUUidList;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContentUUidList() {
        return contentUUidList;
    }

    public void setContentUUidList(String contentUUidList) {
        this.contentUUidList = contentUUidList;
    }




    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
