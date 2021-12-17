package com.example.interviewapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.data.GroupSkills;
import com.example.interviewapp.data.Skill;
import com.example.interviewapp.R;
import com.example.interviewapp.databinding.SkillItemBinding;

import java.util.List;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.SkillViewHolder> {
    private final List<GroupSkills> mGroupSkillsList;
    public SkillRecyclerViewAdapter(List<GroupSkills> mGroupSkillsList) {
        this.mGroupSkillsList = mGroupSkillsList;
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
        holder.binding.titleSkillTextview.setText(mGroupSkillsList.get(position).getType());
        holder.binding.juniorContentLevelTextview.setText(mGroupSkillsList.get(position).getJunior());
        holder.binding.middleContentLevelTextview.setText(mGroupSkillsList.get(position).getMiddle());
        holder.binding.seniorContentLevelTextview.setText(mGroupSkillsList.get(position).getSenior());
    }

    @Override
    public int getItemCount() {
        return mGroupSkillsList != null ? mGroupSkillsList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class SkillViewHolder extends RecyclerView.ViewHolder {
        private final SkillItemBinding binding;

        public SkillViewHolder(@NonNull SkillItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
