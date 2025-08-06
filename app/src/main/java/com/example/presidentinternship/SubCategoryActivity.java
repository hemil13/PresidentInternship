package com.example.presidentinternship;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class SubCategoryActivity extends AppCompatActivity {

    int[] subcategoryIdArray = {1,2,3,4,5,6,7,8,9};
    int[] categoryIdArray = {1,1,1,2,2,2,3,3,3};
    String[] nameArray = {"Mobile", "Headphone", "Earbuds", "Jeans", "Shirt", "T Shirt", "Horror", "Fiction", "Novel"};
    int[] imageArray = {R.drawable.mobile, R.drawable.headphone, R.drawable.earbuds,
            R.drawable.jeans, R.drawable.shirt, R.drawable.thsirt,
            R.drawable.horror, R.drawable.fiction, R.drawable.novel};

    RecyclerView subcategory_recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        subcategory_recycler = findViewById(R.id.subcategory_recycler);

        subcategory_recycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        SubcategoryAdapter adapter = new SubcategoryAdapter(SubCategoryActivity.this, subcategoryIdArray, categoryIdArray, nameArray, imageArray);
        subcategory_recycler.setAdapter(adapter);

    }
}