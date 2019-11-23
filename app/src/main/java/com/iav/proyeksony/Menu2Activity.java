package com.iav.proyeksony;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.iav.proyeksony.helper.Config;
import com.iav.proyeksony.model.Model;
import com.iav.proyeksony.rest.ApiService;
import com.iav.proyeksony.rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Menu2Activity extends AppCompatActivity {

    private LottieAnimationView lottie;
    private ScrollView svDiv;
    private LinearLayout div;

    private String savingMenus;

    private ArrayList<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_duas);
        getSupportActionBar().hide();
        initView();
        models = new ArrayList<>();
        savingMenus = getIntent().getStringExtra(Config.BUNDLE_NAMA_MENU);
        getMenu();
    }

    private void getMenu() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getMenuDua("read", "menu_dua")
                .enqueue(new Callback<ArrayList<Model>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                        models = response.body();
                        for (final Model s : models) {
                            if (s.getRelasi_menu() != null && s.getRelasi_menu().contains(savingMenus)) {

                                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View view = layoutInflater.inflate(R.layout.list_menu_dua, null);

                                TextView tvMenuKeterangan;
                                TextView tvMenu;
                                ImageView ivMenu;
                                CardView cvklik;

                                cvklik = view.findViewById(R.id.cvklik);
                                ivMenu = view.findViewById(R.id.iv_Menu);
                                tvMenu = view.findViewById(R.id.tv_menu);
                                tvMenuKeterangan = view.findViewById(R.id.tv_menu_keterangan);

                                lottie.setVisibility(View.GONE);
                                svDiv.setVisibility(View.VISIBLE);

                                Glide.with(Menu2Activity.this).load(s.getImage_menu()).into(ivMenu);
                                tvMenu.setText(s.getNama_menu());
                                tvMenuKeterangan.setText(s.getKeterangan_menu());
                                cvklik.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
//                                        Toast.makeText(Menu2Activity.this, "suksess", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(new Intent(Menu2Activity.this, Menu3Activity.class));
                                        intent.putExtra(Config.BUNDLE_NAMA_MENU, s.getNama_menu());
//                                        intent.putExtra(Config.BUNDLE_IMAGE_MENU, s.getImage_menu());
//                                        intent.putExtra(Config.BUNDLE_KETERANGAN_MENU, s.getKeterangan_menu());
//                                        intent.putExtra(Config.BUNDLE_ID_VIDEO_MENU, s.getId_video());
//                                        intent.putExtra(Config.BUNDLE_JENIS_VIDEO, s.getJenis_video());
//                                        intent.putExtra(Config.BUNDLE_NAMA_VIDEO, s.getNama_video());
//                                        intent.putExtra(Config.BUNDLE_PUBLIKASI_VIDEO, s.getPublikasi_video());
//                                        intent.putExtra(Config.BUNDLE_UNTUK_SIAPA_VIDEO, s.getUntuk_siapa());

                                        startActivity(intent);
                                    }
                                });

                                div.addView(view);

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                        Toast.makeText(Menu2Activity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        lottie = findViewById(R.id.lottie);
        svDiv = findViewById(R.id.sv_div);
        div = findViewById(R.id.div);
    }
}
