package com.chajiu.pojo;

import com.chajiu.util.LangConverter;

import java.util.List;

public class PoetryAuthor {
    private Integer id;
    private String name;
    private String intro;
    private String dynasty;
    private Integer record;

    private List<Poetry> poetries;

    @Override
    public String toString() {
        return "PoetryAuthor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", record=" + record +
                '}';
    }

    public Integer getRecord() {
        return record;
    }

    public void setRecord(Integer record) {
        this.record = record;
    }

    public List<Poetry> getPoetries() {
        return poetries;
    }

    public void setPoetries(List<Poetry> poetries) {
        this.poetries = poetries;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public PoetryAuthor toSimpleInstance(){
        name= LangConverter.toSimple(name);
        if(intro!=null)
            intro=LangConverter.toSimple(intro);
        return this;
    }
}
