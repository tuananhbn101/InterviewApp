package com.example.interviewapp.api;

import android.os.AsyncTask;

import com.example.interviewapp.data.GroupSkills;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SkillApi extends AsyncTask<String, Void, List<GroupSkills>> {


    @Override
    protected List<GroupSkills> doInBackground(String... strings) {
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<GroupSkills>>() { }.getType();
        List<GroupSkills> groupSkills = gson.fromJson(strings[0], listUserType);
        return groupSkills;
    }
}
