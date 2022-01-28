package com.quyuanjin.imsevensave.pojo;


public class AllTypeMsg {
    private UnReadAddFriendRequest unReadAddFriendRequest;
    private PojoContract pojoContract;
    private String jsonTpye;

    private Msg msg;

    public AllTypeMsg(UnReadAddFriendRequest unReadAddFriendRequest, PojoContract pojoContract, String jsonTpye, Msg msg) {
        this.unReadAddFriendRequest = unReadAddFriendRequest;
        this.pojoContract = pojoContract;
        this.jsonTpye = jsonTpye;
        this.msg = msg;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }

    public UnReadAddFriendRequest getUnReadAddFriendRequest() {
        return unReadAddFriendRequest;
    }

    public void setUnReadAddFriendRequest(UnReadAddFriendRequest unReadAddFriendRequest) {
        this.unReadAddFriendRequest = unReadAddFriendRequest;
    }

    public AllTypeMsg() {
    }

    public PojoContract getPojoContract() {
        return pojoContract;
    }

    public void setPojoContract(PojoContract pojoContract) {
        this.pojoContract = pojoContract;
    }


    public String getJsonTpye() {
        return jsonTpye;
    }

    public void setJsonTpye(String jsonTpye) {
        this.jsonTpye = jsonTpye;
    }
}
