package com.example.usuario.inventorydb.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginPresenter {

    void ValidateCredentails(String user,String password);
    void onDestroy();

}