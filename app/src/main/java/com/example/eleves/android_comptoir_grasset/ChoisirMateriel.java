package com.example.eleves.android_comptoir_grasset;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ChoisirMateriel extends AppCompatActivity {

    final Context context = this;
    Button btn_envoyer;
    Spinner spin_materiel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_materiel);

        spin_materiel = (Spinner) findViewById(R.id.spin_materiel);
        btn_envoyer = (Button) findViewById(R.id.btn_envoyer);

        setTitle("IG PRET");

        btn_envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Si la liste est vide *a remplacer*
                if(spin_materiel.getSelectedItem().toString().equals("-")){
                    //code pour le pop-up
                    //================================================
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alerte");
                    alertDialogBuilder.setMessage("Veuillez choisir au moins un équipement avant d'envoyer votre demande");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
        });
    }
}
