package com.quyuanjin.imsevenregister.pojo;



public class UserRelationShip {

    Long id;
    String userId;
    String userFriends;

    public UserRelationShip(String userId, String userFriends) {
        this.userId = userId;
        this.userFriends = userFriends;
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

    public String getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(String userFriends) {
        this.userFriends = userFriends;
    }

    public UserRelationShip() {
    }
}
