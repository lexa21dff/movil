package com.example.bancoproyectos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLData;

public class MenuPrincipal extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        et1= (EditText)findViewById(R.id.txt_buscador);

    }

    public void Buscar(View view){
        Intent intent = new Intent(this, VisorWeb.class);
        intent.putExtra("nombresitio", et1.getText().toString());
        startActivity(intent);
    }

}