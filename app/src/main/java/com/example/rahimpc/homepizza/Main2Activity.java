package com.example.rahimpc.homepizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    CheckBox tunabox;
    CheckBox seefoodbox;
    CheckBox cheesebox;
    CheckBox fritesbox;
    EditText pizzan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String pizza_name = getIntent().getStringExtra("name");
        textView = findViewById(R.id.name_page);
        imageView = findViewById(R.id.img_page);
        tunabox = findViewById(R.id.tunaBox);
        seefoodbox = findViewById(R.id.seefoodbox);
        cheesebox = findViewById(R.id.cheeseBox);
        fritesbox = findViewById(R.id.fritesBox);
        pizzan = findViewById(R.id.pizzaN);
        textView.setText(pizza_name);
        switch (pizza_name) {
            case "Calzone":
                imageView.setImageResource(R.drawable.calzone);
                break;
            case "Marinara":
                imageView.setImageResource(R.drawable.marinara);
                break;
            case "Neapolitan":
                imageView.setImageResource(R.drawable.neapolitan);
                break;
            case "Margherita":
                imageView.setImageResource(R.drawable.margherita);
                break;
        }

    }

    public void achat(View view) {
        Intent resultIntent = new Intent();
        String product = String.valueOf(textView.getText());
        String suppliment = " ";
        if (tunabox.isChecked()) {
            suppliment = suppliment + "\n\t + TUNA";
        } else {
            suppliment = suppliment + "\n\t - TUNA";
        }
        if (fritesbox.isChecked()) {
            suppliment = suppliment + "\n\t + Frites";
        } else {
            suppliment = suppliment + "\n\t - Frites";
        }
        if (cheesebox.isChecked()) {
            suppliment = suppliment + "\n\t + Cheese";
        } else {
            suppliment = suppliment + "\n\t - Cheese";
        }
        if (seefoodbox.isChecked()) {
            suppliment = suppliment + "\n\t + Seefood";
        } else {
            suppliment = suppliment + "\n\t - Seefood";
        }
        String num = String.valueOf(pizzan.getText());
        product =product+":"+suppliment+"\n\t pizza n°: "+num+"\n";
        resultIntent.putExtra("resultat", product);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
    public void retour(View view) {
        Intent resultIntent = new Intent();
        String product="";
        resultIntent.putExtra("resultat", product);
        setResult(RESULT_CANCELED, resultIntent);
        finish();
    }

}
