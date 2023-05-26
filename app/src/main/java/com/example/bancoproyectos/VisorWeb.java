package com.example.bancoproyectos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class VisorWeb extends AppCompatActivity {

    WebView visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_web);

        visor = (WebView) findViewById(R.id.visor1);

        String URL =getIntent().getStringExtra("nombresitio");
        visor.setWebViewClient(new WebViewClient());
        visor.loadUrl("htto://"+ URL);
    }

    public void Regresar(View view){
        Intent intent= new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}