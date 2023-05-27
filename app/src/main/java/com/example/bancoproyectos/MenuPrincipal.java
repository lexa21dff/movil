package com.example.bancoproyectos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.navigation.NavigationView;

import java.sql.SQLData;

public class MenuPrincipal extends AppCompatActivity {
    private EditText et1;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

  
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        et1= (EditText)findViewById(R.id.txt_buscador);
        


        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.perfil:
                        Intent i = new Intent(MenuPrincipal.this, Perfil.class);
                        startActivity(i);
                        return true;

                    case R.id.mis_proyectos:
                        Intent in = new Intent(MenuPrincipal.this, MisProyectos.class);
                        startActivity(in);
                        return true;

                    case R.id.equipo:
                        Intent equi = new Intent(MenuPrincipal.this, EquipoTrabajo.class);
                        startActivity(equi);
                        return true;
                    default:
                        return false;
                }
            }

        
        });

    }
    public void Buscar(View view) {
        Intent intent = new Intent(this, VisorWeb.class);
        intent.putExtra("nombresitio", et1.getText().toString());
        startActivity(intent);
    }
    private void remplaceFragment(Fragment fragment) {
        FragmentManager frgManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frgManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmenPadre, fragment);
        fragmentTransaction.commit();
    }


}