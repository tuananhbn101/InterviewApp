package com.example.interviewapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.interviewapp.adapter.QuestionRecyclerViewAdapter;
import com.example.interviewapp.databinding.DialogAnswerBinding;
import com.example.interviewapp.databinding.FragmentQuestionBinding;
import com.example.interviewapp.utils.Utils;
import com.example.interviewapp.viewmodels.QuestionViewModel;

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
            mQuestionRecyclerViewAdapter = new QuestionRecyclerViewAdapter(questions, new QuestionRecyclerViewAdapter.OnItemClick() {
                @Override
                public void showAnswerDialog(String question, String answer) {
                    Utils.showDialogAnswer(getActivity(),question,answer);
                }
            });
                    mBinding.questionRecyclerview.setAdapter(mQuestionRecyclerViewAdapter);
        });
        return mBinding.getRoot();
    }

}
