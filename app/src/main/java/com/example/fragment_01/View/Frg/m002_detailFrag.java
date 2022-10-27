package com.example.fragment_01.View.Frg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_01.R;
import com.example.fragment_01.databinding.M002DetailActBinding;

public class m002_detailFrag extends Fragment {
    private Context context ;
    private  static String TAG = m002_detailFrag.class.getName() ;
    private Object mData ;

    public static String getTAG() {
        return TAG;
    }

    private M002DetailActBinding binding ;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context ;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m002_detail_act,container,false) ;
        binding = M002DetailActBinding.bind(view) ;
        initViews() ;
        return view ;
    }

    private void initViews() {
        int drawaleID =   (int) ((Object[])mData)[0] ;
        String name = (String)((Object[])mData)[1] ;
        binding.ivImageAnimal.setImageResource(drawaleID);
        binding.tvNameAnimal.setText(name);
    }

    public void setData(Object data) {
        this.mData = data ;
    }
}
