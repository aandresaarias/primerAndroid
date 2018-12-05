package com.example.root.primerandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.primerandroid.R;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textUno);
        boton = (Button) findViewById(R.id.boton);


        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               textView.setText("nuevo texto");
            }
        });
    }
}
