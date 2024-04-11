package it.alex.quizmulti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvNumeroDomanda;
    private TextView tvDomanda;
    private TextView tvRisposta1, tvRisposta2, tvRisposta3, tvRisposta4;
    //private TextView tvRisposteTotali;
    private TextView tvRisposteCorretteValide;
    private TextView tvRisposteCorretteNonValide;
    private TextView tvRisposteErrate;
    private int domandeTotali = 0;
    private int risposteCorretteValide = 0;
    private int risposteCorretteNonValide = 0;
    private int risposteErrate = 0;
    private int quesito_corrente = 0;
    private Quiz quiz = new Quiz();
    private Quesito[] arrayQuesiti = quiz.getQuesiti();

    private int NUM_QUESITI = quiz.getNumeroQuesiti();

    private  void aggiorna(){
        tvDomanda.setText(arrayQuesiti[quesito_corrente].getTesto());   //da numero quesito
        tvNumeroDomanda.setText("Quesito numero: " + (quesito_corrente+1));//stabilisce domanda nel TextView

        //Per le Risposte
        tvRisposta1.setText(arrayQuesiti[quesito_corrente].getTestoRisposta(0));
        tvRisposta2.setText(arrayQuesiti[quesito_corrente].getTestoRisposta(1));
        tvRisposta3.setText(arrayQuesiti[quesito_corrente].getTestoRisposta(2));
        tvRisposta4.setText(arrayQuesiti[quesito_corrente].getTestoRisposta(3));

        //punteggio
        //tvRisposteTotali.setText("Risposte totali: "+risposteTotali);
        tvRisposteCorretteValide.setText("Risposte corrette valide: "+ risposteCorretteValide);
        tvRisposteCorretteNonValide.setText("Risposte corrette non valide: "+ risposteCorretteNonValide);
        tvRisposteErrate.setText("Risposte da Ciuchino: " + risposteErrate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            //domandeTotali = savedInstanceState.getInt("RISPOSTE_TOTALI");
            risposteCorretteValide = savedInstanceState.getInt("RISPOSTE_CV");
            risposteCorretteNonValide = savedInstanceState.getInt("RISPOSTE_CNV");
            risposteErrate = savedInstanceState.getInt("RISPOSTE_ERR");
            quesito_corrente = savedInstanceState.getInt("QUESITO_CORRENTE");
        }

        tvDomanda = findViewById(R.id.tvDomanda);
        tvNumeroDomanda = findViewById(R.id.numeroQuesito);
        tvRisposta1 = findViewById(R.id.tvRisposta1);
        tvRisposta2 = findViewById(R.id.tvRisposta2);
        tvRisposta3 = findViewById(R.id.tvRisposta3);
        tvRisposta4 = findViewById(R.id.tvRisposta4);

        //punteggio
        //tvRisposteTotali = findViewById(R.id.tvRisposteTotali);
        tvRisposteCorretteValide = findViewById(R.id.tvRisposteCorretteValide);
        tvRisposteCorretteNonValide = findViewById(R.id.tvRisposteNonValide);
        tvRisposteErrate = findViewById(R.id.tvRisposteErrate);

        // ritorno home da parte di Risultato #risultato
        /*
        Intent intent = getIntent();
        if( intent != null && intent.getAction().equals("android.intent.action.Risultato")){
            Log.d("MYQUIZ", intent.getAction().toString());
            reset();
            Log.d("MYQUIZ", "tornati alla home");
        }*/

        aggiorna();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Salvare lo stato dell’app (activity main)
        //savedInstanceState.putInt("RISPOSTE_TOTALI", domandeTotali);
        savedInstanceState.putInt("QUESITO_CORRENTE", quesito_corrente);

        savedInstanceState.putInt("RISPOSTE_CV", risposteCorretteValide);
        savedInstanceState.putInt("RISPOSTE_CNV", risposteCorretteNonValide);
        savedInstanceState.putInt("RISPOSTE_ERR", risposteErrate);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void reset(){
        //ripristina tutti i valori iniziali
        //domandeTotali = 0;
        risposteCorretteValide = 0;
        risposteCorretteNonValide = 0;
        risposteErrate = 0;
        quesito_corrente = 0;

        for(int i=0; i < NUM_QUESITI; i++){
            arrayQuesiti[i].setRispostaContata(false);
            arrayQuesiti[i].setSuggVisto(false);
        }
    }

    public void resetClicked(View v){
        reset();
        aggiorna();

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public  void suggerimentoClicked(View v){
        Intent i = new Intent();
        i.setClass(getApplicationContext(), Suggerimento.class);
        i.putExtra("RISPOSTA", arrayQuesiti[quesito_corrente].getRispostaCorretta());
        i.putExtra("DOMANDA", arrayQuesiti[quesito_corrente].getTesto());
        //prendo risposta dall'activity:
        //lanciare activity
        startActivityForResult(i, 453); //intero scelto a piacimento per distinguere chi ha invocato l'activity dopo in onActivityResult
        //va dichiarata l'activity nel manifesto! ! // <activity android:name=".Suggerimento"/>
    }

    public void onActivityResult(int rc, int result, Intent i) { //rc = REQUEST_CODE
        super.onActivityResult(rc, result, i);

        if (rc != 453 && rc != 555)
            return;
        if (result != Activity.RESULT_OK){//eventuale messaggio di errore
            Log.d("MYQUIZ", "Errore Intent RESULT NON OK");
            return;
        }
        if (i == null)
            Log.d("MYQUIZ", "intent null");

        if(rc == 453) {//suggerimento Activity
            //allora ho le risposte
            boolean visto = i.getBooleanExtra("SUGGERIMENTO_VISTO", false);
            Log.d("MYQUIZ", "visto" + visto);
            if (visto)
                arrayQuesiti[quesito_corrente].setSuggVisto(true);  //una volta visto resterà memorizzato come visto in classe quesito
        }
    }

    public void precedenteClicked(View v){
        quesito_corrente--;
        if(quesito_corrente < 0)    //così faccio array circolare per i quesiti
            quesito_corrente=NUM_QUESITI-1;
        aggiorna();
    }
    public void successivoClicked(View v){
        quesito_corrente++;

        if(quesito_corrente > NUM_QUESITI-1) {
            Toast.makeText(this, "Fine Quiz!", Toast.LENGTH_SHORT).show();

            //per cambiare background risultato
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Risultato.class);
            i.putExtra("PUNTI_CORRETTE", risposteCorretteValide);
            i.putExtra("PUNTI_NONVALIDI", risposteCorretteNonValide);
            i.putExtra("ERRORI_FATTI", risposteErrate);
            i.putExtra("DOMANDE_TOTALI", domandeTotali);

            startActivity(i);
        }
        aggiorna();
    }


    public void rispostaClicked(View v) {
        String corretta =  arrayQuesiti[quesito_corrente].getRispostaCorretta();

        String rispostaCandidata = ((Button) v).getText().toString();
        domandeTotali++;
        if(rispostaCandidata.equals(corretta)) {
            //Log.d("MYQUIZ", "Risposta Corretta");
            Toast.makeText(this, "Corretto!", Toast.LENGTH_SHORT).show();
            /*Toast.makeText(getApplicationContext(),
                            "Corretta!", Toast.LENGTH_SHORT)
                    .show(); //Toast.LENGTH_LONG*/
            if(arrayQuesiti[quesito_corrente].getSuggVisto()){
                risposteCorretteNonValide++;
            }else {
                risposteCorretteValide++;
            }
        }
        else {
            //Log.d("MYQUIZ", "Risposta Errata");
            Toast.makeText(this, "ERRATO! Risposta sbagliata.", Toast.LENGTH_SHORT).show();
            risposteErrate++;
        }
        successivoClicked(null);    //contiene aggiorna e andiamo anche avanti
    }

    /*
    public void rispostaClicked(View v) {
        if(!arrayQuesiti[quesito_corrente].isRispostaContata()){
            arrayQuesiti[quesito_corrente].setRispostaContata(true);
            domandeTotali++;

            String corretta =  arrayQuesiti[quesito_corrente].getRispostaCorretta();
            Button clickedButton = (Button) v;
            String rispostaCandidata = clickedButton.getText().toString();

            if(arrayQuesiti[quesito_corrente].getRispostaCorretta().equals(rispostaCandidata)){ //controllo che sia corretta la risposta scelta.
                //controllo se visto il suggerimento
                if(arrayQuesiti[quesito_corrente].getSuggVisto()){
                    risposteCorretteNonValide++;
                }else {
                    risposteCorretteValide++;
                }
            }
        }
        successivoClicked(null);    //contiene aggiorna e andiamo anche avanti
    }
    */

}