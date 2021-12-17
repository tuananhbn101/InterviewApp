package com.example.interviewapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.interviewapp.HistoryFragment;
import com.example.interviewapp.QuestionFragment;
import com.example.interviewapp.R;
import com.example.interviewapp.ScoreFragment;
import com.example.interviewapp.SkillFragment;
import com.example.interviewapp.utils.Constants;

public class PagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    Context context;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior,Context context) {
        super(fm, behavior);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constants.QUESTION_POSITION:
                return new QuestionFragment();
            case Constants.SCORE_POSITION:
                return new ScoreFragment();
            case Constants.HISTORY_POSITION:
                return new HistoryFragment();
            case Constants.SKILL_POSITION:
            default:
                return new SkillFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case Constants.SKILL_POSITION:
                title = context.getResources().getString(R.string.skill);
                break;
            case Constants.QUESTION_POSITION:
                title = context.getResources().getString(R.string.question);
                break;
            case Constants.SCORE_POSITION:
                title = context.getResources().getString(R.string.score);
                break;
            case Constants.HISTORY_POSITION:
                title = context.getResources().getString(R.string.history);
                break;
        }
        return title;
    }
}
