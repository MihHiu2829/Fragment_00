package com.example.fragment_00.View.Frg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragment_00.R;
import com.example.fragment_00.View.onMainCallBack;
import com.example.fragment_00.databinding.M000SflashBinding;
import com.example.fragment_00.databinding.M001MainActBinding;

import ViewModel.m001_VM;

public class m001_mainFrag extends Fragment {
    private Context context ;
    private M001MainActBinding binding ;
    public static final String TAG = m001_mainFrag.class.getName() ;
    private onMainCallBack callBack ;
    private m001_VM viewModel ;
    public void setCallBack(onMainCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context ;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.m001_main_act,container,false) ;
            binding = M001MainActBinding.bind(v) ;
            viewModel = new ViewModelProvider(this).get(m001_VM.class) ;
            initViews(); 
            return v ; 

    }

    private void initViews() {
        binding.ivBird.setOnClickListener(v -> gotoContent(v, R.drawable.icon_bird,R.string.contentBird));
        binding.ivChecken.setOnClickListener(v -> gotoContent(v, R.drawable.icon_checken,R.string.contentChecken));
        binding.ivDog.setOnClickListener(v -> gotoContent(v, R.drawable.icon_dog,R.string.contentDog));
        binding.ivPenguin.setOnClickListener(v -> gotoContent(v, R.drawable.icon_penguin,R.string.contentPenguin));
        binding.btDetail.setOnClickListener(v -> gotoDetail());
        if(viewModel.getDrawableID()>0)
        {
                View view = binding.getRoot().findViewById(viewModel.getvID()) ;
            gotoContent(view,viewModel.getDrawableID(),viewModel.getContent()) ;
        }

    }

    private void gotoDetail() {
            callBack.showFragment(m002_detailFrag.TAG, new Object[]{viewModel.getDrawableID(),viewModel.getName()});

    }

    private void gotoContent(View v, int drawable, int content) {
        v.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
        viewModel.setDrawableID(drawable);
        viewModel.setvID(v.getId());
          viewModel.setName(v.getContentDescription().toString()) ;
        binding.btDetail.setEnabled(true);
        viewModel.setContent(content);
        binding.tvContentAnimal.setText(viewModel.getContent());

    }
}
