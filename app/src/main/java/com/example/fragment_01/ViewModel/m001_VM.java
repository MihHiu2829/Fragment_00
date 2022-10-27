package com.example.fragment_01.ViewModel;

import androidx.lifecycle.ViewModel;

public class m001_VM extends ViewModel {
    private String name;
    private int  drawableID ;
    private int content ;
    private int vID ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawableID() {
        return drawableID;
    }

    public void setDrawableID(int drawableID) {
        this.drawableID = drawableID;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getvID() {
        return vID;
    }

    public void setvID(int vID) {
        this.vID = vID;
    }
}
