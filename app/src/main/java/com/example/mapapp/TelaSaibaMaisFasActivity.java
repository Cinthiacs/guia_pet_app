package com.example.mapapp;

import androidx.core.graphics.Insets;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Handler;
import android.widget.Button;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class TelaSaibaMaisFasActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CustomPagerAdapter mCustomPagerAdapter;

    int[] mResources = {
            R.drawable.fas_img1,
            R.drawable.fas_img2,
            R.drawable.fas_img3,
    };

    Button btnAbreMapa,btnAbreSite, btnTelefonar;

    private Handler handler = new Handler();
    private int currentPage = 0;

    private Runnable pageSwitcher = new Runnable(){
    @Override
    public void run() {
        if (currentPage == mResources.length) {
            currentPage = 0;
        }
        mViewPager.setCurrentItem(currentPage++, true);
        handler.postDelayed(this, 3000);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saiba_mais_fas);
        mViewPager = findViewById(R.id.pager);
        mCustomPagerAdapter = new CustomPagerAdapter(this, mResources);
        handler.postDelayed(pageSwitcher, 3000);
        mViewPager.setAdapter(mCustomPagerAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_fas), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAbreMapa = findViewById(R.id.btn_mapa);
        btnAbreSite = findViewById(R.id.btn_abre_site);
        btnTelefonar = findViewById(R.id.btn_telefonar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(pageSwitcher);
    }
}
