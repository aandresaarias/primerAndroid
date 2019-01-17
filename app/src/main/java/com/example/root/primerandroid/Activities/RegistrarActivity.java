package com.example.root.primerandroid.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.primerandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrarActivity extends AppCompatActivity
{

    FloatingActionButton fabRegistrar;
    Button botonRegistrar;
    EditText etNombreRegistro, etPassRegristo;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        fabRegistrar = (FloatingActionButton) findViewById(R.id.fabRegistrar);
        botonRegistrar = (Button) findViewById(R.id.btnRegistrar);
        etNombreRegistro = (EditText) findViewById(R.id.etNombreRegistrar);
        etPassRegristo = (EditText) findViewById(R.id.etPassRegistrar);
        auth = FirebaseAuth.getInstance();

        fabRegistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (RegistrarActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        botonRegistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String registroEmail = etNombreRegistro.getText().toString();
                String registroPass = etPassRegristo.getText().toString();

                if(TextUtils.isEmpty(registroEmail))
                {
                    Toast.makeText(RegistrarActivity.this, "Favor ingresar Email",Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(registroPass))
                {
                    Toast.makeText(RegistrarActivity.this, "Contraseña no puede estar en blanco",Toast.LENGTH_SHORT).show();
                }

                auth.createUserWithEmailAndPassword(registroEmail,registroPass).addOnCompleteListener(RegistrarActivity.this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        Toast.makeText(RegistrarActivity.this, etNombreRegistro + "registrado",Toast.LENGTH_SHORT).show();

                        if(!task.isSuccessful())
                        {
                            Toast.makeText(RegistrarActivity.this, "Hubo un problema",Toast.LENGTH_LONG).show();
                        }
                        else
                            {
                                Intent intent = new Intent(RegistrarActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                    }
                });

                etNombreRegistro.setText("");
                etPassRegristo.setText("");

            }
        });
    }
}
