package com.example.eleves.android_comptoir_grasset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNouveauPret, btnMesPrets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("IG Pret");

        btnNouveauPret = (Button)findViewById(R.id.btNouvPret);

        btnMesPrets = (Button)findViewById(R.id.btMesPrets);

        btnMesPrets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mes_Demandes.class);
                startActivity(intent);

            }
        });


        btnNouveauPret.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NouveauPret.class);
                startActivity(intent);
            }
        });


    }//
}
