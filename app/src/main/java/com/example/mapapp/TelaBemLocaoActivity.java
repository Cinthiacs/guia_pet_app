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

public class TelaBemLocaoActivity extends AppCompatActivity {
    Button btn_volta;
    Button btn_saiba_maisbemlocao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bem_locao);

        btn_saiba_maisbemlocao = findViewById(R.id.saiba_mais_bemlocao);
        btn_volta = findViewById(R.id.voltar);

        btn_saiba_maisbemlocao.setOnClickListener(v ->{
            Intent intent = new Intent(TelaBemLocaoActivity.this,TelaSaibaMaisBemLocaoActivity.class);
            startActivity(intent);
        });


        btn_volta.setOnClickListener(v ->{
            finish();
        });

    }
}