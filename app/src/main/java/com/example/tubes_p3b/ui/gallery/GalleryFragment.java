package com.example.tubes_p3b.ui.gallery;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tubes_p3b.FragmentListener;
import com.example.tubes_p3b.R;

public class GalleryFragment extends Fragment{
    public GalleryFragment (){

    }
    private Button btn;
    private Button btn2;
    private GalleryViewModel galleryViewModel;
    private FragmentListener listener;
    private View layout;
    private View root;
    private Fragment fragment1;
    public static boolean changeColor;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        if(changeColor==false) {
            this.root = inflater.inflate(R.layout.fragment_gallery, container, false);
        }
        else{
            this.root=inflater.inflate(R.layout.fragment_gallery, container, false);
            this.root.setBackgroundColor(Color.DKGRAY);
        }
        this.btn=root.findViewById(R.id.btn);
        this.btn2=root.findViewById(R.id.btn2);
        this.layout=root.findViewById(R.id.setting);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.setBackgroundColor(Color.DKGRAY);
                changeColor=true;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setBackgroundColor(Color.WHITE);
                changeColor=false;

            }
        });

        return root;
    }
    public static GalleryFragment newInstance (){
        GalleryFragment fragment=new GalleryFragment();
        Bundle args=new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener=(FragmentListener) context;
        }
        else{
            throw new ClassCastException(context.toString()+"must implement FragmentListener");
        }
    }



}