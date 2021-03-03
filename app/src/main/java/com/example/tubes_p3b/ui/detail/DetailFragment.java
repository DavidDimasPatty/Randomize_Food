package com.example.tubes_p3b.ui.detail;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tubes_p3b.FragmentListener;
import com.example.tubes_p3b.Menu.Person;
import com.example.tubes_p3b.R;
import com.example.tubes_p3b.Storage;
import com.example.tubes_p3b.ui.slideshow.SlideshowFragment;

import static com.example.tubes_p3b.ui.gallery.GalleryFragment.changeColor;
import static com.example.tubes_p3b.ui.slideshow.SlideshowFragment.peopleList;
import static com.example.tubes_p3b.ui.slideshow.SlideshowFragment.nama;

public class DetailFragment extends Fragment  implements View.OnClickListener {

    public DetailFragment (){

    }
    private Storage pencatat;
    private DetailViewModel DetailViewModel;
    private FragmentListener listener;
    public static EditText tag;
    public EditText bahan;
    public TextView judul;
    public EditText resto;

    public EditText cara;
    private Button save;
    public static Integer posPencet;
    private View root;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DetailViewModel =
                ViewModelProviders.of(this).get(DetailViewModel.class);

        if(changeColor==false) {
            this.root = inflater.inflate(R.layout.detail_makanan, container, false);
        }
        else{
            this.root = inflater.inflate(R.layout.detail_makanan, container, false);
            root.setBackgroundColor(Color.DKGRAY);
        }

        this.pencatat=new Storage(getContext());
        this.tag=root.findViewById(R.id.tag);
        this.bahan=root.findViewById(R.id.bahan);
        this.judul=root.findViewById(R.id.judul);
        this.resto=root.findViewById(R.id.resto);
        this.cara=root.findViewById(R.id.cara);
        this.save=root.findViewById(R.id.save);

        tag.setText(nama);
        judul.setText(nama);
        bahan.setText(SlideshowFragment.bahan);
        resto.setText(SlideshowFragment.resto);
        cara.setText(SlideshowFragment.cara);
        this.save.setOnClickListener(this);


        return root;
    }
    public static DetailFragment newInstance (String title,String bahan,String resto){
        DetailFragment fragment=new DetailFragment();
        Bundle args=new Bundle();
        args.putString("title",title);
        args.putString("bahan",bahan);
        args.putString("resto",resto);
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

    public void setMessage (String message){

        this.tag.setText(message);
    }


    @Override
    public void onClick(View v) {

        if(v==this.save){
            String tagb= this.tag.getText().toString();
            String bahanb=this.bahan.getText().toString();
            String restob=this.resto.getText().toString();
            String cara=this.cara.getText().toString();
            Person baru=new Person(tagb,restob,bahanb,cara);
            peopleList.set(posPencet,baru);
        }
    }



}
