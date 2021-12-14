package com.example.interviewapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.interviewapp.adapter.ScoreRecyclerViewAdapter;
import com.example.interviewapp.viewmodels.SkillViewModel;
import com.example.interviewapp.databinding.FragmentSroceBinding;

public class ScoreFragment extends Fragment {
    private FragmentSroceBinding mBinding;
    private ScoreRecyclerViewAdapter mScoreRecyclerViewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_sroce,container,false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBinding.scoreRecyclerview.setLayoutManager(layoutManager);
        SkillViewModel skillViewModel = ViewModelProviders.of(this).get(SkillViewModel.class);
        skillViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), skills -> {
            mScoreRecyclerViewAdapter = new ScoreRecyclerViewAdapter(skills,getContext());
            mBinding.scoreRecyclerview.setAdapter(mScoreRecyclerViewAdapter);
        });
        return mBinding.getRoot();
    }


}
