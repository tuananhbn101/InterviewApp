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
    private final OnItemClick onItemClick;

    public QuestionRecyclerViewAdapter(List<Question> mQuestionList, OnItemClick onItemClick) {
        this.mQuestionList = mQuestionList;
        this.onItemClick = onItemClick;
    }


    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.question_item,parent,false);
        return new QuestionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.binding.questionTextview.setText(mQuestionList.get(position).getQuestion());
        holder.binding.questionTextview.setOnClickListener(v -> onItemClick.showAnswerDialog(mQuestionList.get(position).getQuestion(),mQuestionList.get(position).getAnswer()));
    }

    @Override
    public int getItemCount() {
        return mQuestionList!=null?mQuestionList.size():0;
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        private final QuestionItemBinding binding;
        public QuestionViewHolder(@NonNull QuestionItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
     public interface OnItemClick{
        void showAnswerDialog(String question,String answer);
     }
}
