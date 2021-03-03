package com.example.tubes_p3b;

import android.content.ClipData;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tubes_p3b.Menu.Person;
import com.example.tubes_p3b.ui.Dialog.ExampleDialog;
import com.example.tubes_p3b.ui.detail.DetailFragment;
import com.example.tubes_p3b.ui.gallery.GalleryFragment;
import com.example.tubes_p3b.ui.home.HomeFragment;
import com.example.tubes_p3b.ui.slideshow.SlideshowFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import static com.example.tubes_p3b.R.id.openset;
import static com.example.tubes_p3b.ui.slideshow.SlideshowFragment.peopleList;

public class MainActivity extends AppCompatActivity implements FragmentListener{

    private AppBarConfiguration mAppBarConfiguration;
    private HomeFragment fragment1;
    private  GalleryFragment fragment3;
    private SlideshowFragment fragment2;

    private  DetailFragment fragment4;
    private FragmentManager fragmentManager;
    private PersonListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openDialog();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.exit)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);


        Person nasgor = new Person("Nasgor","Nasi, Bawang","Nasgor pak gembul","digoreng 5 menit");
        Person natelnet = new Person("Natelnet","Nasi, Telor, Kornet","Gemini" ,"digoreng dan direbus");
        Person mie = new Person("Mie Goreng","Indomie","Moes","direbus dan ditiriskan");
        Person sate = new Person("Sate","Daging Sapi, Bawang, Cabe","Bu Ngantuk","dibakar");
        Person geprek = new Person("Ayam Geprek","Ayam, Sambel, Bawang","Gembus" ,"goreng dan diberi cabai atasnya");
        Person baso= new Person("Baso","Daging, Tepung, Mie","Arjuna","daging dibentuk dan direbus" );
        Person seafood = new Person("Seafood","Udang, Bawang, Cuka, Baso, Ikan","Mandarin","direbus");
        Person babi = new Person("Babi Panggang","Daging Babi, bawang, bumbu","Lapo","dipanggang");
        Person soto = new Person("Soto","Soto, Telor, Lengkuas","Soto Ayam","dimasak bersama" );
        Person sei = new Person("Sei Sapi","Daging sapi, bawang, bumbu","Dipatiukur","dipanggang" );


        peopleList = new ArrayList<>();
        peopleList.add(nasgor);
        peopleList.add(natelnet);
        peopleList.add(mie);
        peopleList.add(sate);
        peopleList.add(sate);
        peopleList.add(geprek);
        peopleList.add(baso);
        peopleList.add(seafood);
        peopleList.add(babi);
        peopleList.add(soto);
        peopleList.add(sei);

        NavigationUI.setupWithNavController(navigationView, navController);
        this.fragment1=HomeFragment.newInstance();
        this.fragment2=SlideshowFragment.newInstance(null,null,null,null);
          this.fragment3=GalleryFragment.newInstance();
        this.fragment4= DetailFragment.newInstance(null,null,null);
        this.fragmentManager=this.getSupportFragmentManager();
        FragmentTransaction ft=this.fragmentManager.beginTransaction();



    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void changePage(int page){
        FragmentTransaction ft=this.fragmentManager.beginTransaction();
          if(page==4){

              if(this.fragment4.isAdded()){

              }
              else{
                  ft.replace(R.id.fragment_container,this.fragment4).hide(this.fragment2);
              }
              if(this.fragment2.isAdded()){
                  ft.hide(this.fragment2);
              }
        }


        ft.commit();
    }

    @Override
    public String getItemList(int page, ArrayList<Person> a,View v) {
        String name = a.get(page).getName();
         return name;
    }

    @Override
    public String getBahan(int page, ArrayList<Person> a) {

        String bahan = a.get(page).getBahan();
        return bahan;
    }

    @Override
    public String getResto(int page, ArrayList<Person> a) {

        String resto = a.get(page).getResto();
        return  resto;
    }

    @Override
    public String getcara(int page, ArrayList<Person> a) {
        String cara = a.get(page).getcara();
        return  cara;
    }


    public void openDialog(){
        ExampleDialog exampleDialog=new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }




}