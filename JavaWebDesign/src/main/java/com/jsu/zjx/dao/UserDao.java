package com.jsu.zjx.dao;

import com.jsu.zjx.bean.Music;
import com.jsu.zjx.bean.User;
import com.jsu.zjx.utils.DBUtils;

import java.util.List;

public class UserDao {
    public User getUserByAccountAndPassword(String account, String password){
        String sql="SELECT * FROM user WHERE account=? AND password=?";
        return DBUtils.getSingleObject(User.class,sql,account,password);
    }

    public User getUserById(int id){
        String sql="SELECT * FROM user WHERE id=?";
        return DBUtils.getSingleObject(User.class,sql,id);
    }

    public List<User> getUserByAccount(String account){
        String sql="SELECT * FROM user WHERE account=?";
        return DBUtils.getList(User.class,sql,account);
    }

    public Integer getCountByAccount(String account){
        String sql="SELECT count(*) FROM user WHERE account=?";
        return DBUtils.getCount(sql,account);
    }

    public boolean insertUser(User user) {
        String sql="INSERT INTO user(account,password,name,phoneNumber) VALUES (?,?,?,?)";
        return DBUtils.save(sql,user.getAccount(),user.getPassword(),user.getName(),user.getPhoneNumber());
    }

    public boolean removeUser(int id){
        String sql="DELETE FROM user WHERE id=?";
        return DBUtils.update(sql,id);
    }

    public boolean updateUser(User user){
        String sql="UPDATE user SET password=?,name=?,phoneNumber=? WHERE id=?";
        return DBUtils.update(sql,user.getPassword(),user.getName(),user.getPhoneNumber(),user.getId());
    }

    public List getAllUser(){
        String sql="SELECT * FROM user";
        return DBUtils.getList(User.class,sql);
    }
}
