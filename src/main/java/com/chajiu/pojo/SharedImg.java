package com.chajiu.pojo;


import java.util.Date;

public class SharedImg {
    private Integer id;
    private Integer pid;
    private String picLoc;
    private String fileName;
    private Date date;

    public SharedImg(Integer pid, String fileName, Date date) {
        this.pid = pid;
        this.fileName = fileName;
        this.date = date;
    }

    public SharedImg(Integer pid, String fileName) {
        this(pid,fileName,new Date());
    }

    public SharedImg() {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }


    public String getPicLoc() {
        return picLoc;
    }

    public void setPicLoc(String picLoc) {
        this.picLoc = picLoc;
    }
}
