package com.example.interviewapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.interviewapp.api.SkillApi;
import com.example.interviewapp.data.GroupSkills;
import com.example.interviewapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class SkillViewModel extends AndroidViewModel {

    private final MutableLiveData<List<GroupSkills>> mListMutableLiveData;
    private List<GroupSkills> groupSkills;

    public SkillViewModel(@NonNull Application application) {
        super(application);
        mListMutableLiveData = new MutableLiveData<List<GroupSkills>>();
        SkillApi skillApi = new SkillApi();
        try {
            groupSkills = skillApi.execute(Utils.getJsonFromAssets(application)).get();
            mListMutableLiveData.postValue(groupSkills);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MutableLiveData<List<GroupSkills>> getListMutableLiveData() {
        return mListMutableLiveData;
    }
    public void searchSkill(String type){
        List<GroupSkills> searchList = new ArrayList<>();
        for (GroupSkills groupSkills: groupSkills
             ) {
            if(groupSkills.getType().toLowerCase(Locale.ROOT).contains(type.toLowerCase(Locale.ROOT))){
                searchList.add(groupSkills);
            }
        }
        mListMutableLiveData.postValue(searchList);
    }
}
