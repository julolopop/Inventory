package com.example.usuario.inventoryfragment;

import android.app.Application;
import android.content.Context;

import com.example.usuario.inventoryfragment.data.prefs.AppPreferenceshelper;

/**
 * Created by usuario on 4/12/17.
 */

public class InventoryApplication extends Application {
    private AppPreferenceshelper AppPreferencesHelper;
    private static InventoryApplication Context;


    public InventoryApplication() {
        Context = this;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        AppPreferencesHelper = AppPreferenceshelper.getIntence();
    }


    public AppPreferenceshelper getAppPreferencesHelper() {
        return AppPreferencesHelper;
    }

    public static Context getContext() {
        return Context;
    }
}
