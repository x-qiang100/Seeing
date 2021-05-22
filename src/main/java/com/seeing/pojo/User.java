package com.seeing.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private Integer id;

    private String name;

    private String phone;

    @JsonIgnore
    private String password;

    private Integer type;

    private String email;

    private String picture;

    private Integer gender;

    private String msg;

    private String address;

    private Integer number;

    public User(Integer id, String name, String phone, String password, Integer type, String email, String picture, Integer gender, String msg, String address, Integer number) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.email = email;
        this.picture = picture;
        this.gender = gender;
        this.msg = msg;
        this.address = address;
        this.number = number;
    }

    public User() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}