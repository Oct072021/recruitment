package com.bean;

import java.io.Serializable;

public class CV implements Serializable {

    private String CVPath;
    private String CVName;
    private int user_id;
    private int com_id;

    public CV(){}

    public CV(String CVName) {
        this.CVName=CVName;
    }

    @Override
    public String toString() {
        return "{" +
                "CVPath:'" + CVPath + '\'' +
                ", user_id:" + user_id +
                ", com_id:" + com_id +
                ", CVName:'" + CVName + '\'' +
                '}';
    }

    public String getCVPath() {
        return CVPath;
    }

    public void setCVPath(String CVPath) {
        this.CVPath = CVPath;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCVName() {
        return CVName;
    }

    public void setCVName(String CVName) {
        this.CVName = CVName;
    }
}

