package com.example.usuario.inventoryfragment.data.prefs;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.usuario.inventoryfragment.ui.inventory.InventoryActivity;

/**
 * Created by usuario on 4/12/17.
 */

public class InventoryApplication extends Application {
    private AppPreferenceshelper appPreferenceshelper;

    public InventoryApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferenceshelper= AppPreferenceshelper.getIntence();

    }


    public AppPreferenceshelper getAppPrefencesHelper() {
        return appPreferenceshelper;
    }

    public static PreferenceManager getContext() {
        return getContext();
    }
}
