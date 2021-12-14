package com.example.interviewapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.interviewapp.api.SkillApi;
import com.example.interviewapp.data.Skill;
import com.example.interviewapp.utils.Utils;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class SkillViewModel extends AndroidViewModel {

    private MutableLiveData<List<Skill>> mListMutableLiveData;
    private List<Skill> mSkillList;

    public SkillViewModel(@NonNull Application application) {
        super(application);
        if(mListMutableLiveData==null){
            mListMutableLiveData = new MutableLiveData<>();
        }
        SkillApi skillApi = new SkillApi();
        try {
            mSkillList = skillApi.execute(Utils.getJsonFromAssets(application)).get();
            mListMutableLiveData.postValue(mSkillList);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MutableLiveData<List<Skill>> getListMutableLiveData() {
        return mListMutableLiveData;
    }

}
