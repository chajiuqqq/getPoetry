package com.chajiu.pojo;


import com.chajiu.util.LangConverter;

public class Poetry {

    private Integer id;

    private Integer authorId;

    private String title;
    private String content;
    private String author;

    private String yunlvRule;

    private String dynasty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYunlvRule() {
        return yunlvRule;
    }

    public void setYunlvRule(String yunlvRule) {
        this.yunlvRule = yunlvRule;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    @Override
    public String toString() {
        return "Poetry{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", yunlvRule='" + yunlvRule + '\'' +
                ", dynasty='" + dynasty + '\'' +
                '}';
    }

    public Poetry toSimpleInstance(){
        title= LangConverter.toSimple(title);
        content=LangConverter.toSimple(content);
        return this;
    }


}
