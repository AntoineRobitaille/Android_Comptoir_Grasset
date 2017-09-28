package com.example.eleves.android_comptoir_grasset;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class NouveauPret extends AppCompatActivity {

    final Context context = this;
    Button btn_choix_materiel, btn_annuler;
    ImageButton img_date_picker;
    Spinner spin_professeur;
    EditText nom_etudiant, courriel_etudiant, date_editTx, comment_editTx;
    AutoCompleteTextView titre_cours;


    Calendar CurrentDate;
    int jour, mois, annee;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_pret);
        //================================================
        setTitle("IG Pret");

        nom_etudiant = (EditText)findViewById(R.id.nom_etudiant);
        courriel_etudiant = (EditText)findViewById(R.id.courriel_etudiant);
        titre_cours = (AutoCompleteTextView) findViewById(R.id.titre_cours);
        spin_professeur = (Spinner)findViewById(R.id.spin_professeur);
        date_editTx = (EditText)findViewById(R.id.date_editTx);
        img_date_picker = (ImageButton) findViewById(R.id.img_date_picker);
        comment_editTx = (EditText)findViewById(R.id.comment_editTx);

        btn_choix_materiel = (Button)findViewById(R.id.btn_choix_materiel);
        btn_annuler = (Button)findViewById(R.id.btn_annuler);


        CurrentDate = Calendar.getInstance();
        jour = CurrentDate.get(Calendar.DAY_OF_MONTH);
        mois = CurrentDate.get(Calendar.MONTH);
        annee = CurrentDate.get(Calendar.YEAR);
        mois = mois+1;
        //fait apparaitre la date d'aujourd'hui
        date_editTx.setText(jour+"/"+mois+"/"+annee);
        mois = mois-1;
        //================================================
        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( spin_professeur.getSelectedItem() == "-"){System.out.println("retour au menu");}
                else{System.out.println(spin_professeur.getSelectedItem().toString());}

                //Si aucune information entrée, retour au menu de depart
                if(nom_etudiant.getText().toString().isEmpty() &&
                        courriel_etudiant.getText().toString().isEmpty() &&
                        titre_cours.getText().toString().isEmpty() &&
                        spin_professeur.getSelectedItem().toString().equals("-") &&
                        comment_editTx.getText().toString().isEmpty())
                {
                    Intent intent = new Intent(NouveauPret.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    //code pour le pop-up
                    //================================================
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alerte");
                    alertDialogBuilder.setMessage("Voulez-vous vraiment annuler votre nouvelle demande?");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(NouveauPret.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    alertDialogBuilder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }
    });

    //================================================

    //================================================
        btn_choix_materiel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View
        view) {

            //Si un champ n'est pas rempli (excepté commentaire et date)
            if(nom_etudiant.getText().toString().isEmpty() ||
                    courriel_etudiant.getText().toString().isEmpty() ||
                    titre_cours.getText().toString().isEmpty() ||
                    spin_professeur.getSelectedItem() == null ||
                    date_editTx.getText().toString().isEmpty())
            {
                //code pour le pop-up
                //================================================
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Alerte");
                alertDialogBuilder.setMessage("Veuillez remplir tous les champs avant de choisir votre matériel (commentaire non obligatoire)");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
            else
            {
                Intent intent = new Intent(NouveauPret.this, ChoisirMateriel.class);
                startActivity(intent);
            }


        }
    });
    //================================================


    //Fait apparaitre le calendrier lorsqu'on click sur le bouton
    //================================================
        img_date_picker.setOnClickListener(new View.OnClickListener(){

        public void onClick(View view) {

            DatePickerDialog datePickerDialog = new DatePickerDialog(NouveauPret.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int annee, int mois, int jour) {
                    mois = mois+1;
                    date_editTx.setText(jour+"/"+mois+"/"+annee);
                }
            }, annee, mois, jour);
            datePickerDialog.show();
        }
    });
    //================================================
}
}
