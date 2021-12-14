package com.example.interviewapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.R;
import com.example.interviewapp.data.Question;
import com.example.interviewapp.databinding.QuestionItemBinding;

import java.util.List;

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<QuestionRecyclerViewAdapter.QuestionViewHolder> {
    private final List<Question> mQuestionList;


    public QuestionRecyclerViewAdapter(List<Question> mQuestionList) {
        this.mQuestionList = mQuestionList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.question_item,parent,false);
        return new QuestionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mQuestionList!=null?mQuestionList.size():0;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        private QuestionItemBinding binding;
        public QuestionViewHolder(@NonNull QuestionItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
