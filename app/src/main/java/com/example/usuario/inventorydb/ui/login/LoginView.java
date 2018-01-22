package com.example.usuario.inventorydb.ui.login;

/**
 * Contiene los métodos necesarios para la comunicación del presente con lo visto
 */

public interface LoginView {

    void NavigateToHome();
    void SetUserEmpyteError();
    void SetPasswordEmpyteError();
    void SetPasswordError();
}