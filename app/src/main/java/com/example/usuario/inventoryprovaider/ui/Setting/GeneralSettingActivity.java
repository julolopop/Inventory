package com.example.usuario.inventoryprovaider.ui.Setting;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import com.example.usuario.inventoryprovaider.R;


/**
 * Created by usuario on 2/11/17.
 */

public class GeneralSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_setting);
    }
}
