package com.seeing.pojo;

public class Contact {
    private Integer id;

    private Integer user;

    private String name;

    private String phone;

    private String relation;

    public Contact(Integer id, Integer user, String name, String phone, String relation) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.relation = relation;
    }

    public Contact() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}