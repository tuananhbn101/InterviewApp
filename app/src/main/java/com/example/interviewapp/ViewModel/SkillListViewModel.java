package com.example.interviewapp.ViewModel;

import static com.example.interviewapp.Utils.Utils.getJsonFromAssets;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.interviewapp.Data.Skill;
import java.util.List;

public class SkillListViewModel extends ViewModel {
    private MutableLiveData<List<Skill>> mSkillListMutableLiveData;
    public List<Skill> skillList;

    public MutableLiveData<List<Skill>> getSkillListMutableLiveData() {
        if(mSkillListMutableLiveData==null){
            mSkillListMutableLiveData = new MutableLiveData<List<Skill>>();
        }
        return mSkillListMutableLiveData;
    }

}
