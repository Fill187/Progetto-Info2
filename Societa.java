public class Societa extends Casella{
    protected int prezzo;
    protected int affitto;
    protected boolean hasEntrambeSocieta;
    protected Giocatore proprietario; 
    
    public Societa(String nome, int posizione, int prezzo, int affitto, Giocatore proprietario){
        super(nome, posizione);
        this.prezzo = prezzo;
        this.affitto = affitto;
        this.hasEntrambeSocieta = false;
        this.proprietario = null;
    }
    
    public int getPrezzo(){
        return prezzo;
    }
    public void setPrezzo(int prezzo){
        this.prezzo = prezzo;
    }
    public int getAffitto(){
        return affitto;
    }
    public Giocatore getProprietario(){
        return proprietario;
    }
    public void setProprietario(Giocatore proprietario){
        this.proprietario = proprietario;
    }
    public void setAffitto(int tiro/*tiro dadi PLACEHOLDER, implementare dado*/){
        if(hasEntrambeSocieta){
            this.affitto = tiro * 10;
        }else{
            this.affitto = tiro * 4;
        }
    }   /*l'affitto delle società è dato da il totale ottenuto dai dadi moltiplicato per 4 se si ha una società o 10 se si ha entrambe*/
    public String toString(){
        String s = "";
        s += "Nome: " + nome + "\n";
        s += "Posizione" + posizione + "\n";
        s += "Il giocatore ha entrambe le società: " + hasEntrambeSocieta + "\n";
        s += "Affitto: " + affitto + "\n";
        s += "Prezzo: " + prezzo + "\n";
        s += "Proprietario: " + proprietario + "\n";
        return s;
    }
}
