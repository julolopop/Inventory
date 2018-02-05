package com.example.usuario.inventoryprovaider.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.usuario.inventoryprovaider.InventoryApplication;
import com.example.usuario.inventoryprovaider.utils.AppConstants;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferenceshelper implements Preferenceshelper {


    /**
     * 1 .
     */
    private static final String PREF_KEY_CURRENT_USER_ID = "pref_key_current_user_id";
    private static final String PREF_KEY_CURRENT_USER_NAME = "pref_key_current_user_name";
    private static final String PREF_KEY_CURRENT_USER_PASSWORD = "pref_key_current_user_password";
    private static final String PREF_KEY_CURRENT_USER_REMEMBER = "pref_key_current_user_remember";
    private static final String TAG = "AppPreferenceshelper";
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    /**
     * 2.
      */
    private final SharedPreferences preferences;
    private static AppPreferenceshelper intence;

    private AppPreferenceshelper(){
        this.preferences = InventoryApplication.getContext().getSharedPreferences(AppConstants.PREF_NAME,Context.MODE_PRIVATE);
        //        this.preferences = InventoryApplication.getContext().getDefaultSharedPreferences(new InventoryApplication());
        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Log.i(TAG,"onSharedPreferenceChanged  "+key);
            }
        };
    }


    public static   AppPreferenceshelper getIntence(){
        if(intence==null)
            intence = new AppPreferenceshelper();
        return intence;
    }

    public long getCurrentUserId(){
        long id = preferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return id;
    }

    public String getCurrentUserName(){
        String name = preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }
    public String getCurrentUserPassword(){
        String password = preferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
        return password;
    }
    public boolean getCurrentUserremember(){
        boolean remember = preferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
        return remember;
    }
//------------
    public void setCurrentUserId(long id){
        preferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();

    }

    public void setCurrentUserName(String name){
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, name).apply();

    }
    public void setCurrentUserPassword(String password){
        preferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD, password).apply();

    }
    public void setCurrentUserremember(boolean remember){
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER, remember).apply();

    }


    @Override
    public void onSharedPreferenceChanged() {

    }
}
