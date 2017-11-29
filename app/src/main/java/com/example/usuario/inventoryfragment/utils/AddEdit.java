package com.example.usuario.inventoryfragment.utils;

import android.widget.EditText;

/**
 * Created by usuario on 29/11/17.
 */

public class AddEdit {
    public static final int ADD_MODE  =0;
    public static final int EDIT_MODE =1;

    private int mode;

    public AddEdit() {
        this.mode = ADD_MODE;
    }

    public AddEdit(int mode) {
        if(mode < ADD_MODE || mode > EDIT_MODE)
            throw  new IllegalArgumentException("Invalid addEditMode : " + mode);

        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
