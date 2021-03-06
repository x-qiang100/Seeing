package com.seeing.pojo;

public class theMap {
    private Integer id;

    private Double longitude;

    private Double latitude;

    private Integer userid;

    private String message;

    public theMap(Integer id, Double longitude, Double latitude, Integer userid, String message) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.userid = userid;
        this.message = message;
    }
    public theMap( Double longitude, Double latitude, Integer userid, String message) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.userid = userid;
        this.message = message;
    }

    public theMap() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}