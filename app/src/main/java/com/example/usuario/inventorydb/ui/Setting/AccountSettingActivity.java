package com.example.usuario.inventorydb.ui.Setting;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.usuario.inventorydb.R;

/**
 * Created by usuario on 2/11/17.
 */

public class AccountSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_setting);
    }
}
