package com.example.interviewapp.data;

import java.util.List;

public class CandidateSkill {
    private String generalSkill;
    private String level;
    private List<Skill> knownSkills;
    private List<Skill> unknownSkills;

    public CandidateSkill(String generalSkill, String level, List<Skill> knownSkills, List<Skill> unknownSkills) {
        this.generalSkill = generalSkill;
        this.level = level;
        this.knownSkills = knownSkills;
        this.unknownSkills = unknownSkills;
    }

    public String getGeneralSkill() {
        return generalSkill;
    }

    public void setGeneralSkill(String generalSkill) {
        this.generalSkill = generalSkill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Skill> getKnownSkills() {
        return knownSkills;
    }

    public void setKnownSkills(List<Skill> knownSkills) {
        this.knownSkills = knownSkills;
    }

    public List<Skill> getUnknownSkills() {
        return unknownSkills;
    }

    public void setUnknownSkills(List<Skill> unknownSkills) {
        this.unknownSkills = unknownSkills;
    }
}
