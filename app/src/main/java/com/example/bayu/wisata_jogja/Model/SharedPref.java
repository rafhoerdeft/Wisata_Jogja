package com.example.bayu.wisata_jogja.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    public static final String SP_WisataJgja_APP = "spspWisataJogjaApp";

    public static final String SP_IDMEMBER = "spIdMember";
    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_STATUS = "spStatus";
    public static final String SP_NOHP = "spNoHp";
    public static final String SP_password = "spPassword";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    public SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPref(Context context){
        sp = context.getSharedPreferences(SP_WisataJgja_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public String getSpStatus() {
        return sp.getString(SP_STATUS,"");
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
