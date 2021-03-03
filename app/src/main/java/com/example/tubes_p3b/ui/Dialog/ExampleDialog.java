package com.example.tubes_p3b.ui.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.tubes_p3b.FragmentListener;
import com.example.tubes_p3b.InterDisplay;
import com.example.tubes_p3b.Menu.Person;
import com.example.tubes_p3b.R;
import com.example.tubes_p3b.Storage;
import com.example.tubes_p3b.ui.slideshow.SlideshowFragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.tubes_p3b.ui.slideshow.SlideshowFragment.peopleList;

public class ExampleDialog extends AppCompatDialogFragment implements InterDisplay {

    private FragmentListener listener;
    private EditText editTextU;
    private  EditText editpw;
    private  EditText editbahan;

    private  EditText cara;
    private SlideshowFragment slide;
    private Person person;
    private Storage pencatat;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);

        editpw=view.findViewById(R.id.edit_password);
        editTextU=view.findViewById(R.id.edit_username);
        editbahan=view.findViewById(R.id.edit_bahan);
        cara=view.findViewById(R.id.cara);


        builder.setView(view).setTitle("Tambah Makanan").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String username=editTextU.getText().toString();
                String password=editpw.getText().toString();
                String bahan=editbahan.getText().toString();
                String caramem=cara.getText().toString();
                Person p=new Person(username,password,bahan,caramem);
                SlideshowFragment.add(p,peopleList);
                String bar =editTextU.getText().toString();
                String har = editpw.getText().toString();
                String ket = editbahan.getText().toString();
                FileOutputStream fos = null;
                File file;
                try {
                    file = new File( "m04.txt");
                    fos = new FileOutputStream(file);
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    fos.write(bar.getBytes());
                    fos.write(har.getBytes());
                    fos.write(ket.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(fos !=null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
    }
        });


       this.pencatat=new Storage(getContext());
    return builder.create();

    }
    @Override
    public void onPause() {
        super.onPause();
        this.pencatat.saveBarang(editTextU.getText().toString());
        this.pencatat.saveKeterangan(editpw.getText().toString());
        this.pencatat.saveHarga(editbahan.getText().toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        this.editTextU.setText(this.pencatat.getBarang());
        this.editpw.setText(this.pencatat.getKeterangan());
        this.editbahan.setText(this.pencatat.getHarga());
    }

}
