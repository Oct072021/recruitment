package com.bean;

import java.io.Serializable;

public class Enterprise implements Serializable {

    private int en_id;
    private String en_username;
    private String en_password;

    @Override
    public String toString() {
        return "{" +
                "en_id:" + en_id +
                ", en_username:'" + en_username + '\'' +
                ", en_password:'" + en_password + '\'' +
                '}';
    }

    public int getEn_id() {
        return en_id;
    }

    public void setEn_id(int en_id) {
        this.en_id = en_id;
    }

    public String getEn_username() {
        return en_username;
    }

    public void setEn_username(String en_username) {
        this.en_username = en_username;
    }

    public String getEn_password() {
        return en_password;
    }

    public void setEn_password(String en_password) {
        this.en_password = en_password;
    }
}
