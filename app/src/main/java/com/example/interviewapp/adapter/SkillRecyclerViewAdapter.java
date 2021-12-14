package com.example.interviewapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.data.Skill;
import com.example.interviewapp.R;
import com.example.interviewapp.databinding.SkillItemBinding;

import java.util.List;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.SkillViewHolder> {
    private final List<Skill> mSkillList;

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
        holder.binding.juniorContentLevelTextview.setText(skill.getJunior());
        holder.binding.middleContentLevelTextview.setText(skill.getMiddle());
        holder.binding.seniorContentLevelTextview.setText(skill.getSenior());
    }

    @Override
    public int getItemCount() {
        return mSkillList != null ? mSkillList.size() : 0;
    }


    public static class SkillViewHolder extends RecyclerView.ViewHolder {
        private final SkillItemBinding binding;

        public SkillViewHolder(@NonNull SkillItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
