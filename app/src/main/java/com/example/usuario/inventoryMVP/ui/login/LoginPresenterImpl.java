package com.example.usuario.inventoryMVP.ui.login;

import android.widget.ListView;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.OnLoginFinishedListener{
    private LoginInteractorImpl loginInteractor;
    private LoginViewImpl loginView;

    public LoginPresenterImpl(LoginViewImpl loginView, LoginInteractorImpl loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void ValidateCredentails(String user, String password) {
        loginInteractor.ValidateCredentails(user,password,this);
    }

    @Override
    public void OnUserEmpyteError() {
        loginView.SetUserEmpyteError();
    }

    @Override
    public void OnPasswordEmpyteError() {

    }

    @Override
    public void OnPasswordError() {

    }
}
