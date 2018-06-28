package com.example.kaschmed.wice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Rezepte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte);
    }
    public void onClickSwitchtoNewRecipeActivity(View view) {
        Intent intent = new Intent(this, newRecipe.class);
        startActivity(intent);
    }
    public void onClickSwitchtoForumActivity(View view) {
        Intent intent = new Intent(this,Forum.class);
        startActivity(intent);
    }
}
