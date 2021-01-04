package com.jsu.zjx.bean;

import java.util.Date;

public class Singer {
    private int id;
    private String name;
    private char sex;
    private Date birthday;
    private String hobby;
    private int visitorCount;

    public Singer(){

    }

    public Singer(String name, char sex,Date birthday, String hobby, int visitorCount) {
        this.name = name;
        this.sex=sex;
        this.birthday = birthday;
        this.hobby = hobby;
        this.visitorCount = visitorCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }
}
