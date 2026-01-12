public class Casella{
    protected String nome;
    protected int posizione;
    
    public Casella(String nome, int posizione){
        this.nome = nome;
        this.posizione = posizione;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getPosizione(){
        return posizione;
    }
    public void setPosizione(int posizione){
        this.posizione = posizione;
    }
    public String toString(){
        String s = "";
        s += "Nome: " + nome + "\n";
        s += "Posizione" + posizione + "\n";
        return s;
    }
}
