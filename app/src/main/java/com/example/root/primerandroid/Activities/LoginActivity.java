package com.example.root.primerandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.primerandroid.R;

public class LoginActivity extends AppCompatActivity
{

    Button loginBoton, loginRegistro;
    EditText etNombreLogin, etPassLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBoton = (Button) findViewById(R.id.loginBoton);
        loginRegistro = (Button) findViewById(R.id.loginRegistro);
        etNombreLogin = (EditText) findViewById(R.id.etNombreLogin);
        etPassLogin = (EditText) findViewById(R.id.etPassLogin);

        loginBoton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(LoginActivity.this, "dIO click EN LOGIN", Toast.LENGTH_LONG).show();
            }
        });

        loginRegistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                   Toast.makeText(LoginActivity.this,"click en registro",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
