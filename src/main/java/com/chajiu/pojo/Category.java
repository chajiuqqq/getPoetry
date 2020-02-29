package com.chajiu.pojo;

import java.util.List;

public class Category {
    private Integer id;
    private String name;

    private List<Poetry> poetries;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Poetry> getPoetries() {
        return poetries;
    }

    public void setPoetries(List<Poetry> poetries) {
        this.poetries = poetries;
    }

    public Category toSimple(){
        for(Poetry poetry:poetries){
            poetry.toSimpleInstance();
        }
        return this;
    }
}
