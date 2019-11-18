package com.iav.proyeksony.model;

import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("image")
    private String image;

    @SerializedName("keterangan")
    private String keterangan;

    @SerializedName("image_slider")
    private String image_slider;

    @SerializedName("nama_menu")
    private String nama_menu;

    @SerializedName("keterangan_menu")
    private String keterangan_menu;

    @SerializedName("jenis_menu")
    private String jenis_menu;

    @SerializedName("image_menu")
    private String image_menu;

    @SerializedName("relasi_menu")
    private String relasi_menu;

    @SerializedName("id_video")
    private String id_video;

    @SerializedName("keterangan_video")
    private String keterangan_video;

    @SerializedName("jenis_video")
    private String jenis_video;

    @SerializedName("nama_video")
    private String nama_video;

    @SerializedName("publikasi_video")
    private String publikasi_video;

    @SerializedName("untuk_siapa")
    private String untuk_siapa;

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getKeterangan_menu() {
        return keterangan_menu;
    }

    public void setKeterangan_menu(String keterangan_menu) {
        this.keterangan_menu = keterangan_menu;
    }

    public String getJenis_menu() {
        return jenis_menu;
    }

    public void setJenis_menu(String jenis_menu) {
        this.jenis_menu = jenis_menu;
    }

    public String getImage_menu() {
        return image_menu;
    }

    public void setImage_menu(String image_menu) {
        this.image_menu = image_menu;
    }

    public String getRelasi_menu() {
        return relasi_menu;
    }

    public void setRelasi_menu(String relasi_menu) {
        this.relasi_menu = relasi_menu;
    }

    public String getId_video() {
        return id_video;
    }

    public void setId_video(String id_video) {
        this.id_video = id_video;
    }

    public String getKeterangan_video() {
        return keterangan_video;
    }

    public void setKeterangan_video(String keterangan_video) {
        this.keterangan_video = keterangan_video;
    }

    public String getJenis_video() {
        return jenis_video;
    }

    public void setJenis_video(String jenis_video) {
        this.jenis_video = jenis_video;
    }

    public String getNama_video() {
        return nama_video;
    }

    public void setNama_video(String nama_video) {
        this.nama_video = nama_video;
    }

    public String getPublikasi_video() {
        return publikasi_video;
    }

    public void setPublikasi_video(String publikasi_video) {
        this.publikasi_video = publikasi_video;
    }

    public String getUntuk_siapa() {
        return untuk_siapa;
    }

    public void setUntuk_siapa(String untuk_siapa) {
        this.untuk_siapa = untuk_siapa;
    }

    public String getImage_slider() {
        return image_slider;
    }

    public void setImage_slider(String image_slider) {
        this.image_slider = image_slider;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }
}