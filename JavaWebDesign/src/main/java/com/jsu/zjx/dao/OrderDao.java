package com.jsu.zjx.dao;

import com.jsu.zjx.bean.Order;
import com.jsu.zjx.utils.DBUtils;

import java.util.List;

public class OrderDao {
    public List getAllOrder(){
        String sql="SELECT * FROM orderform";
        return DBUtils.getList(Order.class,sql);
    }
}
