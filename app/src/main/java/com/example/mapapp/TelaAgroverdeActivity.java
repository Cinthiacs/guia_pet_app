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

public class TelaAgroverdeActivity extends AppCompatActivity {
    Button btn_volta;
    Button btn_saiba_mais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agroverde);

        btn_saiba_mais = findViewById(R.id.saiba_mais);
        btn_volta = findViewById(R.id.voltar);

        btn_saiba_mais.setOnClickListener(v ->{

        });


        btn_volta.setOnClickListener(v ->{
            finish();
        });

    }
}