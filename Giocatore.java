import java.util.ArrayList;

public class Giocatore {

    private String nome;
    private int soldi;
    private Casella posizione;
    private ArrayList<Terreno> terreni;
    private int numeroTerreni;
    private boolean inPrigione;
    private int turniPrigione;

    public Giocatore(String nome, int soldiIniziali, Casella start) {
        this.nome = nome;
        this.soldi = soldiIniziali;
        this.posizione = start;
        this.terreni = new ArrayList<>();
        this.numeroTerreni = 0;
        this.inPrigione = false;
        this.turniPrigione = 0;
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

    public Casella getPosizione() {
        return posizione;
    }

    public void setPosizione(Casella c) {
        posizione = c;
    }

    public void aggiungiTerreno(Terreno t) {
        terreni.add(t);
        numeroTerreni++;
    }

    public int getNumeroTerreni() {
        return numeroTerreni;
    }

    public ArrayList<Terreno> getTerreni() {
        return terreni;
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

    public boolean morto() {
        return soldi < 0;
    }

    public String toString() {
        return nome + " - Soldi: " + soldi + "€ - Terreni: " + numeroTerreni;
    }
}
