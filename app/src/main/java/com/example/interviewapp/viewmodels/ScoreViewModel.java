package com.example.interviewapp.viewmodels;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.interviewapp.api.SkillApi;
import com.example.interviewapp.data.Candidate;
import com.example.interviewapp.data.CandidateDataBase;
import com.example.interviewapp.data.CandidateSkill;
import com.example.interviewapp.data.GeneralSkills;
import com.example.interviewapp.data.GroupSkills;
import com.example.interviewapp.data.Skill;
import com.example.interviewapp.utils.Constants;
import com.example.interviewapp.utils.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ScoreViewModel extends AndroidViewModel {
    private MutableLiveData<List<GeneralSkills>> mGeneraListMutableLiveData;
    private List<GeneralSkills> mGeneralSkillsList;

    public ScoreViewModel(@NonNull Application application) {
        super(application);
        if (mGeneraListMutableLiveData == null) {
            mGeneraListMutableLiveData = new MutableLiveData<>();
            SkillApi skillApi = new SkillApi();
            try {
                mGeneralSkillsList = getData(skillApi.execute(Utils.getJsonFromAssets(application)).get());
                mGeneraListMutableLiveData.postValue(mGeneralSkillsList);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
        }
    }


    public MutableLiveData<List<GeneralSkills>> getGeneraListMutableLiveData() {
        return mGeneraListMutableLiveData;
    }
    public List<GeneralSkills> getData(List<GroupSkills> groupSkillsList){
        List<GeneralSkills> generalSkillsList = new ArrayList<>();
        for (GroupSkills groupSkills:groupSkillsList
             ) {
            List<Skill> skillList = new ArrayList<>();
            addSkill(groupSkills.getJunior().split("\n"), Constants.LEVEL_JUNIOR,skillList);
            addSkill(groupSkills.getMiddle().split("\n"),Constants.LEVEL_MIDDLE,skillList);
            addSkill(groupSkills.getSenior().split("\n"),Constants.LEVEL_SENIOR,skillList);
            generalSkillsList.add(new GeneralSkills(groupSkills.getId(),groupSkills.getType(), null, skillList));
        }
        return generalSkillsList;
    }
    public void addSkill(String skillArray[], String type, List<Skill> skillList) {
        for (int i = 0; i < skillArray.length; i++) {
            if (skillArray[i] != null | !skillArray.equals("")) {
                Skill skill = new Skill(skillArray[i], false, type);
                skillList.add(skill);
            }
        }
    }

    public void createNewCandidate(Context context) {
        List<Skill> knowSkillList = new ArrayList<>();
        List<Skill> unknownSkillList = new ArrayList<>();;
        List<CandidateSkill> candidateSkillList = new ArrayList<>();
        for (GeneralSkills generalSkills:mGeneralSkillsList
             ) {
            List<Skill> skillList = generalSkills.getSkillList();
            for (Skill skill: skillList
                 ) {
                if(skill.getCheck()){
                    knowSkillList.add(skill);
                }else{
                    unknownSkillList.add(skill);
                }
            }
            CandidateSkill candidateSkill = new CandidateSkill(generalSkills.getType(),generalSkills.getLevel(),knowSkillList,unknownSkillList);
            candidateSkillList.add(candidateSkill);
        }
        String candidateSkillListString = Utils.convertCandidateSkillListToString(candidateSkillList);
        Candidate candidate = new Candidate(2,"Nguyễn Tuấn Anh",candidateSkillListString);
        CandidateDataBase.getInstance(context).candidateDao().insertCandidate(candidate);
    }
}
