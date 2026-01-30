public class Tabellone {

    private Casella caselle[];
    private int numeroCaselle;

    public Tabellone() {
        caselle = new Casella[24];
        numeroCaselle = 0;
    }

    public void aggiungiCasella(Casella c) {
        if (numeroCaselle == 0) {
            caselle[0] = c;
            c.setPrecedente(c);
            c.setSuccessiva(c);
            numeroCaselle++;
            return;
        }
        Casella prima = caselle[0];
        Casella ultima = caselle[numeroCaselle - 1];
        ultima.setSuccessiva(c);
        c.setPrecedente(ultima);
        c.setSuccessiva(prima);
        prima.setPrecedente(c);
        caselle[numeroCaselle] = c;
        numeroCaselle++;
    }

    public Casella getCasellaIniziale() {
        return caselle[0];
    }

    public Casella getPrigione() {
        return caselle[5];
    }

    public int getNumeroCaselle() {
        return numeroCaselle;
    }

    public void stampaTabellone() {
        stampaTabellone((Giocatore[]) null);
    }

    public void stampaTabellone(Giocatore[] giocatori) {
        System.out.println("TABELLONE DI GIOCO");

        for (int cont1 = 0; cont1 < numeroCaselle; cont1++) {
            System.out.println(caselle[cont1].toString());

            if (giocatori != null) {
                String players = "";
                for (Giocatore g : giocatori) {
                    if (g != null && g.getPosizione() == caselle[cont1]) {
                        if (!players.equals("")) players += ", ";
                        players += g.getNome();
                    }
                }
                if (!players.equals("")) {
                    System.out.println("Giocatori qui: " + players);
                }
            }

            System.out.println("---------------------------------------------");
        }
    }
}
