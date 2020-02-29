package com.chajiu.pojo;

public class User {
    //唯一
    private Integer id;
    //唯一
    //可修改
    private String name;
    //唯一
    private String username;
    //可修改
    private String password;
    //可修改
    private String email;

    public User id(Integer id){
        this.id=id;
        return this;
    }
    public User name(String name){
        this.name=name;
        return this;
    }
    public User username(String username){
        this.username=username;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
