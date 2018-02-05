package com.example.usuario.inventoryprovaider.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginInteractor {
    void ValidateCredentails(String user, String password, LoginInteractor.OnLoginFinishedListener listener);

    interface OnLoginFinishedListener {
        void OnUserEmpyteError();

        void OnPasswordEmpyteError();

        void OnPasswordError();
        void OnSuccess();
    }
}
