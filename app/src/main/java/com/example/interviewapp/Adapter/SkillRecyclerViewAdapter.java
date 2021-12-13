package com.example.interviewapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.Data.Skill;
import com.example.interviewapp.R;

import java.util.List;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.SkillViewHolder> {
    private List<Skill> mSkillList;


    public SkillRecyclerViewAdapter(List<Skill> mSkillList) {
        this.mSkillList = mSkillList;
    }

    @NonNull
    @Override
    public SkillRecyclerViewAdapter.SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SkillViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillRecyclerViewAdapter.SkillViewHolder holder, int position) {
        holder.mTitleSkillTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.mContentLevelLinearLayout.getVisibility()==View.GONE){
                    holder.mContentLevelLinearLayout.setVisibility(View.VISIBLE);
                }else {
                    holder.mContentLevelLinearLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSkillList!=null?mSkillList.size():0;
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleSkillTextView;
        private LinearLayout mContentLevelLinearLayout;
        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleSkillTextView = itemView.findViewById(R.id.title_skill_textview);
            mContentLevelLinearLayout = itemView.findViewById(R.id.content_level_linearlayout);
        }
    }
}
