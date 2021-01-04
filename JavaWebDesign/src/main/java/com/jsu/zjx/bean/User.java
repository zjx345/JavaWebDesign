package com.jsu.zjx.bean;

public class User {
    private int id;
    private String account;
    private String password;
    private String name;
    private String phoneNumber;

    public User(){

    }

    public User(String account, String password, String name, String phoneNumber) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public User(int id, String account, String password, String name, String phoneNumber) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
