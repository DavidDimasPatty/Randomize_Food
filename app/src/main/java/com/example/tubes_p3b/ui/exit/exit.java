package com.example.tubes_p3b.ui.exit;

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
import com.example.tubes_p3b.ui.gallery.GalleryViewModel;
import com.example.tubes_p3b.ui.home.HomeViewModel;
import com.example.tubes_p3b.ui.slideshow.SlideshowFragment;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

import static com.example.tubes_p3b.ui.gallery.GalleryFragment.changeColor;


    public class exit extends Fragment {

        private exitModel exitModell;


        public View onCreateView(@NonNull LayoutInflater inflater,
                                    ViewGroup container, Bundle savedInstanceState) {
            android.os.Process.killProcess(android.os.Process.myPid());
             return null;
        }
    }


