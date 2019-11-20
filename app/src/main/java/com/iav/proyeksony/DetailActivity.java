package com.iav.proyeksony;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.iav.proyeksony.helper.Config;
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivBackdropDetail;
    private YouTubePlayerView youtubePlayerView;

    private String nama_menu;
    private String image_menu;
    private String keterangan_menu;
    private String id_video_menu;
    private String keterangan_video;
    private String jenis_video;
    private String nama_video;
    private String publikasi_video;
    private String untuk_siapa_video;
    private TextView tvUntukSiapa;
    private TextView tvKeteranganVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nama_menu = getIntent().getStringExtra(Config.BUNDLE_NAMA_MENU);
        image_menu = getIntent().getStringExtra(Config.BUNDLE_IMAGE_MENU);
        keterangan_video = getIntent().getStringExtra(Config.BUNDLE_KETERANGAN_VIDEO);
        id_video_menu = getIntent().getStringExtra(Config.BUNDLE_ID_VIDEO_MENU);
        jenis_video = getIntent().getStringExtra(Config.BUNDLE_JENIS_VIDEO);
        nama_video = getIntent().getStringExtra(Config.BUNDLE_NAMA_VIDEO);
        publikasi_video = getIntent().getStringExtra(Config.BUNDLE_PUBLIKASI_VIDEO);
        untuk_siapa_video = getIntent().getStringExtra(Config.BUNDLE_UNTUK_SIAPA_VIDEO);

        getSupportActionBar().setTitle(nama_menu);
        Glide.with(DetailActivity.this).load(image_menu).into(ivBackdropDetail);
        tvUntukSiapa.setText(untuk_siapa_video);
        tvKeteranganVideo.setText(keterangan_video);

//        youtubePlayerView.toggleFullScreen();
//        youtubePlayerView.isFullScreen();
        youtubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(final YouTubePlayer youTubePlayer) {
                youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        youTubePlayer.loadVideo(id_video_menu, 0);
                    }
                });
            }
        }, true);


    }

    @Override
    protected void onStop() {
        super.onStop();
        youtubePlayerView.release();
    }

    private void initView() {
        ivBackdropDetail = findViewById(R.id.iv_backdrop_detail);
        youtubePlayerView = findViewById(R.id.youtube_player_view);
        tvUntukSiapa = findViewById(R.id.tv_untuk_siapa);
        tvKeteranganVideo = findViewById(R.id.tv_keterangan_video);
    }
}
