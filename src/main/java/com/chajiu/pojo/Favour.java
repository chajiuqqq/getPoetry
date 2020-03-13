package com.chajiu.pojo;

import java.util.Date;

public class Favour {
    private Integer id;
    private Integer userId;
    private Integer poetryId;
    private Date createDate;
    private Poetry poetry;


    @Override
    public String toString() {
        return "Favour{" +
                "id=" + id +
                ", userId=" + userId +
                ", poetryId=" + poetryId +
                ", createDate=" + createDate +
                '}';
    }

    public Poetry getPoetry() {
        return poetry;
    }

    public void setPoetry(Poetry poetry) {
        this.poetry = poetry;
        setPoetryId(poetry.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(Integer poetryId) {
        this.poetryId = poetryId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
