package com.seeing.pojo;

public class labels {
    private Long id;

    private Integer label;

    private String english;

    private String chinese;

    private String classify;

    public labels(Long id, Integer label, String english, String chinese, String classify) {
        this.id = id;
        this.label = label;
        this.english = english;
        this.chinese = chinese;
        this.classify = classify;
    }

    public labels() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english == null ? null : english.trim();
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese == null ? null : chinese.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }
}