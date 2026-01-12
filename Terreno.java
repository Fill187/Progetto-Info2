public class Terreno extends Casella{
    protected String quartiere;     //lo adoperiamo nel main?
    protected int prezzo;
    protected int affitto;
    protected int numCase;    //se maggiore di 4, diventa un hotel, ma quello avverrà solo graficamente
    protected int costoCasa;
    protected Giocatore proprietario;
    
    public Terreno(String nome, int posizione, int prezzo, int affitto, int numCase, int costoCasa, Giocatore proprietario){
        super(nome, posizione);
        this.prezzo = prezzo;
        this.affitto = affitto;
        this.numCase = numCase;
        this.costoCasa = costoCasa;
        this.proprietario = null;
    }
    
    public void compra(Giocatore g){
        if(g.getPortafoglio() > getPrezzo()){
            setProprietario(g);
            System.out.println("Aquisto di proprietà eseguito con successo.\n");
        }else{
            System.out.println("Aquisto di proprietà non possibile.\n");
        }
    }
    public void pagaAffitto(Giocatore g){
        if(g.getPortafoglio() > getAffitto()){
            System.out.println("Affitto eseguito con successo.\n");
        }else{
            System.out.println("Affitto non possibile, il giocatore è in debito.\n");     //DISCUSSIIONE: il giocatore dovrebbe andare in bancarotta?
        }
    }
    public void vendi(Giocatore g){
        setProprietario(null);
        g.setPortafoglio(g.getPortafoglio() + getPrezzo());
        System.out.println("Vendita riuscita, ottenuti " + getPrezzo() + "$. \n");
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
    public void setAffitto(int affitto){
        this.affitto = affitto;
    }
    public int getNumCase(){
        return numCase;
    }
    public void setNumCase(int numCase){
        this.numCase = numCase;
    }
    public int getCostoCasa(){
        return costoCasa;
    }
    public void setCostoCasa(int costoCasa){
        this.costoCasa = costoCasa;
    }
    public Giocatore getProprietario(){
        return proprietario;
    }
    public void setProprietario(Giocatore proprietario){
        this.proprietario = proprietario;
    }
    public String getQuartiere(String quartiere){
        return quartiere;
    }
    public void setQuartiere(String quartiere){
        this.quartiere = quartiere;
    }
    public String toString(){
        String s = "";
        s += "Nome: " + nome + "\n";
        s += "Posizione" + posizione + "\n";
        s += "Quartiere: " + quartiere + "\n";
        s += "Affitto: " + affitto + "\n";
        s += "Prezzo: " + prezzo + "\n";
        s += "Numero case: " + numCase + "\n";
        s += "Costo casa : " + costoCasa  + "\n";
        s += "Proprietario: " + proprietario + "\n";
        return s;
    }
}
