package com.example.mapapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn_abre_tela_fas,btn_abre_tela_agroverde, btn_abre_tela_bemlocao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn_abre_tela_fas = (Button) findViewById(R.id.abre_tela_fas);


        btn_abre_tela_fas.setOnClickListener(c ->{
            Intent intent = new Intent(MainActivity.this,TelaFasActivity.class);
            startActivity(intent);
        });

    }
}