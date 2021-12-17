package com.example.interviewapp.data;

public class Skill {
    private  String skill;
    private  Boolean isCheck;

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public void setType(String type) {
        this.type = type;
    }

    private  String type;

    public Skill(String skill, Boolean isCheck, String type) {
        this.skill = skill;
        this.isCheck = isCheck;
        this.type = type;
    }

    public String getSkill() {
        return skill;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public String getType() {
        return type;
    }
}
