package com.iav.proyeksony;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.iav.proyeksony.model.Model;
import com.iav.proyeksony.rest.ApiService;
import com.iav.proyeksony.rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {

    private ImageView ivSplash;
    private TextView tvKeteranganSplash;

    private ArrayList<Model> models;
    private LottieAnimationView lottie;
    private FrameLayout frameSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        initView();

        models = new ArrayList<>();
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getSplashScreen("read", "splash")
                .enqueue(new Callback<ArrayList<Model>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                        if (response.isSuccessful()) {
                            models = response.body();
                            lottie.setVisibility(View.GONE);
                            frameSplash.setVisibility(View.VISIBLE);
                            for (int i = 0; i < models.size(); i++) {
                                tvKeteranganSplash.setText(models.get(i).getKeterangan());
                                Glide.with(SplashScreen.this).load(models.get(i).getImage()).into(ivSplash);


                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        finishAffinity();
                                        startActivity(new Intent(getApplicationContext(), MenuUtamaActivity.class));
                                    }
                                }, 2000);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                        Toast.makeText(SplashScreen.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private void initView() {
        ivSplash = findViewById(R.id.iv_splash);
        tvKeteranganSplash = findViewById(R.id.tv_keterangan_splash);
        lottie = findViewById(R.id.lottie);
        frameSplash = findViewById(R.id.frame_splash);
    }
}
