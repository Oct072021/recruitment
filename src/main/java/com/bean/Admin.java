package com.bean;

import java.io.Serializable;

public class Admin implements Serializable {

    private int ad_id;
    private String ad_username;
    private String ad_password;

    public String getAd_username() {
        return ad_username;
    }

    public void setAd_username(String ad_username) {
        this.ad_username = ad_username;
    }

    public String getAd_password() {
        return ad_password;
    }

    public void setAd_password(String ad_password) {
        this.ad_password = ad_password;
    }

    @Override
    public String toString() {
        return "{" +
                "ad_id:" + ad_id +
                ", ad_username:'" + ad_username + '\'' +
                ", ad_password:'" + ad_password + '\'' +
                '}';
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }
}
