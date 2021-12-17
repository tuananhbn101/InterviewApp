package com.example.interviewapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.example.interviewapp.data.GroupSkills;
import com.example.interviewapp.data.Skill;
import com.example.interviewapp.utils.Utils;
import com.example.interviewapp.viewmodels.SkillViewModel;
import com.example.interviewapp.databinding.FragmentSkillBinding;

import java.io.IOException;
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
        mSkillViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<GroupSkills>>() {
            @Override
            public void onChanged(List<GroupSkills> groupSkills) {
                mSkillRecyclerViewAdapter = new SkillRecyclerViewAdapter(groupSkills);
                mBinding.skillRecyclerview.setAdapter(mSkillRecyclerViewAdapter);
            }
        });
        mBinding.searchEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSkillViewModel.searchSkill(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return mBinding.getRoot();
    }
}
