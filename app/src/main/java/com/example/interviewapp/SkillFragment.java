package com.example.interviewapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.Adapter.SkillRecyclerViewAdapter;
import com.example.interviewapp.Api.SkillApi;
import com.example.interviewapp.Data.Skill;
import com.example.interviewapp.Utils.Utils;
import com.example.interviewapp.ViewModel.SkillListViewModel;
import com.example.interviewapp.databinding.FragmentSkillBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SkillFragment extends Fragment {
    private FragmentSkillBinding mBinding;
    private List<Skill> mSkillList;
    private SkillRecyclerViewAdapter mSkillRecyclerViewAdapter;
    private String jsonFile = Utils.getJsonFromAssets(getContext(),"skill_android.json");
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_skill,container,false);
        init();
        mSkillRecyclerViewAdapter = new SkillRecyclerViewAdapter(mSkillList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBinding.skillRecyclerview.setLayoutManager(layoutManager);
        mBinding.skillRecyclerview.setAdapter(mSkillRecyclerViewAdapter);
        return mBinding.getRoot();
    }
    public void init(){
        mSkillList = new ArrayList<>();
        SkillApi skillApi = new SkillApi();
        try {
            mSkillList = skillApi.execute(jsonFile).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
