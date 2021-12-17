package com.example.interviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.interviewapp.adapter.PagerAdapter;
import com.example.interviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, getApplicationContext());
        mBinding.contentViewpager.setOffscreenPageLimit(2);
        mBinding.contentViewpager.setAdapter(mPagerAdapter);
        mBinding.titleTablelayout.setupWithViewPager(mBinding.contentViewpager);
    }
}