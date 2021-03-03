package com.example.tubes_p3b;

import android.view.View;

import com.example.tubes_p3b.Menu.Person;

import java.util.ArrayList;

public interface FragmentListener {
    void changePage(int page);
    String getItemList(int page, ArrayList<Person> a, View v);
    String getBahan(int page, ArrayList<Person> a);
    String getResto(int page, ArrayList<Person> a);
    String getcara(int page, ArrayList<Person> a);
}
