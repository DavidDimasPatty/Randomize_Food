package com.example.tubes_p3b;

import android.content.Context;
import android.content.SharedPreferences;

public class Storage {
    protected SharedPreferences sharedPref;
    protected final static String NAMA_SHARED_PREF="sp_nilai_display";
    protected final static  String KEY_BARANG="BARANG";
    protected final static  String KEY_HARGA="HARGA";
    protected final static  String KEY_KETERANGAN="KETERANGAN";



    public Storage(Context context){
        this.sharedPref=context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveBarang(String barang){
        SharedPreferences.Editor editor=this.sharedPref.edit();
        editor.putString(KEY_BARANG,barang);
        editor.commit();
    }

    public  String getBarang(){
        return sharedPref.getString(KEY_BARANG,"");
    }

    public void saveKeterangan(String keterangan){
        SharedPreferences.Editor editor=this.sharedPref.edit();
        editor.putString(KEY_KETERANGAN,keterangan);
        editor.commit();
    }

    public  String getKeterangan(){
        return sharedPref.getString(KEY_KETERANGAN,"");
    }

    public void saveHarga(String harga){
        SharedPreferences.Editor editor=this.sharedPref.edit();
        editor.putString(KEY_HARGA,harga);
        editor.commit();
    }

    public  String getHarga(){
        return sharedPref.getString(KEY_HARGA,"");
    }
}
