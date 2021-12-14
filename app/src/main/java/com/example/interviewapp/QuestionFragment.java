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

import com.example.interviewapp.adapter.QuestionRecyclerViewAdapter;
import com.example.interviewapp.data.Question;
import com.example.interviewapp.utils.Utils;
import com.example.interviewapp.databinding.FragmentQuestionBinding;
import com.example.interviewapp.viewmodels.QuestionViewModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionFragment extends Fragment {
    private FragmentQuestionBinding mBinding;
    private QuestionRecyclerViewAdapter mQuestionRecyclerViewAdapter;
    private QuestionViewModel mQuestionViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.questionRecyclerview.setLayoutManager(linearLayoutManager);
        mQuestionViewModel = ViewModelProviders.of(this).get(QuestionViewModel.class);
        mQuestionViewModel.getMutableLiveData().observe(getViewLifecycleOwner(), questions -> {
            mQuestionRecyclerViewAdapter = new QuestionRecyclerViewAdapter(questions);
            mBinding.questionRecyclerview.setAdapter(mQuestionRecyclerViewAdapter);
        });
        return mBinding.getRoot();
    }
}
