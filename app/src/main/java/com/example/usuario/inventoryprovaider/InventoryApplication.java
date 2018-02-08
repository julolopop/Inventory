package com.example.usuario.inventoryprovaider;

import android.app.Application;
import android.content.Context;
import android.provider.BaseColumns;

import com.example.usuario.inventoryprovaider.data.prefs.AppPreferenceshelper;
import com.example.usuario.inventoryprovaider.ui.base.BaseActivity;

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
//      InventoryOpenHelper.newInstance().crear(InventoryOpenHelper.newInstance().getWritableDatabase());
    }


    public AppPreferenceshelper getAppPreferencesHelper() {
        return AppPreferencesHelper;
    }

    public static Context getContext() {
        return Context;
    }


}
