package com.example.interviewapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.Data.Skill;
import com.example.interviewapp.R;
import com.example.interviewapp.databinding.SkillItemBinding;

import java.util.List;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.SkillViewHolder> {
    private List<Skill> mSkillList;

    public SkillRecyclerViewAdapter(List<Skill> mSkillList) {
        this.mSkillList = mSkillList;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SkillItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.skill_item, parent, false);
        return new SkillViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        Skill skill = mSkillList.get(position);
        holder.binding.titleSkillTextview.setText(skill.getType());
        holder.binding.contentLevelLinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.binding.contentLevelLinearlayout.getVisibility() == View.GONE) {
                    holder.binding.contentLevelLinearlayout.setVisibility(View.VISIBLE);
                } else {
                    holder.binding.contentLevelLinearlayout.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSkillList != null ? mSkillList.size() : 0;
    }


    public class SkillViewHolder extends RecyclerView.ViewHolder {
        private SkillItemBinding binding;

        public SkillViewHolder(@NonNull SkillItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
