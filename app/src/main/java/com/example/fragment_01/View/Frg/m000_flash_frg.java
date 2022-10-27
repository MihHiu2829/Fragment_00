package com.example.fragment_01.View.Frg;

import android.content.Context;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_01.R;
import com.example.fragment_01.View.OnMainCallBack;
import com.example.fragment_01.databinding.M000FlashBinding;

public class m000_flash_frg extends Fragment {
        private Context context;
        private M000FlashBinding binding ;
        private static  String   frg = m000_flash_frg.class.getName() ;
        private OnMainCallBack callBack ;


    public void setCallBack(OnMainCallBack callBack) {
        this.callBack = callBack;
    }

    public static String getFrg() {
        return frg;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context ;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m000_flash,container,false);
        binding = M000FlashBinding.bind(v) ;
        initViews();
        return v  ;

    }

    private void initViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            callBack.showFragment(frg,null);
            }
        },2000) ;

    }
}
