package com.example.usuario.inventory;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;


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
