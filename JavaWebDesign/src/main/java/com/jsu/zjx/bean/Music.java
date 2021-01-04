package com.jsu.zjx.bean;

public class Music {
    private int id;
    private String name;
    private String url;
    private String type;
    private String singerName;
    private int visitorCount;
    private int downloadCount;
    private double price;

    public Music(){

    }

    public Music(String name, String url, String type, String singerName, int visitorCount, int downloadCount, double price) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.singerName = singerName;
        this.visitorCount = visitorCount;
        this.downloadCount = downloadCount;
        this.price = price;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
