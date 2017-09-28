package com.example.eleves.android_comptoir_grasset;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Mes_Demandes extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes__demandes);

        List<String> demandes = new ArrayList();

        if(demandes.isEmpty()) {
            //code pour afficher le pop-up
            //=============================================
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Alerte");
            alertDialogBuilder.setMessage("Vous n'avez aucun prêt en cours");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    Intent intent = new Intent(Mes_Demandes.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            //=============================================
        }


    }



}


