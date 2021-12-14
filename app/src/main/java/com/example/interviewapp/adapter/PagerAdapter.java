package com.example.interviewapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.interviewapp.QuestionFragment;
import com.example.interviewapp.ScoreFragment;
import com.example.interviewapp.SkillFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new QuestionFragment();
            case 2:
                return new ScoreFragment();
            case 0:
            default:
                return new SkillFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Skill";
                break;
            case 1:
                title = "Question";
                break;
            case 2:
                title = "Score";
                break;
        }
        return title;
    }
}
