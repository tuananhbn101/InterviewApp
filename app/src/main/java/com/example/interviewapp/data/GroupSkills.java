package com.example.interviewapp.data;

public class GroupSkills {
    private final int id;
    private final String type;
    private final String junior;
    private final String middle;
    private final String senior;

    public GroupSkills(int id, String type, String junior, String middle, String senior) {
        this.id = id;
        this.type = type;
        this.junior = junior;
        this.middle = middle;
        this.senior = senior;
    }

    public String getType() {
        return type;
    }


    public String getJunior() {
        return junior;
    }


    public String getMiddle() {
        return middle;
    }


    public String getSenior() {
        return senior;
    }

    public int getId() {
        return id;
    }
}
