public class Giocatore {

    private String nome;
    private int soldi;
    private Casella posizione;
    private Terreno[] terreni;
    private int numeroTerreni;
    private boolean inPrigione;
    private int turniPrigione;
    private boolean eliminato;

    public Giocatore(String nome, int soldiIniziali) {
        this.nome = nome;
        this.soldi = soldiIniziali;
        this.terreni = new Terreno[24];
        this.numeroTerreni = 0;
        this.inPrigione = false;
        this.turniPrigione = 0;
        this.eliminato = false;
    }

    public String getNome() {
        return nome;
    }

    public int getSoldi() {
        return soldi;
    }

    public void paga(int x) {
        soldi -= x;
    }

    public void incassa(int x) {
        soldi += x;
    }

    // alias per il codice in Gioco
    public void ricevi(int x) {
        incassa(x);
    }

    public Casella getPosizione() {
        return posizione;
    }

    public void setPosizione(Casella c) {
        posizione = c;
    }

    public void aggiungiTerreno(Terreno t) {
        if (numeroTerreni < terreni.length) {
            terreni[numeroTerreni] = t;
            numeroTerreni++;
        }
    }

    public int getNumeroTerreni() {
        return numeroTerreni;
    }

    public Terreno[] getTerreni() {
        Terreno[] res = new Terreno[numeroTerreni];
        for (int i = 0; i < numeroTerreni; i++) res[i] = terreni[i];
        return res;
    }

    public boolean isInPrigione() {
        return inPrigione;
    }

    public void vaiInPrigione(Casella prigione) {
        posizione = prigione;
        inPrigione = true;
        turniPrigione = 3;
    }

    public void aggiornaPrigione() {
        if (inPrigione) {
            turniPrigione--;
            if (turniPrigione <= 0) {
                inPrigione = false;
                System.out.println(nome + " è uscito di prigione");
            }
        }
    }

    public int getTurniPrigione() {
        return turniPrigione;
    }

    public boolean morto() {
        return soldi < 0;
    }

    public boolean isEliminato() {
        return eliminato;
    }

    public void setEliminato(boolean eliminato) {
        this.eliminato = eliminato;
    }

    // movimento sul tabellone circolare usando i puntatori successiva
    public void muovi(int passi, int numeroCaselle) {
        if (posizione == null) {
            return;
        }
        for (int i = 0; i < passi; i++) {
            posizione = posizione.getSuccessiva();
        }
    }

    public String toString() {
        return nome + " - Soldi: " + soldi + "€ - Terreni: " + numeroTerreni;
    }
}
