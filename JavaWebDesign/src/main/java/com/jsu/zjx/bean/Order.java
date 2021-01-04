package com.jsu.zjx.bean;

import java.util.Date;

public class Order {
    private int id;
    private int userID;
    private int musicID;
    private String musicName;
    private double price;
    private String payState;
    private Date payTime;

    public Order(){

    }

    public Order(int id, int userID, int musicID, String musicName, double price, String payState, Date payTime) {
        this.id = id;
        this.userID = userID;
        this.musicID = musicID;
        this.musicName = musicName;
        this.price = price;
        this.payState = payState;
        this.payTime = payTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMusicID() {
        return musicID;
    }

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
