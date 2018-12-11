package com.example.root.primerandroid.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.primerandroid.R;

public class RegistrarActivity extends AppCompatActivity
{

    FloatingActionButton fabRegistrar;
    Button botonRegistrar;
    EditText etNombreRegistro, etPassRegristo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        fabRegistrar = (FloatingActionButton) findViewById(R.id.fabRegistrar);
        botonRegistrar = (Button) findViewById(R.id.btnRegistrar);
        etNombreRegistro = (EditText) findViewById(R.id.etNombreRegistrar);
        etPassRegristo = (EditText) findViewById(R.id.etPassRegistrar);

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
                String registroNombre = etNombreRegistro.getText().toString();
                String registroPass = etPassRegristo.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
                SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
                sharedEditor.putString("usuario", registroNombre);
                sharedEditor.putString("pass", registroPass);
                sharedEditor.commit();

                Toast.makeText(RegistrarActivity.this, registroNombre + " guardado y pass " + registroPass + " tambien",Toast.LENGTH_SHORT).show();

                etNombreRegistro.setText("");
                etPassRegristo.setText("");

            }
        });
    }
}
