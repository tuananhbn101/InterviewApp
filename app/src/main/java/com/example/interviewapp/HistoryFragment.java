package com.example.interviewapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.interviewapp.adapter.HistoryRecyclerViewAdapter;
import com.example.interviewapp.data.Candidate;
import com.example.interviewapp.databinding.DialogAnswerBinding;
import com.example.interviewapp.databinding.FragmentHistoryBinding;
import com.example.interviewapp.utils.Utils;
import com.example.interviewapp.viewmodels.HistoryViewModel;
import com.google.gson.annotations.Until;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryFragment extends Fragment {
    private FragmentHistoryBinding mBinding;
    private HistoryViewModel mHistoryViewModel;
    private HistoryRecyclerViewAdapter mHistoryRecyclerViewAdapter;
    private List<Candidate> candidateList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false);
        candidateList = new ArrayList<>();
        mHistoryViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.historyRecyclerView.setLayoutManager(linearLayoutManager);
        mHistoryViewModel.getCandidateMutableLiveData().observe(getViewLifecycleOwner(), candidateList -> {
            this.candidateList = candidateList;
            mHistoryRecyclerViewAdapter = new HistoryRecyclerViewAdapter(candidateList, new HistoryRecyclerViewAdapter.OnClickShareEvent() {
                @Override
                public void shareFile(int position) {
                    Utils.exportCandidateFile(candidateList.get(position).getName(),Utils.convertStringToCandidateSkillList(candidateList.get(position).getCandidateSkills()));
                    Utils.shareFile(getContext(),candidateList.get(position).getName());
                }

                @Override
                public void showCandidateSkill(int position) {
                    Utils.showDialogAnswer(getActivity(), candidateList.get(position).getName(),
                            (candidateList.get(position).getCandidateSkills()));
                }
            });
            mBinding.historyRecyclerView.setAdapter(mHistoryRecyclerViewAdapter);
        });
        mHistoryViewModel.getData(getContext());
        mBinding.shareAllFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.exportFile("Data",candidateList);
                Utils.shareFile(getContext(),"Data");
            }
        });
        return mBinding.getRoot();
    }
}
