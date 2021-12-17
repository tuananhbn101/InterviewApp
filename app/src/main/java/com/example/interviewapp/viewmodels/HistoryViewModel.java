package com.example.interviewapp.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.interviewapp.data.Candidate;
import com.example.interviewapp.data.CandidateDataBase;
import com.example.interviewapp.data.CandidateSkill;

import java.util.ArrayList;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    private MutableLiveData<List<Candidate>> mCandidateMutableLiveData;
    private List<Candidate> mCandidateList;

    public HistoryViewModel() {
        if (mCandidateMutableLiveData == null) {
            mCandidateMutableLiveData = new MutableLiveData<>();
        }
    }
    public MutableLiveData<List<Candidate>> getCandidateMutableLiveData() {
        return mCandidateMutableLiveData;
    }
    public void getData(Context context){
        mCandidateList = CandidateDataBase.getInstance(context).candidateDao().getAllCandidate();
        mCandidateMutableLiveData.postValue(mCandidateList);
    }

}
