package com.jsu.zjx.dao;

import com.jsu.zjx.bean.Singer;
import com.jsu.zjx.utils.DBUtils;

import java.util.List;

public class SingerDao {
    public List getAllSinger(){
        String sql="SELECT * FROM singer";
        return DBUtils.getList(Singer.class,sql);
    }
}
