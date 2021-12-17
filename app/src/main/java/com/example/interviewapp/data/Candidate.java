package com.example.interviewapp.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.interviewapp.utils.Constants;

@Entity
public class Candidate {
    @PrimaryKey(autoGenerate = true)
    private final int id;
    @ColumnInfo(name = Constants.COLUMN_CANDIDATE_NAME)
    private final String name;
    @ColumnInfo(name = Constants.COLUMN_CANDIDATE_SKILL)
    private final String candidateSkills;

    public Candidate(int id, String name, String candidateSkills) {
        this.id = id;
        this.name = name;
        this.candidateSkills = candidateSkills;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCandidateSkills() {
        return candidateSkills;
    }
}
