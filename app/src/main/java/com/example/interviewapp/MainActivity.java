package com.example.interviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;

import com.example.interviewapp.adapter.PagerAdapter;
import com.example.interviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mBinding.contentViewpager.setOffscreenPageLimit(2);
        mBinding.contentViewpager.setAdapter(mPagerAdapter);
        mBinding.titleTablelayout.setupWithViewPager(mBinding.contentViewpager);
    }
}