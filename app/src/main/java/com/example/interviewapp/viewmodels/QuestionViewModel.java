package com.example.interviewapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.interviewapp.data.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private  MutableLiveData<List<Question>> mMutableLiveData;
    private List<Question> mQuestionList;
    public QuestionViewModel(@NonNull Application application) {
        super(application);
        if(mMutableLiveData==null){
            mMutableLiveData = new MutableLiveData<>();
            initData();
        }
    }

    public MutableLiveData<List<Question>> getMutableLiveData() {
        return mMutableLiveData;
    }

    private void initData() {
        mQuestionList = new ArrayList<>();
        mQuestionList.add(new Question(1,"Hi","ho"));
    }
}
