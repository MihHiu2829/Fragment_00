package com.example.fragment_00.View.Frg;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_00.R;
import com.example.fragment_00.View.onMainCallBack;
import com.example.fragment_00.databinding.M000SflashBinding;

public class m000_flash extends  Fragment{
    private Context context  ;
    private M000SflashBinding binding ;
     private onMainCallBack callBack ;
     public static final String TAG = m000_flash.class.getName() ;

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



        View v = inflater.inflate(R.layout.m000_sflash,container,false) ;
        binding = M000SflashBinding.bind(v) ;
        initViews();
        return v ;
        
    }

    private void initViews() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                            callBack.showFragment(m001_mainFrag.TAG,null);
                }
            },2000) ;
    }
}
