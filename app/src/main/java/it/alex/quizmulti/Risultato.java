package it.alex.quizmulti;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Risultato extends AppCompatActivity {
    private int risposteCorrette;
    private int risposteCorretteNonValide;
    private int risposteErrate;
    private int domandeTotali;
    private TextView tvRisposteCorrette;
    private TextView tvRisposteNonValide;
    private TextView tvRisposteErrate;
    private TextView tvDomandeTotali;
    private ImageView imgRisulato;
    private LinearLayout llPunti;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_risultato);

        Intent i = getIntent();
        risposteCorrette = i.getIntExtra("PUNTI_CORRETTE", 0);
        risposteCorretteNonValide = i.getIntExtra("PUNTI_NONVALIDI", 0);
        risposteErrate = i.getIntExtra("ERRORI_FATTI", 0);
        domandeTotali = i.getIntExtra("DOMANDE_TOTALI", 0);

        imgRisulato = findViewById(R.id.imgRisultato);
        llPunti = findViewById(R.id.llPunti);
        if(risposteCorrette>15 && risposteErrate<2){
            imgRisulato.setImageResource(R.drawable.backgroung_shrek);
        } else if(risposteCorretteNonValide>3) {
            imgRisulato.setImageResource(R.drawable.fata_madrina);
            //llPunti.setVerticalGravity(bottom);
        } else if(risposteErrate>6 || risposteCorrette<2){
            imgRisulato.setImageResource(R.drawable.principe_azzurro);
        }
        else if(risposteErrate>3){
            imgRisulato.setImageResource(R.drawable.lord_farquaad_2);
        }


        tvRisposteCorrette = findViewById(R.id.tvRisposteCorrette);
        tvRisposteNonValide = findViewById(R.id.tvRisposteNonValide);
        tvRisposteErrate = findViewById(R.id.tvRisposteErrate);
        tvDomandeTotali = findViewById(R.id.tvDomandeTotali);

        tvRisposteCorrette.setText(tvRisposteCorrette.getText().toString() + risposteCorrette);
        tvRisposteNonValide.setText(tvRisposteNonValide.getText().toString() + risposteCorretteNonValide);
        tvRisposteErrate.setText(tvRisposteErrate.getText().toString() + risposteErrate);
        tvDomandeTotali.setText(tvDomandeTotali.getText().toString() + domandeTotali);
    }

    private void homeClicked(View v){
        Intent intent = new Intent(getApplicationContext(), Home.class);
        setResult(RESULT_OK);
        startActivity(intent);
    }

    /*
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        String[] punteggio = new String[]{};

        savedInstanceState.putStringArray("PUNTEGGIO", punteggio);

        super.onSaveInstanceState(savedInstanceState);
    }*/

}
