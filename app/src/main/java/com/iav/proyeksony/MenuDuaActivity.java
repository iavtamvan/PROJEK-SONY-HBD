package com.iav.proyeksony;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.iav.proyeksony.model.Model;
import com.iav.proyeksony.rest.ApiService;
import com.iav.proyeksony.rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuDuaActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dua);
        getSupportActionBar().hide();
        initView();

        getMenu();
    }

    private void getMenu() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getMenuDua("read", "menu_dua")
                .enqueue(new Callback<ArrayList<Model>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Model>> call, Throwable t) {

                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }
}
