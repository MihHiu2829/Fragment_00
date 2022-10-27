package com.example.fragment_00.View.Act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragment_00.R;
import com.example.fragment_00.View.Frg.m000_flash;
import com.example.fragment_00.View.Frg.m001_mainFrag;
import com.example.fragment_00.View.Frg.m002_detailFrag;
import com.example.fragment_00.View.onMainCallBack;
import com.example.fragment_00.databinding.M000SflashBinding;
import com.example.fragment_00.databinding.M001MainActBinding;
import com.example.fragment_00.databinding.M002DetailActBinding;

public class MainActivity extends AppCompatActivity implements onMainCallBack{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews() ;
    }

    private void initViews() {
        m000_flash frg = new m000_flash() ;
        frg.setCallBack(this);
       getSupportFragmentManager().beginTransaction().replace(R.id.Ln_main, frg, M000SflashBinding.class.getName()).commit();
    }

    @Override
    public void showFragment(String tag, Object data) {
                if(tag.equals(m001_mainFrag.TAG))
                {
                    showM001FRAG(data);
                }
                if(tag.equals(m002_detailFrag.TAG))
        {
            showM002FRAG(data) ;
        }
    }

    private void showM002FRAG(Object data) {
            m002_detailFrag frg = new m002_detailFrag() ;
            frg.setdata(data) ;
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.Ln_main,frg, M001MainActBinding.class.getName()).commit() ;
//            getSupportFragmentManager().beginTransaction().replace(R.id.Ln_main,frg,frg.getTag()).commit();  cach 2
//        getSupportFragmentManager().beginTransaction().replace(R.id.Ln_main,frg,m002_detailFrag.TAG).commit(); cach 3
    }

    private void showM001FRAG(Object data) {
        m001_mainFrag frg = new m001_mainFrag() ;
        frg.setCallBack(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.Ln_main, frg, M001MainActBinding.class.getName()).commit();
    }
}