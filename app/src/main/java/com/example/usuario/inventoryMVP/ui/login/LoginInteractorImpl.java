package com.example.usuario.inventoryMVP.ui.login;

import net.bytebuddy.implementation.bind.annotation.Empty;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void ValidateCredentails(String user, String password, OnLoginFinishedListener listener) {
        //si el password es vacio
        if (password.isEmpty())
            listener.OnPasswordEmpyteError();
        else if (user.isEmpty())
            listener.OnPasswordError();
        else if (password.isEmpty())
            listener.OnPasswordError();
        else
            listener.OnSuccess();
    }
}
