package com.iav.proyeksony.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iav.proyeksony.MenuDuaActivity;
import com.iav.proyeksony.R;
import com.iav.proyeksony.helper.Config;
import com.iav.proyeksony.model.Model;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Model> menuModels;


    public MenuAdapter(Context context, ArrayList<Model> menuModels) {
        this.context = context;
        this.menuModels = menuModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_menu_utama, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tvMenuKeterangan.setText(menuModels.get(position).getKeterangan_menu());
        Glide.with(context).load(menuModels.get(position).getImage_menu()).into(holder.ivMenu);
        holder.cvklik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(context, MenuDuaActivity.class));
                intent.putExtra(Config.BUNDLE_NAMA_MENU, menuModels.get(position).getNama_menu());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvklik;
        private ImageView ivMenu;
        private TextView tvMenu;
        private TextView tvMenuKeterangan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvklik = itemView.findViewById(R.id.cvklik);
            ivMenu = itemView.findViewById(R.id.iv_Menu);
            tvMenu = itemView.findViewById(R.id.tv_menu);
            tvMenuKeterangan = itemView.findViewById(R.id.tv_menu_keterangan);
        }
    }
}
