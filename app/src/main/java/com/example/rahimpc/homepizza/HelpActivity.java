package com.example.rahimpc.homepizza;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
    public void retour(View view) {
        Intent resultIntent = new Intent();
        String product="";
        resultIntent.putExtra("resultat", product);
        setResult(RESULT_CANCELED, resultIntent);
        finish();
    }
    public void call(View view){
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "29553025", null));
        startActivity(intentCall);
    }
    public void email(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email to the Support");
        intent.putExtra(Intent.EXTRA_TEXT, "Write your problem");
        intent.setData(Uri.parse("mailto:abdelrahim.ounifi@gmail.com"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); startActivity(intent);
    }
}
