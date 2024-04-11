package it.alex.quizmulti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Suggerimento extends AppCompatActivity {
    private String rispostaCorretta;
    private String domanda;
    private TextView tvDomanda;
    private TextView tvRisposta;
    private Button noButton;
    private boolean rispostaVista = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_suggerimento);

        if(savedInstanceState != null){
            rispostaVista = savedInstanceState.getBoolean("RISPOSTA_VISTA");
        }

        tvDomanda = findViewById(R.id.tvDomanda);
        tvRisposta = findViewById(R.id.tvRisposta);
        noButton = findViewById(R.id.noButton);

        //prende dall'intent (activity) risposta e domanda tramite i loro riferimenti
        Intent i = getIntent();
        rispostaCorretta = i.getStringExtra("RISPOSTA");
        domanda = i.getStringExtra("DOMANDA");

        tvDomanda.setText("Vuoi veramente vedere la risposta di: \n"+ domanda);
        //stampo la risposta se si è cliccato sì, ma si è anche ruotato lo schermo es:per errore
        if(rispostaVista){
            tvRisposta.setText("La risposta è: \n"+ rispostaCorretta);
        }

        aggiorna();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Salvare lo stato dell’activity Suggerimento
        savedInstanceState.putBoolean("RISPOSTA_VISTA", rispostaVista);

        super.onSaveInstanceState(savedInstanceState);
    }

    private void aggiorna(){
        //per passare la risposta
        Intent i = new Intent();
        i.putExtra("SUGGERIMENTO_VISTO", rispostaVista);
        setResult(RESULT_OK, i);
    }

    public  void  siClicked(View v){
        tvRisposta.setVisibility(View.VISIBLE);
        noButton.setVisibility(View.GONE);
        tvRisposta.setText("La risposta è: \n"+ rispostaCorretta); //tvRisposta.setText("La risposta è: "+ risposta);
        rispostaVista = true;

        aggiorna();
    }

    public void noClicked(View v){
        onBackPressed();    //torno indietro nelle activity (= utente che preme tasto indietro)
        aggiorna();
    }
}
