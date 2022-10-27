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
import com.example.fragment_00.databinding.M002DetailActBinding;

public class m002_detailFrag extends  Fragment{
    private Context context  ;
    private M002DetailActBinding     binding ;
     private onMainCallBack callBack ;
     public static final String TAG = m002_detailFrag.class.getName() ;
    private Object mData;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context ;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.m002_detail_act,container,false) ;
        binding = M002DetailActBinding.bind(v) ;
        initViews();
        return v ;
        
    }

    private void initViews() {
        int drawaleID =   (int) ((Object[])mData)[0] ;
        String name = (String)((Object[])mData)[1] ;
        binding.ivImageAnimal.setImageResource(drawaleID);
        binding.tvNameAnimal.setText(name);
    }

    public void setdata(Object data) {
         mData = data;
    }
}
