public class Gioco {

    private Tabellone tabellone;
    private Giocatore giocatori[];
    private int giocatoriAttuali = 0;
    private int maxGiocatori;
    private boolean partitaFinita = false;
    private int turnoCorrente = 0;
    private Dadi dadi = new Dadi();

    public Gioco(Tabellone tabellone) {
        this.tabellone = tabellone;
    }

    public void setNumMaxGiocatori(int n) {
        maxGiocatori = n;
        giocatori = new Giocatore[maxGiocatori];
    }

    public void aggiungiGiocatore(Giocatore g) {
        if (giocatoriAttuali < maxGiocatori) {

            
            if (g.getPosizione() == null) {
                g.setPosizione(tabellone.getCasellaIniziale());
            }

            giocatori[giocatoriAttuali] = g;
            giocatoriAttuali++;
        } else {
            System.out.println("Impossibile aggiungere ulteriori giocatori. Limite raggiunto");
        }
    }

    public boolean isFinita() {
        return partitaFinita;
    }

    public void avviaPartita() {
        if (giocatoriAttuali < 2) {
            System.out.println("Servono almeno 2 giocatori per iniziare.");
            return;
        }

        System.out.println("La partita è iniziata!");
    }

    public void eseguiTurno() {
        if (partitaFinita) return;

        Giocatore g = giocatori[turnoCorrente];

        if (g.isEliminato()) {
            passaTurno();
            return;
        }

        System.out.println("\nTurno di: " + g.getNome());

        int tiro = dadi.lancia();
        System.out.println(g.getNome() + " tira i dadi: " + tiro);

        g.muovi(tiro, tabellone.getNumeroCaselle());

        Casella casella = g.getPosizione();
        System.out.println(g.getNome() + " è finito su: " + casella.getNome());

        gestisciCasella(g, casella);

        controllaGiocatori();
        controllaFinePartita();

        passaTurno();
    }

    private void gestisciCasella(Giocatore g, Casella casella) {

        if (casella instanceof Terreno) {
            Terreno t = (Terreno) casella;

           
            if (t.getProprietario() == null) {

                if (g.getSoldi() >= t.getCosto()) {

                    System.out.println("Vuoi acquistare il terreno " + t.getNome() +
                            " per " + t.getCosto() + "€ ? (s/n)");

                    String risposta = Leggi.unoString();

                    if (risposta.equalsIgnoreCase("s")) {
                        g.paga(t.getCosto());
                        t.setProprietario(g);
                        g.aggiungiTerreno(t);
                        System.out.println(g.getNome() + " ha acquistato " + t.getNome());
                    } else {
                        System.out.println(g.getNome() + " ha deciso di non acquistare il terreno.");
                    }

                } else {
                    System.out.println(g.getNome() + " non ha abbastanza soldi per acquistare il terreno.");
                }

            }
            
            else if (t.getProprietario() != g) {

                int affitto = t.getAffitto();
                System.out.println("Il terreno appartiene a " + t.getProprietario().getNome() +
                        ". Affitto da pagare: " + affitto);

                g.paga(affitto);
                t.getProprietario().ricevi(affitto);

                if (g.getSoldi() <= 0) {
                    g.setEliminato(true);
                    System.out.println(g.getNome() + " è stato eliminato per bancarotta!");
                }
            }
        }
    }

    private void passaTurno() {
        turnoCorrente = (turnoCorrente + 1) % giocatoriAttuali;
    }

    private void controllaGiocatori() {
        for (Giocatore g : giocatori) {
            if (g != null && g.getSoldi() <= 0) {
                g.setEliminato(true);
            }
        }
    }

    private void controllaFinePartita() {
        int attivi = 0;
        Giocatore ultimo = null;

        for (Giocatore g : giocatori) {
            if (g != null && !g.isEliminato()) {
                attivi++;
                ultimo = g;
            }
        }

        if (attivi == 1) {
            partitaFinita = true;
            System.out.println("\nIl vincitore è: " + ultimo.getNome());
        }
    }
}
