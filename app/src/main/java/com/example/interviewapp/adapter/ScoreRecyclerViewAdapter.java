package com.example.interviewapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.data.GeneralSkills;
import com.example.interviewapp.data.Skill;
import com.example.interviewapp.R;
import com.example.interviewapp.databinding.ScoreItemBinding;
import com.example.interviewapp.databinding.SkillChecklistItemBinding;
import com.example.interviewapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecyclerViewAdapter extends RecyclerView.Adapter<ScoreRecyclerViewAdapter.ScoreViewHolder>{
    public ScoreRecyclerViewAdapter(List<GeneralSkills> mGeneralSkillsList, Context context) {
        this.mGeneralSkillsList = mGeneralSkillsList;
        this.context = context;

    }

    private final List<GeneralSkills> mGeneralSkillsList;
    private final Context context;



    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ScoreItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.score_item,parent,false);
        return new ScoreViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SkillCheckRecyclerViewAdapter mSkillCheckRecyclerViewAdapter = new SkillCheckRecyclerViewAdapter(mGeneralSkillsList.get(position).getSkillList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.binding.skillChecklistRecyclerview.setLayoutManager(linearLayoutManager);
        holder.binding.skillChecklistRecyclerview.setAdapter(mSkillCheckRecyclerViewAdapter);
        holder.binding.titleSkillTextview.setText(mGeneralSkillsList.get(position).getType());
        holder.binding.levelRadiobuttonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.junior_radiobutton:
                        mGeneralSkillsList.get(position).setLevel(Constants.LEVEL_JUNIOR);
                        break;
                    case R.id.middle_radiobutton:
                        mGeneralSkillsList.get(position).setLevel(Constants.LEVEL_MIDDLE);
                        break;
                    case R.id.senior_radiobutton:
                        mGeneralSkillsList.get(position).setLevel(Constants.LEVEL_SENIOR);
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGeneralSkillsList!=null?mGeneralSkillsList.size():0;
    }

    public static class ScoreViewHolder extends RecyclerView.ViewHolder {
        private final ScoreItemBinding binding;

        public ScoreViewHolder(@NonNull ScoreItemBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
    public static class SkillCheckRecyclerViewAdapter extends RecyclerView.Adapter<SkillCheckRecyclerViewAdapter.SkillCheckViewHolder> {
        private final List<Skill> mSkillList;

        public SkillCheckRecyclerViewAdapter(List<Skill> mSkillList) {
            this.mSkillList = mSkillList;
        }


        @NonNull
        @Override
        public SkillCheckViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            SkillChecklistItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.skill_checklist_item,parent,false);
            return new SkillCheckViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull SkillCheckViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.binding.skillCheckbox.setText(mSkillList.get(position).getSkill());
            holder.binding.skillCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mSkillList.get(position).setCheck(true);
                    }
                }
            });
            if(mSkillList.get(position).getType().equals(Constants.LEVEL_JUNIOR)){
                holder.binding.skillCheckbox.setBackgroundResource(R.color.junior_color);
            }else if(mSkillList.get(position).getType().equals(Constants.LEVEL_MIDDLE)){
                holder.binding.skillCheckbox.setBackgroundResource(R.color.middle_color);
            } else {
                holder.binding.skillCheckbox.setBackgroundResource(R.color.senior_color);
            }
        }

        @Override
        public int getItemCount() {
            return mSkillList!=null?mSkillList.size():0;
        }

        public class SkillCheckViewHolder extends RecyclerView.ViewHolder {
            private final SkillChecklistItemBinding binding;
            public SkillCheckViewHolder(SkillChecklistItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }
}
