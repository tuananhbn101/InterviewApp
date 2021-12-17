package com.example.interviewapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CandidateDao {
    @Query("SELECT * FROM Candidate")
    List<Candidate> getAllCandidate();
    @Insert
    void insertCandidate(Candidate... candidates);

    @Delete
    void deleteCandidate(Candidate candidate);

}
