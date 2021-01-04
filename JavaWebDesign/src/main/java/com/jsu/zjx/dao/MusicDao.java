package com.jsu.zjx.dao;

import com.jsu.zjx.bean.Music;
import com.jsu.zjx.utils.DBUtils;

import java.util.List;

public class MusicDao {
    public boolean insertMusic(Music music) {
        String sql="INSERT INTO music(name,url,type,singerName,visitorCount,downloadCount,price) VALUES (?,?,?,?,?,?,?)";
        return DBUtils.save(sql,music.getName(),music.getUrl(),music.getType(),music.getSingerName(),music.getVisitorCount(),music.getDownloadCount(),music.getPrice());
    }

    public List getAllMusic(){
        String sql="SELECT * FROM music";
        return DBUtils.getList(Music.class,sql);
    }

    public List getMusicByType(String type){
        String sql="SELECT * FROM music WHERE type=? ORDER BY downloadCount DESC";
        return  DBUtils.getList(Music.class,sql,type);
    }

    public Music getMusicById(int id){
        String sql="SELECT * FROM music WHERE id=?";
        return DBUtils.getSingleObject(Music.class,sql,id);
    }

    public boolean removeMusic(int id) {
        String sql="DELETE FROM music WHERE id=?";
        return DBUtils.update(sql,id);
    }

    public List<Music> getMusicByName(String name) {
        String sql="SELECT * FROM music WHERE name LIKE ?";
        return DBUtils.getList(Music.class,sql,"%"+name+"%");
    }

    public boolean updateMusic(Music music) {
        String sql="UPDATE music SET url=?,type=?,singerName=?,price=? WHERE id=?";
        return DBUtils.update(sql,music.getUrl(),music.getType(),music.getSingerName(),music.getPrice(),music.getId());
    }
}
