package com.example.mapapp;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Handler;
import android.widget.Button;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class TelaSaibaMaisBemLocaoActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CustomPagerAdapter mCustomPagerAdapter;

    int[] mResources = {
            R.drawable.bemlocao_img1,
            R.drawable.bemlocao_img2,
            R.drawable.bemlocao_img3,
    };

    Button btnAbreMapa,btnAbreSite, btnTelefonar;

    private Handler handler = new Handler();
    private int currentPage = 0;

    private Runnable pageSwitcher = new Runnable() {
        @Override
        public void run() {
            if (currentPage == mResources.length) {
                currentPage = 0;
            }

            mViewPager.setCurrentItem(currentPage++, true);
            handler.postDelayed(this, 3000);
            mViewPager.setAdapter(mCustomPagerAdapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_saiba_mais_bem_locao);
        mViewPager = findViewById(R.id.pager);
        mCustomPagerAdapter = new CustomPagerAdapter(this, mResources);
        handler.postDelayed(pageSwitcher, 3000);
        mViewPager.setAdapter(mCustomPagerAdapter);

        btnAbreMapa = (Button)findViewById(R.id.btn_mapa);
        btnAbreSite =(Button)findViewById(R.id.btn_abre_site);
        btnTelefonar = (Button)findViewById(R.id.btn_telefonar);

        btnAbreMapa.setOnClickListener(v -> {
            Uri uri =
                    Uri.parse("geo:0,0?q=Av.+Gen+Carneiro+131");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapIntent);
        });

        btnAbreSite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.bemlocaopet.com.br/quem-somos");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        btnTelefonar.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:1599999999");
            Intent intent = new Intent(Intent.ACTION_CALL,uri);
            int permissionCheck =
                    ContextCompat.checkSelfPermission(
                            this, android.Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.
                        requestPermissions(this,
                                new String[]{
                                        android.Manifest.permission.CALL_PHONE},1);
            } else {
                startActivity(intent);
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_bem_locao), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(pageSwitcher);
    }
}
