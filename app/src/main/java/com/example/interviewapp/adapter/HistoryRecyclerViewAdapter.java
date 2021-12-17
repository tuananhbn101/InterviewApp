package com.example.interviewapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.R;
import com.example.interviewapp.data.Candidate;
import com.example.interviewapp.databinding.CandidateItemBinding;

import java.util.List;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.HistoryViewHolder> {
    private final List<Candidate> mCandidateList;
    private final OnClickShareEvent mOnClickShareEvent;

    public HistoryRecyclerViewAdapter(List<Candidate> mCandidateList, OnClickShareEvent mOnClickShareEvent) {
        this.mCandidateList = mCandidateList;
        this.mOnClickShareEvent = mOnClickShareEvent;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CandidateItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.candidate_item, parent, false);
        return new HistoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String name =mCandidateList.get(position).getName();
        holder.binding.nameCandidateTextview.setText(name);
        holder.binding.nameCandidateTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickShareEvent.showCandidateSkill(position);
            }
        });
        holder.binding.shareImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickShareEvent.shareFile(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCandidateList != null ? mCandidateList.size() : 0;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private final CandidateItemBinding binding;

        public HistoryViewHolder(@NonNull CandidateItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface OnClickShareEvent{
        void shareFile(int position);
        void showCandidateSkill(int position);
    }
}
