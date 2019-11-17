package com.example.kidsquiz.Model;

import com.example.kidsquiz.R;

import java.util.ArrayList;

public class CategoryData {
    private static String[] categoryNames = {
            "Letters",
            "Numbers",
            "Colors",
            "Months",
            "Days",
            "Animals",
            "Fruits",
            "Home",
            "Greetings"
    };

    private static int[] categoryImages = {
            R.drawable.letters,
            R.drawable.numbers,
            R.drawable.colors,
            R.drawable.months,
            R.drawable.days,
            R.drawable.animals,
            R.drawable.fruits,
            R.drawable.home,
            R.drawable.greetings
    };

    public static ArrayList<Category> getListData() {
        ArrayList<Category> list = new ArrayList<>();
        for (int position = 0; position < categoryNames.length; position++) {
            Category category = new Category();
            category.setName(categoryNames[position]);
            category.setImg_category(categoryImages[position]);
            list.add(category);
        }
        return list;
    }
}
