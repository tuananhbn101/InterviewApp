package com.example.interviewapp.data;

import java.util.List;

public class GeneralSkills {
    private int id;
    private String type;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private String level;
  private List<Skill> skillList;
    public GeneralSkills(int id, String type, String level, List<Skill> skillList) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.skillList = skillList;
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

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
}
