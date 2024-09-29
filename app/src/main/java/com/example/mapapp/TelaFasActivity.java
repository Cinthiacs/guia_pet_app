package com.example.mapapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class TelaFasActivity extends AppCompatActivity {

    Button btn_volta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_fas);

        btn_volta = findViewById(R.id.voltar);

        btn_volta.setOnClickListener(v ->{
            finish();
        });

    }
}