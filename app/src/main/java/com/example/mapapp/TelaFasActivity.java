package com.example.mapapp;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class TelaFasActivity extends AppCompatActivity {
    Button btn_volta;
    Button btn_saiba_maisfas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_fas);

        btn_saiba_maisfas = findViewById(R.id.saiba_maisfas);
        btn_volta = findViewById(R.id.voltar);

        btn_saiba_maisfas.setOnClickListener(v ->{
            Intent intent = new Intent(TelaFasActivity.this,TelaSaibaMaisFasActivity.class);
            startActivity(intent);
        });

        btn_volta.setOnClickListener(v ->{
            finish();
        });

    }
}