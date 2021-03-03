package com.example.tubes_p3b.ui.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes_p3b.FragmentListener;
import com.example.tubes_p3b.MainActivity;
import com.example.tubes_p3b.Menu.Person;
import com.example.tubes_p3b.PersonListAdapter;
import com.example.tubes_p3b.R;
import com.example.tubes_p3b.ui.detail.DetailFragment;

import java.util.ArrayList;

import static com.example.tubes_p3b.ui.detail.DetailFragment.posPencet;
import static com.example.tubes_p3b.ui.gallery.GalleryFragment.changeColor;

public class SlideshowFragment extends Fragment  implements AdapterView.OnItemClickListener{

    private SlideshowViewModel slideshowViewModel;

    private FragmentListener listener;

    private DetailFragment fragment4;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static ArrayList<Person> peopleList;
   public static PersonListAdapter adapter;
    private int x;
    private TextView settag;
    public static ListView mListView;
    private FragmentManager fragmentManager;
    public static  String nama;

    public static  String bahan;

    public static  String resto;

    public static String cara;

    public static EditText filter;
    private View root;

    public SlideshowFragment (){

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);

        if(changeColor==false) {
            this.root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        }
        else{
            this.root = inflater.inflate(R.layout.fragment_slideshow, container, false);
            root.setBackgroundColor(Color.DKGRAY);
        }
        this.mListView = root.findViewById(R.id.listView);
       mListView.setOnItemClickListener(this);
        this.adapter = new PersonListAdapter(getContext(), R.layout.adapter_view_layout, peopleList);
        this.filter=root.findViewById(R.id.filter);


        adapter.notifyDataSetChanged();
        mListView.setAdapter(adapter);

       filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // (SlideshowFragment.this).adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        return root;
    }



    public static SlideshowFragment newInstance (String username,String bahan,String password,String cara){
        SlideshowFragment fragment=new SlideshowFragment();
        Person ew=new Person(username,bahan,password,cara);
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

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {

        this.nama=this.listener.getItemList(position,this.peopleList,v);

        this.bahan=this.listener.getBahan(position,this.peopleList);

        this.resto=this.listener.getResto(position,this.peopleList);
        this.cara=this.listener.getcara(position,this.peopleList);
        posPencet=position;
      Navigation.findNavController(v).navigate(R.id.detailmakanan);

        mListView.setAdapter(adapter);

}

public static void add(Person p, ArrayList<Person> peopleList){
       peopleList.add(p);
    mListView.setAdapter(adapter);
}






}