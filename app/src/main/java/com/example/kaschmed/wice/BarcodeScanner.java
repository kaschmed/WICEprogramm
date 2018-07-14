package com.example.kaschmed.wice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class BarcodeScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private Button scanBtn;
    private TextView formatTxt, contentTxt;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 2);
        }
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

    }

    public void scanClick(View v) {

    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v("CAMERA", rawResult.getText()); // Prints scan results
        Log.v("CAMERA", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        String ergebnis =rawResult.getText();//rawResult.getBarcodeFormat().toString();

        mScannerView.stopCamera();
        // If you would like to resume scanning, call this method below:
      //mScannerView.resumeCameraPreview(this);
        Intent intent = new Intent(this, zutatenAusgabeValidierung.class);
        intent.putExtra("barcode", ergebnis);
        startActivityForResult(intent, 100);
        finish();

    }
    public void showResult(Result showResult){

    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }
}


