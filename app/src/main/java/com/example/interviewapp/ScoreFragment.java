package com.example.interviewapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.interviewapp.adapter.ScoreRecyclerViewAdapter;
import com.example.interviewapp.data.Candidate;
import com.example.interviewapp.data.CandidateSkill;
import com.example.interviewapp.data.GeneralSkills;
import com.example.interviewapp.viewmodels.ScoreViewModel;
import com.example.interviewapp.viewmodels.SkillViewModel;
import com.example.interviewapp.databinding.FragmentSroceBinding;

import java.util.ArrayList;
import java.util.List;

public class ScoreFragment extends Fragment {
    private FragmentSroceBinding mBinding;
    private ScoreRecyclerViewAdapter mScoreRecyclerViewAdapter;
    private ScoreViewModel mScoreViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_sroce,container,false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBinding.scoreRecyclerview.setLayoutManager(layoutManager);
        mScoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        mScoreViewModel.getGeneraListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<GeneralSkills>>() {
            @Override
            public void onChanged(List<GeneralSkills> generalSkills) {
                mScoreRecyclerViewAdapter = new ScoreRecyclerViewAdapter(generalSkills,getContext());
                mBinding.scoreRecyclerview.setAdapter(mScoreRecyclerViewAdapter);
            }
        });
        mBinding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreViewModel.createNewCandidate(getContext());
            }
        });
        return mBinding.getRoot();
    }


}
