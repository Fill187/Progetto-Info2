import java.util.ArrayList;

public class Tabellone {

    private ArrayList<Casella> caselle;
    private Casella start;
    private Casella prigione;

    public Tabellone() {
        caselle = new ArrayList<>();
    }

    public void aggiungiCasella(Casella c) {
        caselle.add(c);
    }

    // collega tutte le caselle in modo circolare
    public void collega() {
        for (int i = 0; i < caselle.size(); i++) {
            Casella attuale = caselle.get(i);
            Casella succ = caselle.get((i + 1) % caselle.size());
            Casella prec = caselle.get((i - 1 + caselle.size()) % caselle.size());

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

    public void stampa() {
        System.out.println("=== TABELLONE ===");
        for (int i = 0; i < caselle.size(); i++) {
            System.out.println(i + " - " + caselle.get(i).getNome());
        }
        System.out.println("=================");
    }
}
