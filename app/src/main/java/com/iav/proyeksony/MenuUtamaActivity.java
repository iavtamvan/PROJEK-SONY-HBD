package com.iav.proyeksony;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.iav.proyeksony.adapter.MenuAdapter;
import com.iav.proyeksony.model.Model;
import com.iav.proyeksony.rest.ApiService;
import com.iav.proyeksony.rest.Client;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuUtamaActivity extends AppCompatActivity {

    private ArrayList<Model> models;
    private MenuAdapter menuAdapter;
    private RecyclerView rv;

    private SliderLayout mSliderSlider;
    private PagerIndicator customIndicator;
    private PagerIndicator customIndicator2;
    private LottieAnimationView lottie;
    private LinearLayout divMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
        models = new ArrayList<>();
        getSlider();
        getMenu();

    }

    private void getMenu() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getMenuUtama("read", "menu_utama")
                .enqueue(new Callback<ArrayList<Model>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                        if (response.isSuccessful()) {
                            models = response.body();
                            for (int i = 0; i < models.size(); i++) {
                                menuAdapter = new MenuAdapter(MenuUtamaActivity.this, models);
                                rv.setLayoutManager(new LinearLayoutManager(MenuUtamaActivity.this));
                                rv.setAdapter(menuAdapter);
                                rv.setHasFixedSize(true);
                                menuAdapter.notifyDataSetChanged();

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                        Toast.makeText(MenuUtamaActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getSlider() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getSlider("read", "slider")
                .enqueue(new Callback<ArrayList<Model>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                        if (response.isSuccessful()) {
                            models = response.body();
                            lottie.setVisibility(View.GONE);
                            divMain.setVisibility(View.VISIBLE);
                            for (int i = 0; i < models.size(); i++) {
                                mSliderSlider.setVisibility(View.VISIBLE);
                                customIndicator.setVisibility(View.VISIBLE);
                                customIndicator2.setVisibility(View.VISIBLE);
                                HashMap<String, String> url_maps = new HashMap<String, String>();
                                // * Get internet
                                url_maps.put(models.get(i).getKeterangan(), models.get(i).getImage_slider());


                                for (String name : url_maps.keySet()) {
                                    TextSliderView textSliderView = new TextSliderView(MenuUtamaActivity.this);
                                    // initialize a SliderLayout
                                    textSliderView
                                            .description(name)
                                            .image(url_maps.get(name))
                                            .setScaleType(BaseSliderView.ScaleType.Fit);
                                    //add your extra information
                                    textSliderView.bundle(new Bundle());
                                    textSliderView.getBundle()
                                            .putString("extra", name);

                                    mSliderSlider.addSlider(textSliderView);
                                }
                                mSliderSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
                                mSliderSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                                mSliderSlider.setCustomAnimation(new DescriptionAnimation());
                                mSliderSlider.setDuration(4000);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                        Toast.makeText(MenuUtamaActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
        mSliderSlider = findViewById(R.id.mSliderSlider);
        customIndicator = findViewById(R.id.custom_indicator);
        customIndicator2 = findViewById(R.id.custom_indicator2);
        lottie = findViewById(R.id.lottie);
        divMain = findViewById(R.id.div_main);
    }
}
