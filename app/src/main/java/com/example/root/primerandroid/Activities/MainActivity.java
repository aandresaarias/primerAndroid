package com.example.root.primerandroid.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.root.primerandroid.Fragments.FragmentLista;
import com.example.root.primerandroid.Fragments.FragmentPendientes;
import com.example.root.primerandroid.Fragments.FragmentPrincipal;
import com.example.root.primerandroid.R;

import java.security.Principal;

public class MainActivity extends AppCompatActivity
{
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FloatingActionButton fabActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBarMainActivity);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerActivityMain);
        navigationView = (NavigationView) findViewById(R.id.navigationViewActivityMain);
        fabActivityMain = (FloatingActionButton) findViewById(R.id.fabMainActivity);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                switch(menuItem.getItemId())
                {
                    case R.id.principal:
                        setFragment(0);
                        Toast.makeText(getApplicationContext(),"principal fragmento",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.pendientes:
                        setFragment(1);
                        Toast.makeText(getApplicationContext(),"pendientes",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.lista:
                        setFragment(2);
                        Toast.makeText(getApplicationContext(),"lista",Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

        android.support.v7.app.ActionBarDrawerToggle actionBarDrawerToggle =
                new android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        fabActivityMain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"click en FAB", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setFragment(int pos)
    {
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (pos)
        {
            case 0:
                FragmentPrincipal fragmentPrincipal = new FragmentPrincipal();

                transaction.replace(R.id.fragment,fragmentPrincipal);
                transaction.commit();
                break;

            case 1:
                FragmentPendientes fragmentPendientes = new FragmentPendientes();

                transaction.replace(R.id.fragment,fragmentPendientes);
                transaction.commit();
                break;

            case 2:
                FragmentLista fragmentLista = new FragmentLista();

                transaction.replace(R.id.fragment,fragmentLista);
                transaction.commit();
                break;
        }
    }


}