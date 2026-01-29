import java.util.ArrayList;

public class Gioco {

    private Tabellone tabellone;
    private ArrayList<Giocatore> giocatori;
    private int numeroGiocatori;
    private Banca banca;
    private Dadi dadi;
    private MazzoImprevisti mazzo;

    public Gioco() {
        tabellone = new Tabellone();
        giocatori = new ArrayList<>();
        numeroGiocatori = 0;
        banca = new Banca(100000);
        dadi = new Dadi();
        mazzo = new MazzoImprevisti();
    }

    public void aggiungiGiocatore(Giocatore g) {
        giocatori.add(g);
        numeroGiocatori++;
    }

    public void muovi(Giocatore g, int passi) {
        Casella pos = g.getPosizione();

        for (int i = 0; i < passi; i++) {
            pos = pos.getSuccessiva();
            if (pos == tabellone.getStart()) {
                System.out.println(g.getNome() + " passa dal VIA e prende 200€");
                g.incassa(200);
            }
        }

        g.setPosizione(pos);
    }

    public void mandaInPrigione(Giocatore g) {
        g.vaiInPrigione(tabellone.getPrigione());
    }

    public void esegui() {
        int turno = 0;

        while (numeroGiocatori > 1) {

            Giocatore g = giocatori.get(turno);

            System.out.println("\nTurno di " + g.getNome());
            System.out.println(g);

            if (g.isInPrigione()) {
                g.aggiornaPrigione();
                turno++;
                if (turno >= numeroGiocatori) turno = 0;
                continue;
            }

            System.out.println("Premi invio per lanciare i dadi");
            Leggi.unoString();

            int[] lancio = dadi.lancia();
            int somma = lancio[0] + lancio[1];

            System.out.println("Hai fatto " + lancio[0] + " e " + lancio[1]);

            muovi(g, somma);

            System.out.println("Ora sei su: " + g.getPosizione().getNome());

            g.getPosizione().azione(this, g);

            if (g.morto()) {
                System.out.println(g.getNome() + " è fallito ed esce dal gioco");
                banca.riprendiTerreniDaGiocatore(g);
                giocatori.remove(g);
                numeroGiocatori--;

                if (turno >= numeroGiocatori)
                    turno = 0;

                continue;
            }

            turno++;
            if (turno >= numeroGiocatori)
                turno = 0;
        }

        if (numeroGiocatori == 1) {
            System.out.println("Vince " + giocatori.get(0).getNome());
        }
    }
}
