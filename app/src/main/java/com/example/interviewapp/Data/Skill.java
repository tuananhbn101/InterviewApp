package com.example.interviewapp.Data;

public class Skill {
    private int id;
    private String type;
    private String junior;
    private String middle;
    private String senior;

    public Skill(int id, String type, String junior, String middle, String senior) {
        this.id = id;
        this.type = type;
        this.junior = junior;
        this.middle = middle;
        this.senior = senior;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJunior() {
        return junior;
    }

    public void setJunior(String junior) {
        this.junior = junior;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }
}
