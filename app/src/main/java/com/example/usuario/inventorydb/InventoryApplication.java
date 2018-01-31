package com.example.usuario.inventorydb;

import android.app.Application;
import android.content.Context;

import com.example.usuario.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventorydb.data.prefs.AppPreferenceshelper;

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
        //InventoryOpenHelper.newInstance().getWritableDatabase();

    }


    public AppPreferenceshelper getAppPreferencesHelper() {
        return AppPreferencesHelper;
    }

    public static Context getContext() {
        return Context;
    }
}
