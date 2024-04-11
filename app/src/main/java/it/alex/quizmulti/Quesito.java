package it.alex.quizmulti;

import java.util.ArrayList;

public class Quesito {
    private int correctIndex;
    private String testo;
    private String[] risposte;
    private  boolean risposta_contata; //risposta già contata? salva stato se risposta già stata data ad un quesito
    private boolean sugg_visto; //se suggerimento è stato visto

    public Quesito(String testo, String[] risposte, int correctIndex){

        this.testo = testo;
        this.risposte= risposte;
        this.correctIndex = correctIndex;

        this.risposta_contata = false;
        this.sugg_visto = false;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }
    public String getTesto() {
        return testo;
    }

    public String getRispostaCorretta() {
        return risposte[correctIndex];
    }

    public boolean isRispostaCorretta(String candidato){
        return getRispostaCorretta().equals(candidato);
    }

    public String[] getRisposte() {
        return risposte;
    }

    public String getTestoRisposta(int indexRisposta){
        return risposte[indexRisposta];
    }


    public boolean isRispostaContata() {
        return risposta_contata;
    }

    public void setRispostaContata(boolean v) {
        this.risposta_contata = v;
    }

    public boolean getSuggVisto() {
        return sugg_visto;
    }

    public void setSuggVisto(boolean sugg_visto) {
        this.sugg_visto = sugg_visto;
    }
}
