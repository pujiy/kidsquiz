package com.nuraffchaniago.kidsquiz.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nuraffchaniago.kidsquiz.R;

import java.util.ArrayList;

import com.nuraffchaniago.kidsquiz.Model.Category;

public class GridCategoryAdapter extends RecyclerView.Adapter<GridCategoryAdapter.GridViewHolder> {

    private ArrayList<Category> listCategory;
    public GridCategoryAdapter(ArrayList<Category> list) {
        this.listCategory = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_category, viewGroup, false);
        return  new GridViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listCategory.get(position).getImg_category())
                .apply(new RequestOptions().override(100,200))
                .into(holder.imgCat);
    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCat;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCat = itemView.findViewById(R.id.imgCat);
        }
    }

    //
}
