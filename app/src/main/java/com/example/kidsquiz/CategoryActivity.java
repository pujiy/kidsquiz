package com.example.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.kidsquiz.Adapter.GridCategoryAdapter;
import com.example.kidsquiz.Model.Category;
import com.example.kidsquiz.Model.CategoryData;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rvCategories;
    private ArrayList<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        CardView catAnimals = findViewById(R.id.catAnimals);
        catAnimals.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.catAnimals:
                Intent moveLessonsAnimals = new Intent(CategoryActivity.this, LessonActivity.class);
                startActivity(moveLessonsAnimals);
                break;
        }
    }
}
