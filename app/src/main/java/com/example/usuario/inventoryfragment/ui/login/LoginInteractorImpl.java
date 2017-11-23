package com.example.usuario.inventoryfragment.ui.login;

import com.example.usuario.inventoryfragment.data.repository.UserRepository;
import com.example.usuario.inventoryfragment.utils.CommonUtils;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void ValidateCredentails(String user, String password, OnLoginFinishedListener listener) {
        //si el password es vacio
        if (password.isEmpty())
            listener.OnPasswordEmpyteError();
        else
            if (user.isEmpty())
            listener.OnUserEmpyteError();
        else
            if (!CommonUtils.isPasswordvalid(password))
            listener.OnPasswordError();
        else
            if (UserRepository.getInstance().validateCredentials(user, password))
            listener.OnSuccess();
    }
}
