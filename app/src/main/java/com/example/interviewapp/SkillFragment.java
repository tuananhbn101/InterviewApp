package com.example.interviewapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewapp.Adapter.SkillRecyclerViewAdapter;
import com.example.interviewapp.Data.Skill;
import com.example.interviewapp.databinding.FragmentSkillBinding;

import java.util.ArrayList;
import java.util.List;

public class SkillFragment extends Fragment {
    private FragmentSkillBinding mBinding;
    private List<Skill> mSkillList;
    private SkillRecyclerViewAdapter mSkillRecyclerViewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_skill,container,false);
        setDummyData();
        mSkillRecyclerViewAdapter = new SkillRecyclerViewAdapter(mSkillList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBinding.skillRecyclerview.setLayoutManager(layoutManager);
        mBinding.skillRecyclerview.setAdapter(mSkillRecyclerViewAdapter);
        return mBinding.getRoot();
    }
    public void setDummyData(){
        mSkillList = new ArrayList<>();
        mSkillList.add(new Skill(1,
                "Kiến thức lập trình chung","- Code convension\n- OOP\n- Cấu trúc rẽ nhánh\n- Vòng lặp\n- DataType tổ chức dữ liệu",
                "- Thuật toán cơ bản ( đệ quy, sắp xếp )\n- Tư duy thuật toán\n- Hiểu về 5 nguyên lý solid",
                "Thuật toán khó, nâng cao ( quy hoạch động, bit, tree, đồ thị )\n-  Tính toán độ phức tạp thuật toán"));
        mSkillList.add(new Skill(2,
                "Design patterns","- Code convension\n- OOP\n- Cấu trúc rẽ nhánh\n- Vòng lặp\n- DataType tổ chức dữ liệu",
                "- Thuật toán cơ bản ( đệ quy, sắp xếp )\n- Tư duy thuật toán\n- Hiểu về 5 nguyên lý solid",
                "Thuật toán khó, nâng cao ( quy hoạch động, bit, tree, đồ thị )\n-  Tính toán độ phức tạp thuật toán"));
        mSkillList.add(new Skill(3,
                "Threading","- Code convension\n- OOP\n- Cấu trúc rẽ nhánh\n- Vòng lặp\n- DataType tổ chức dữ liệu",
                "- Thuật toán cơ bản ( đệ quy, sắp xếp )\n- Tư duy thuật toán\n- Hiểu về 5 nguyên lý solid",
                "Thuật toán khó, nâng cao ( quy hoạch động, bit, tree, đồ thị )\n-  Tính toán độ phức tạp thuật toán"));
    }
}
