package com.example.tubes_p3b.ui.home;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tubes_p3b.ui.slideshow.SlideshowFragment;

import java.util.Random;

public class HomeViewModel extends ViewModel implements  HomeInterface{

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    @Override
    public void onClick(View v) {

    }
}