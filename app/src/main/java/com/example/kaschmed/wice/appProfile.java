package com.example.kaschmed.wice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class appProfile extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_profile);}

    public void scan(View view){
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
    @Override
    protected void onPause() {
        super.onPause();
//        zXingScannerView.stopCamera();
    }
    public void onClickSwitchtoIntoleranceActivity(View view) {
        Intent intent = new Intent(this,Intolerances.class);
        startActivity(intent);
    }
    public void onClickSwitchtoRezepteActivity(View view) {
        Intent intent = new Intent(this,Rezepte.class);
        startActivity(intent);
    }
    public void onClickSwitchtoFavoritenActivity(View view) {
        Intent intent = new Intent(this,Favorites.class);
        startActivity(intent);
    }
    public void onClickSwitchtoSearchLocationActivity(View view) {
        Intent intent = new Intent(this,SearchLocation.class);
        startActivity(intent);
    }
    public void onClickClose(View view) {
        finish();
    }


    @Override
    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
    }
    }

