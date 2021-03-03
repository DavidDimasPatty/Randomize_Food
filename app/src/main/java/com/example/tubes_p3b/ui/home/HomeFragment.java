package com.example.tubes_p3b.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tubes_p3b.FragmentListener;
import com.example.tubes_p3b.Menu.Person;
import com.example.tubes_p3b.R;
import com.example.tubes_p3b.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;
import java.util.Random;

import static com.example.tubes_p3b.ui.gallery.GalleryFragment.changeColor;

public class HomeFragment extends Fragment  implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    private FragmentListener listener;
    private TextView makan;
    private static SlideshowFragment slid;
    private Button btnNext;
    private Random randomGenerator;
    public static ArrayList<Person> peopleList;
    private View root;

    public HomeFragment (){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        if(changeColor==false) {
          this.root = inflater.inflate(R.layout.fragment_home, container, false);
        }
        else{
            this.root = inflater.inflate(R.layout.fragment_home, container, false);
            root.setBackgroundColor(Color.DKGRAY);
        }
        this.btnNext=root.findViewById(R.id.but);
        this.makan=root.findViewById(R.id.tv_title2);
        this.randomGenerator= new Random();
        btnNext.setOnClickListener(this);


        return root;

    }
    public static HomeFragment newInstance (){
        HomeFragment fragment=new HomeFragment();
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

    public void onClick(View v){

     if(v==this.btnNext) {
         Random ran=new Random();
         this.peopleList=SlideshowFragment.peopleList;
         int randomIndex = ran.nextInt(peopleList.size());
         String x= this.peopleList.get(randomIndex).getName();
        makan.setText(x);
     }
     }

}