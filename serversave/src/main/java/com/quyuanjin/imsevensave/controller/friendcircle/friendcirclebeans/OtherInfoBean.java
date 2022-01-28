package com.quyuanjin.imsevensave.controller.friendcircle.friendcirclebeans;

public class OtherInfoBean {

    private String source;

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public OtherInfoBean(String source, String time) {
        this.source = source;
        this.time = time;
    }

    public OtherInfoBean() {
    }
}
