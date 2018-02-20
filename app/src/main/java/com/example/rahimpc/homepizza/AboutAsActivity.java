package com.example.rahimpc.homepizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutAsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_as);
    }
    public void retour(View view) {
        Intent resultIntent = new Intent();
        String product="";
        resultIntent.putExtra("resultat", product);
        setResult(RESULT_CANCELED, resultIntent);
        finish();
    }
}
