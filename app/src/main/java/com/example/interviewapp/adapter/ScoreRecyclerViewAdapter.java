package com.example.interviewapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.data.Skill;
import com.example.interviewapp.R;
import com.example.interviewapp.databinding.ScoreItemBinding;

import java.util.List;

public class ScoreRecyclerViewAdapter extends RecyclerView.Adapter<ScoreRecyclerViewAdapter.ScoreViewHolder>{
    private final List<Skill> mSkillList;
    private final Context context;

    public ScoreRecyclerViewAdapter(List<Skill> mSkillList, Context context) {
        this.mSkillList = mSkillList;
        this.context = context;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ScoreItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.score_item,parent,false);
        return new ScoreViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        holder.binding.titleSkillTextview.setText(mSkillList.get(position).getType());
        String []juniorContent = mSkillList.get(position).getJunior().split("\n");
        String []middleContent = mSkillList.get(position).getMiddle().split("\n");
        String []seniorContent = mSkillList.get(position).getSenior().split("\n");
        addView(holder.binding.juniorContentLevelLinearlayout,juniorContent,context);
        holder.binding.juniorContentLevelLinearlayout.setBackgroundResource(R.color.junior_color);
        addView(holder.binding.middleContentLevelLinearlayout,middleContent,context);
        holder.binding.middleContentLevelLinearlayout.setBackgroundResource(R.color.middle_color);
        addView(holder.binding.seniorContentLevelLinearlayout,seniorContent,context);
        holder.binding.seniorContentLevelLinearlayout.setBackgroundResource(R.color.senior_color);
    }

    @Override
    public int getItemCount() {
        return mSkillList!=null?mSkillList.size():0;
    }

    public static class ScoreViewHolder extends RecyclerView.ViewHolder {
        private final ScoreItemBinding binding;
        public ScoreViewHolder(@NonNull ScoreItemBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
    public CheckBox createView(Context context, String text){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        CheckBox checkBox = new CheckBox(context);
        params.topMargin = 10;
        checkBox.setText(text);
        checkBox.setLayoutParams(params);
        checkBox.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        return checkBox;
    }
    public void addView(LinearLayout linearLayout,String []levelContent,Context context){
        for (String s : levelContent) {
            if (s != null) {
                linearLayout.addView(createView(context, s));
            }
        }
    }
}
