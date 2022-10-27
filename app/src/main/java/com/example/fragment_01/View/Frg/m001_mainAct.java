package com.example.fragment_01.View.Frg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragment_01.R;
import com.example.fragment_01.View.OnMainCallBack;
import com.example.fragment_01.ViewModel.m001_VM;
import com.example.fragment_01.databinding.M001MainActBinding;

public class m001_mainAct extends Fragment {

    private Context context ;
    private M001MainActBinding binding;
    private  static String frg = m001_mainAct.class.getName() ;
    private m001_VM viewModel;
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

        View view = inflater.inflate(R.layout.m001_main_act,container,false) ;
        binding = M001MainActBinding.bind(view) ;
         viewModel = new ViewModelProvider(this).get(m001_VM.class) ;
        initViews() ;
        return view ;
    }

    private void initViews() {

        binding.ivBird.setOnClickListener(v -> gotoContent(v, R.drawable.icon_bird,R.string.contentBird));
        binding.ivChecken.setOnClickListener(v -> gotoContent(v, R.drawable.icon_checken,R.string.contentChecken));
        binding.ivDog.setOnClickListener(v -> gotoContent(v, R.drawable.icon_dog,R.string.contentDog));
        binding.ivPenguin.setOnClickListener(v -> gotoContent(v, R.drawable.icon_penguin,R.string.contentPenguin));
        binding.btDetail.setOnClickListener(v -> gotoDetail());
//        if(viewModel.getDrawableID()>0)
//        {
//            View view = binding.getRoot().findViewById(viewModel.getvID()) ;
//            gotoContent(view,viewModel.getDrawableID(),viewModel.getContent()) ;
//        }
    }
    private void gotoDetail() {
        callBack.showFragment(m002_detailFrag.getTAG(), new Object[]{viewModel.getDrawableID(),viewModel.getName()});

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
