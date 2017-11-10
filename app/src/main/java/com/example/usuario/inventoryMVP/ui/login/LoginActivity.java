package com.example.usuario.inventoryMVP.ui.login;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.usuario.inventoryMVP.DashBoardActivity;
import com.example.usuario.inventoryMVP.R;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Inicio del proyecto menu
 */

public class LoginActivity extends AppCompatActivity {

    private Button btnSingIn;
    private TextView txvSingUp;
    private LoginPresenterImpl loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnSingIn = ((Button) findViewById(R.id.btnSignIn));
        this.txvSingUp = ((TextView) findViewById(R.id.txvSignup));

        //setPaintFlags sirve para poder ponerle un UNDERLINE al testo
        this.txvSingUp.setPaintFlags(this.txvSingUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        //boten para iniciar el DashBoardActivity
        this.btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loginPresenter.ValidateCredentails("Juanma","ju");
                //Intent singIn = new Intent(LoginActivity.this, DashBoardActivity.class);
                //startActivity(singIn);
            }
        });

    }
}
