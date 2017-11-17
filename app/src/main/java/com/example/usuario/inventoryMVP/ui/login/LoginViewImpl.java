package com.example.usuario.inventoryMVP.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.inventoryMVP.ui.Dashboard.DashBoardActivity;
import com.example.usuario.inventoryMVP.R;
import com.example.usuario.inventoryMVP.ui.base.BaseActivity;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Inicio del proyecto menu
 */

public class LoginViewImpl extends BaseActivity implements LoginView, View.OnClickListener{



    private EditText edtUser;
    private EditText edtPassword;
    private Button btnSingIn;

    private LoginPresenterImpl loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSingIn = (Button) findViewById(R.id.btnSignIn);
        btnSingIn.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
    }


    @Override
    public void onClick(View v) {
        if(v == btnSingIn)
        loginPresenter.ValidateCredentails(edtUser.getText().toString(), edtPassword.getText().toString());

        //Intent intent = new Intent(this, DashBoardActivity.class);
        //startActivity(intent);
    }

    @Override
    public void NavigateToHome() {
        Intent singIn = new Intent(LoginViewImpl.this,DashBoardActivity.class);
        startActivity(singIn);
    }

    @Override
    public void SetUserEmpyteError() {
        onError(R.string.ErrorUser);
    }

    @Override
    public void SetPasswordEmpyteError() {
        onError(R.string.ErrorPassword);
    }

    @Override
    public void SetPasswordError() {
        onError(R.string.ErrorpasswordLength);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

}
