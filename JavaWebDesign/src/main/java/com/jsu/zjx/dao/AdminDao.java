package com.jsu.zjx.dao;

import com.jsu.zjx.bean.Admin;
import com.jsu.zjx.utils.DBUtils;

public class AdminDao {
    public Admin getAdminByAccountAndPassword(String account,String password){
        String sql="SELECT * FROM admin WHERE account=? AND password=?";
        return DBUtils.getSingleObject(Admin.class,sql,account,password);
    }
}
