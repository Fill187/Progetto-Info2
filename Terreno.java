public class Terreno extends Casella {
    private String colore;
    private int prezzo;
    private int rendita;
    private Giocatore proprietario;
    private int numCase;

    public Terreno(String nome, String colore, int prezzo, int rendita) {
        super(nome);
        this.colore = colore;
        this.prezzo = prezzo;
        this.rendita = rendita;
        this.proprietario = null;
        this.numCase = 0;
    }

    public String getColore() {
        return colore;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getRendita() {
        return rendita;
    }

    
    public int getCosto() {
        return prezzo;
    }

    public int getAffitto() {
        return rendita;
    }

    public int getNumCase() {
        return numCase;
    }

    public void aggiungiCasa() {
        if (numCase < 4) {
            numCase++;
            System.out.println("Casa aggiunta.");
        } else {
            System.out.println("Casa non aggiunta, limite massimo raggiunto");
        }
    }

    public Giocatore getProprietario() {
        return proprietario;
    }

    public void setProprietario(Giocatore proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        String s = "";
        String nomeProprietario = (proprietario == null) ? "Nessuno" : proprietario.getNome();
        return s + super.toString() +
                " | Colore: " + colore +
                ", Prezzo: " + prezzo +
                ", Rendita: " + rendita +
                ", Case: " + numCase +
                ", Proprietario: " + nomeProprietario;
    }
}
