package com.example.interviewapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Candidate.class},version = CandidateDataBase.DATABASE_VERSION)
public abstract class CandidateDataBase extends RoomDatabase {
    public static final int DATABASE_VERSION = 1;
    private static CandidateDataBase candidateDatabase;
    public static final String DATABASE_NAME = "Candidate_database";
    public abstract CandidateDao candidateDao();
    public static CandidateDataBase getInstance(Context context){
        if(candidateDatabase == null){
            candidateDatabase = Room.databaseBuilder(context, CandidateDataBase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return candidateDatabase;
    }
}
