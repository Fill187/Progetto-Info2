public class CartaImprevisto {

    private String nome;
    private String descrizione;
    private TipoAzione tipoAzione;
    private int valoreAzione;

    public CartaImprevisto(String nome, String descrizione, TipoAzione tipoAzione, int valoreAzione){
        this.nome = nome;
        this.descrizione = descrizione;
        this.tipoAzione = tipoAzione;
        this.valoreAzione = valoreAzione;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoAzione getTipoAzione() {
        return tipoAzione;
    }

    public int getValoreAzione() {
        return valoreAzione;
    }

    
    public void applicaEffettoSpostamento(Giocatore giocatore, Casella destinazione){
        giocatore.setPosizione(destinazione);
    }

    
    public void applicaEffettoBonusOrMalus(Giocatore giocatore){
        if (valoreAzione >= 0)
            giocatore.incassa(valoreAzione);
        else
            giocatore.paga(-valoreAzione);
    }
}
