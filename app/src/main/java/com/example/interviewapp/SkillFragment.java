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

import com.example.interviewapp.adapter.SkillRecyclerViewAdapter;
import com.example.interviewapp.data.Skill;
import com.example.interviewapp.viewmodels.SkillViewModel;
import com.example.interviewapp.databinding.FragmentSkillBinding;

import java.util.List;

public class SkillFragment extends Fragment {
    private FragmentSkillBinding mBinding;
    private SkillRecyclerViewAdapter mSkillRecyclerViewAdapter;
    private SkillViewModel mSkillViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_skill,container,false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBinding.skillRecyclerview.setLayoutManager(layoutManager);
        mSkillViewModel = ViewModelProviders.of(this).get(SkillViewModel.class);
        mSkillViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Skill>>() {
            @Override
            public void onChanged(List<Skill> skills) {
                mSkillRecyclerViewAdapter = new SkillRecyclerViewAdapter(skills);
                mBinding.skillRecyclerview.setAdapter(mSkillRecyclerViewAdapter);
            }
        });
        return mBinding.getRoot();
    }
}
