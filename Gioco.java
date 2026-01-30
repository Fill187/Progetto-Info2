public class Gioco {

    private Tabellone tabellone;
    private Giocatore giocatori[];
    private int giocatoriAttuali = 0;
    private int maxGiocatori;
    private boolean partitaFinita = false;
    private int turnoCorrente = 0;
    private Dadi dadi = new Dadi();
    private MazzoImprevisti mazzoImprevisti;

    public Gioco(Tabellone tabellone) {
        this.tabellone = tabellone;
        this.mazzoImprevisti = new MazzoImprevisti();
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

    public Giocatore[] getGiocatori() {
        return giocatori;
    }

    public void eseguiTurno() {
        if (partitaFinita) return;
        Giocatore g = giocatori[turnoCorrente];
        if (g.isEliminato()) {
            passaTurno();
            return;
        }
        if (g.isInPrigione()) {
            g.aggiornaPrigione();
            if (g.isInPrigione()) {
                System.out.println(g.getNome() + " è in prigione, turni rimanenti: " + g.getTurniPrigione());
                passaTurno();
                return;
            } else {
                passaTurno();
                return;
            }
        }
        System.out.println("\nTurno di: " + g.getNome());
        int tiro = dadi.lancia();
        System.out.println(g.getNome() + " tira i dadi: " + tiro);
        g.muovi(tiro, tabellone.getNumeroCaselle());
        Casella casella = g.getPosizione();
        System.out.println(g.getNome() + " è finito su: " + casella.getNome());
        gestisciCasella(g, casella);
        controllaGiocatori();
        sconfitta();
        if (partitaFinita) return;
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
                    if (risposta == null) risposta = "";
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
        else if (casella instanceof CasellaImprevisti) {
            CartaImprevisto carta = mazzoImprevisti.pescaCarta();
            if (carta != null) {
                System.out.println("Hai pescato: " + carta.getNome() + " - " + carta.getDescrizione());
                if (carta.getTipoAzione() == TipoAzione.SPOSTAMENTO) {
                    g.vaiInPrigione(tabellone.getPrigione());
                    System.out.println(g.getNome() + " va in prigione!");
                } else if (carta.getTipoAzione() == TipoAzione.BONUS_MALUS) {
                    carta.applicaEffettoBonusOrMalus(g);
                    if (carta.getValoreAzione() >= 0)
                        System.out.println(g.getNome() + " riceve " + carta.getValoreAzione() + "€");
                    else
                        System.out.println(g.getNome() + " perde " + (-carta.getValoreAzione()) + "€");
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

    private void sconfitta() {
        for (Giocatore g : giocatori) {
            if (g != null && g.getSoldi() <= 0) {
                g.setEliminato(true);
                System.out.println("\n" + g.getNome() + " ha finito i soldi e ha perso.");
                Giocatore vincitore = null;
                for (Giocatore h : giocatori) {
                    if (h != null && !h.isEliminato()) {
                        vincitore = h;
                        break;
                    }
                }
                if (vincitore != null) {
                    partitaFinita = true;
                    System.out.println("Il vincitore è: " + vincitore.getNome());
                } else {
                    partitaFinita = true;
                    System.out.println("Partita terminata. Nessun vincitore.");
                }
                return;
            }
        }
    }
}
