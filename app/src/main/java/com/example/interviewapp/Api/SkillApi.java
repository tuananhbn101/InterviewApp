package com.example.interviewapp.Api;

import android.os.AsyncTask;

import com.example.interviewapp.Data.Skill;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SkillApi extends AsyncTask<String,Void, List<Skill>> {

    @Override
    protected List<Skill> doInBackground(String... strings) {
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<Skill>>() { }.getType();
        List<Skill> skillList = gson.fromJson(strings[0], listUserType);
        return skillList;
    }
}
