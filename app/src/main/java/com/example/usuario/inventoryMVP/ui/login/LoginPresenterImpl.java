package com.example.usuario.inventoryMVP.ui.login;

import android.widget.ListView;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginInteractorImpl loginInteractor;
    private LoginActivity loginView;

    public LoginPresenterImpl(LoginActivity loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void ValidateCredentails(String user, String password) {
        loginInteractor.ValidateCredentails(user, password, this);
    }


    @Override
    public void onDestroy() {
        loginView = null;
        loginInteractor = null;
    }

    public void OnSuccess(){
        loginView.NavigateToHome();
    }

    @Override
    public void OnUserEmpyteError() {
        loginView.SetUserEmpyteError();
    }

    @Override
    public void OnPasswordEmpyteError() {
        loginView.SetPasswordEmpyteError();
    }

    @Override
    public void OnPasswordError() {
        loginView.SetPasswordError();
    }


}
