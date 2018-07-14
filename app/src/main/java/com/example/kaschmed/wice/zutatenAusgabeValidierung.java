package com.example.kaschmed.wice;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URLEncoder;

import javax.xml.transform.Result;

public class zutatenAusgabeValidierung extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zutaten_ausgabe_validierung);
        result = (TextView) findViewById(R.id.result_Scanner);
        String Text1 = getIntent().getStringExtra("barcode");
        result.setText(Text1);
        System.out.println(Text1);

    }
    public void searchInformation(View view){
        {
            try {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String term = getIntent().getStringExtra("barcode");
                intent.putExtra(SearchManager.QUERY, term);
                startActivity(intent);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }

}
