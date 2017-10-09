package com.example.usuario.inventory;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button btnSingIn;
    private TextView txvSingUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnSingIn = ((Button)findViewById(R.id.btnSignIn));
        this.txvSingUp = ((TextView)findViewById(R.id.txvSignup));


        this.txvSingUp.setPaintFlags(this.txvSingUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        this.btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singIn = new Intent(LoginActivity.this,DashBoardActivity.class);
                startActivity(singIn);
            }
        });

    }
}
