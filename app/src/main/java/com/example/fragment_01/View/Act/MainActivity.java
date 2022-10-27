package com.example.fragment_01.View.Act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragment_01.R;
import com.example.fragment_01.View.Frg.m000_flash_frg;
import com.example.fragment_01.View.Frg.m001_mainAct;
import com.example.fragment_01.View.Frg.m002_detailFrag;
import com.example.fragment_01.View.OnMainCallBack;

public class MainActivity extends AppCompatActivity implements OnMainCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        m000_flash_frg frg = new m000_flash_frg() ;
        frg.setCallBack(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.Ln_Main,frg,m000_flash_frg.getFrg()).commit() ;

    }


    @Override
    public void showFragment(String tag, Object data) {
        if(tag.equals(m000_flash_frg.getFrg())) {
            gotoM001();
        }else if(tag.equals(m002_detailFrag.getTAG())){
            gotoM002(data) ;
        }
    }

    private void gotoM002(Object data) {
                m002_detailFrag frg = new m002_detailFrag() ;
                frg.setData(data) ;
                getSupportFragmentManager().beginTransaction().replace(R.id.Ln_Main,frg,frg.getTag()).commit() ;
    }

    private void gotoM001(){
        m001_mainAct frg = new m001_mainAct() ;
        frg.setCallBack(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.Ln_Main,frg,m001_mainAct.getFrg()).commit() ;
    }
}