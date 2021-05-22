package com.seeing.pojo;

import java.util.Date;

public class Record {
    private Integer id;

    private Integer volunteer;

    private Integer blind;

    private String evaluate;

    private Date time;

    public Record(Integer id, Integer volunteer, Integer blind, String evaluate, Date time) {
        this.id = id;
        this.volunteer = volunteer;
        this.blind = blind;
        this.evaluate = evaluate;
        this.time = time;
    }

    public Record() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Integer volunteer) {
        this.volunteer = volunteer;
    }

    public Integer getBlind() {
        return blind;
    }

    public void setBlind(Integer blind) {
        this.blind = blind;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}