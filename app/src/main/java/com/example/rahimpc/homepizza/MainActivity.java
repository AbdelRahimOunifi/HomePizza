package com.example.rahimpc.homepizza;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton calzone_btn;
    ImageButton neapolitan_btn;
    ImageButton margherita_btn;
    ImageButton marinara_btn;
    int REQUEST_CODE=0;
    String commande="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        calzone_btn = findViewById(R.id.calzone_btn);
        neapolitan_btn = findViewById(R.id.neapolitan_btn);
        margherita_btn = findViewById(R.id.margherita_btn);
        marinara_btn = findViewById(R.id.marinara_btn);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.our_suppliment){
            Intent our_suppliment= new Intent(getApplicationContext(),SupplementsActivity.class);
            startActivityForResult(our_suppliment,REQUEST_CODE);
        }
        else if(id==R.id.about_as){
            Intent about_as= new Intent(MainActivity.this,AboutAsActivity.class);
            startActivityForResult(about_as,REQUEST_CODE);
        }
        else if (id==R.id.support){
            Toast.makeText(getApplicationContext(),"le support",Toast.LENGTH_SHORT).show();
            Intent help= new Intent(getApplicationContext(),HelpActivity.class);
            startActivityForResult(help,REQUEST_CODE);
        }
        else if (id==R.id.paye){
            Toast.makeText(getApplicationContext(),"payement: "+commande,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + 123));
            intent.putExtra("sms_body", commande);
            startActivity(intent);
            commande="";
        }
        else if (id==R.id.gps){
            Intent gpsOptionsIntent = new Intent(
                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(gpsOptionsIntent);
        }
        else if (id==R.id.social_media){
            String url = "https://web.facebook.com/abdelrahim.ounifi1";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        else if (id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void viewEdit(View v){
        Intent intent= new Intent(MainActivity.this,Main2Activity.class);
        switch (v.getId()){
            case R.id.calzone_btn:
                intent.putExtra("name","Calzone");
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.margherita_btn:
                intent.putExtra("name","Margherita");
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.marinara_btn:
                intent.putExtra("name","Marinara");
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.neapolitan_btn:
                intent.putExtra("name","Neapolitan");
                startActivityForResult(intent,REQUEST_CODE);
                break;    }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == REQUEST_CODE)
        {
            if ( resultCode == RESULT_OK)
                Toast.makeText(this, "Résultat = "+ data.getStringExtra("resultat"), Toast.LENGTH_SHORT).show();
                commande=commande+data.getStringExtra("resultat");
            if( resultCode == RESULT_CANCELED)
                Toast.makeText(this,"Back to main page",Toast.LENGTH_LONG).show();
        }
    }
}
