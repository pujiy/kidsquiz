package com.example.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import com.example.kidsquiz.Adapter.GridCategoryAdapter;
import com.example.kidsquiz.Model.Category;
import com.example.kidsquiz.Model.CategoryData;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView rvCategories;
    private ArrayList<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

    }


}
