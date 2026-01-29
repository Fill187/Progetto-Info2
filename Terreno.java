public class Terreno extends Casella{
    private String colore;
    private int prezzo;
    private int rendita;
    private String proprietario;
    private int numCase;

    public Terreno(String nome, String colore, int prezzo, int rendita){
        super(nome);
        this.colore=colore;
        this.prezzo=prezzo;
        this.rendita=rendita;
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

    public int getNumCase() {
        return numCase;
    }

    public void aggiungiCasa(){
        if(numCase<4){
            numCase++;
            System.out.println("Casa aggiunta.");
        } else{
            System.out.println("Casa non aggiunta limite massimo raggiunto");
        }
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        String s="";
        return s+super.toString()+"|Colore: "+colore+",\n| Prezzo: "+prezzo+",\n| Rendita: "+rendita+",\n| Case: "+numCase+",\n| Proprietario: "+proprietario;
    }
}
