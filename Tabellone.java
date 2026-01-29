import java.util.ArrayList;

public class Tabellone {

    private ArrayList<Casella> caselle;
    private int numeroCaselle;
    private Casella start;
    private Casella prigione;

    public Tabellone() {
        caselle = new ArrayList<>();
        numeroCaselle = 0;
    }

    public void aggiungiCasella(Casella c) {
        caselle.add(c);
        numeroCaselle++;
    }

    public void collega() {
        for (int i = 0; i < numeroCaselle; i++) {

            Casella attuale = caselle.get(i);

            Casella succ;
            if (i == numeroCaselle - 1)
                succ = caselle.get(0);
            else
                succ = caselle.get(i + 1);

            Casella prec;
            if (i == 0)
                prec = caselle.get(numeroCaselle - 1);
            else
                prec = caselle.get(i - 1);

            attuale.setSuccessiva(succ);
            attuale.setPrecedente(prec);
        }
    }

    public void setStart(Casella c) {
        start = c;
    }

    public Casella getStart() {
        return start;
    }

    public void setPrigione(Casella c) {
        prigione = c;
    }

    public Casella getPrigione() {
        return prigione;
    }

    public ArrayList<Casella> getCaselle() {
        return caselle;
    }

    public int getNumeroCaselle() {
        return numeroCaselle;
    }

    public void stampa() {
        System.out.println("Tabellone: ");
        for (int i = 0; i < numeroCaselle; i++) {
            Casella c = caselle.get(i);
            System.out.println(i + " - " + c.getNome());
        }
    }
}
