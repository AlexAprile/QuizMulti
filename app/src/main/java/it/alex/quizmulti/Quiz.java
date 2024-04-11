package it.alex.quizmulti;

public class Quiz {

    private Quesito[] quesiti;

    public Quiz() {
        quesiti = new Quesito[21];


        quesiti[0] = new Quesito("Com'è fatta la carrozza di Shrek e Fiona? ",
                new String[]{"A forma di cipolla", "A forma di zucca", "A forma di aglio", "A forma di arancia"},
                0);

        quesiti[1] = new Quesito("Chi è il primo personaggio a scoprire che Fiona si trasforma in orco?",
                new String[]{"Il principe azzurro", "Ciuchino", "Shrek", "Lord Farquaad"},
                1);

        quesiti[2] = new Quesito("Quale figura è incisa sulla porta del bagno di Shrek?",
                new String[]{"Un sole", "Un cuore", "Una luna", "Una stella"},
                2);

        quesiti[3] = new Quesito("Come si chiama il regno di Re Harold e della regina Lillian?",
                new String[]{"Regno di Brughiera", "Arendelle", "Regno di Molto Molto Lontano", "La Terra di Mezzo"},
                2);

        quesiti[4] = new Quesito("Quanti sono i figli di Ciuchino e la Draghessa?",
                new String[]{"Sei", "Quattro", "Cinque", "Tre"},
                0);

        quesiti[5] = new Quesito("Quale personaggio delle fiabe trova Shrek a dormire nel suo letto?",
                new String[]{"Pinocchio", "Biancaneve", "L'omino di pan di zenzero", "Il lupo di Cappuccetto Rosso"},
                3);

        quesiti[6] = new Quesito("Che fine fa Lord Farquaad?",
                new String[]{"Si butta da una torre", "Viene mangiato da un drago", "Cade in un burrone", "Scappa lontano"},
                1);

        quesiti[7] = new Quesito("In quale animale si trasforma il padre di Fiona?",
                new String[]{"Asino", "Lucertola", "Rospo", "Gatto"},
                2);

        quesiti[8] = new Quesito("Come si chiama il pub dove la sorellastra di Cenerentola fa la barista?",
                new String[]{"La mela avvelenata", "In vino veritas", "Il fondo del boccale", "Le tre cimici"},
                0);

        quesiti[9] = new Quesito("Come si chiama il figlio della Fata Madrina?",
                new String[]{"Principe di molto molto lontano", "Celeste", "Principe Azzurro", "Lord Farquaad"},
                2);

        quesiti[10] = new Quesito("Qual è l’unica cosa che può salvare Fiona dalla sua maledizione?",
                new String[]{"Uccidere il drago", "Assalto al castello", "Dandole una rosa magica", "Il bacio di vero amore"},
                3);

        quesiti[11] = new Quesito("Chi è l'amico di Shrek che è un asino che parla?",
                new String[]{"Gatto con gli stivali", "Ciuchino", "Fiona", "Lord Farquaad"},
                1);

        quesiti[12] = new Quesito("Chi è il cattivo nel primo film di Shrek?",
                new String[]{"Fata Madrina", "Principe Azzurro", "Lord Farquaad", "Tremotino"},
                2);

        quesiti[13] = new Quesito("Chi salva Shrek e Fiona dal drago nel primo film?",
                new String[]{"Gatto con gli stivali", "Ciuchino", "Re Harold", "L'Uomo Focaccina"},
                1);

        quesiti[14] = new Quesito("Chi è il padre di Fiona?",
                new String[]{"Re Harold", "Lord Farquaad", "L'Uomo Focaccina", "Tremotino"},
                0);

        quesiti[15] = new Quesito("Chi è il gatto con gli stivali?",
                new String[]{"Un amico di Shrek", "Un nemico di Shrek", "Il cugino di Ciuchino", "Il fratello di Fiona"},
                0);

        quesiti[16] = new Quesito("In quale film Shrek e Fiona hanno dei figli?",
                new String[]{"Shrek", "Shrek 2", "Shrek Terzo", "Shrek e vissero felici e contenti"},
                2);

        quesiti[17] = new Quesito("Chi è il cattivo in Shrek 2?",
                new String[]{"Fata Madrina", "Principe Azzurro", "Lord Farquaad", "Tremotino"},
                0);

        quesiti[18] = new Quesito("Chi è il cattivo in Shrek Forever After?",
                new String[]{"Fata Madrina", "Principe Azzurro", "Lord Farquaad", "Tremotino"},
                3);

        quesiti[19] = new Quesito("Chi è la moglie di Shrek?",
                new String[]{"Draghessa", "Regina Lillian", "Fiona", "Biancaneve"},
                2);

        quesiti[20] = new Quesito("Chi è/sono il/i figlio/i di Ciuchino e Draghessa?",
                new String[]{"Dronkeys", "Fergus", "Felicia", "Farkle"},
                0);
    }


    public Quesito getQuesito(int index) {
        return quesiti[index];
    }

    public Quesito[] getQuesiti() {
        return quesiti;
    }

    public int getNumeroQuesiti(){
        return quesiti.length;
    }
}
