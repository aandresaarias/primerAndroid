package com.example.root.primerandroid.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        SharedPreferences sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
        sharedEditor.putString("usuario", "afas");
        sharedEditor.putString("pass", "afas");
        sharedEditor.commit();

        loginBoton = (Button) findViewById(R.id.loginBoton);
        loginRegistro = (Button) findViewById(R.id.loginRegistro);
        etNombreLogin = (EditText) findViewById(R.id.etNombreLogin);
        etPassLogin = (EditText) findViewById(R.id.etPassLogin);

        loginBoton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(LoginActivity.this, "dIO click EN LOGIN", Toast.LENGTH_LONG).show();
                String usuario = etNombreLogin.getText().toString();
                String contrasena = etPassLogin.getText().toString();

                SharedPreferences sharedLogin = getSharedPreferences("usuarios", Context.MODE_PRIVATE);

                if (usuario.equals(sharedLogin.getString("usuario","x")))
                {
                    if (contrasena.equals(sharedLogin.getString("pass","y")))
                    {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                        else
                            {
                                Toast.makeText(LoginActivity.this,"contraseña invalida",Toast.LENGTH_SHORT).show();
                            }
                }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"usuario invalido",Toast.LENGTH_LONG).show();
                    }

            }
        });

        loginRegistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                   Intent intent = new Intent(LoginActivity.this, RegistrarActivity.class);
                   startActivity(intent);
            }
        });
    }
}
