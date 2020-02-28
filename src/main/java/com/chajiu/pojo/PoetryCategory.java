package com.chajiu.pojo;

public class PoetryCategory {

    private Integer id;
    private Integer pid;
    private Integer cid;

    public PoetryCategory() {
        id=-1;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "PoetryCategory{" +
                "id=" + id +
                ", pid=" + pid +
                ", cid=" + cid +
                '}';
    }
}
