public class VaiInPrigione extends Casella{
    public VaiInPrigione(String nome, int posizione){
        super(nome, posizione);
    }
    public void imprigiona(Giocatore g){    //mettiamo questo medoto nel main se il giocatore è sulla stessa cella o pesca una carta prigione
        g.setIsPrigioniero(true);
    }
    public void esciPrigione(Giocatore g){
        if((g.getTurniInPrigione() == 0 && g.getIsPrigioniero()) || (g.getIsPrigioniero() && g.hasCartaEsciPrigione)){
            g.setIsPrigioniero(false);
            g.setPortafoglio(g.getPortafoglio() - 50);
        }else if(g.getIsPrigioniero()){
            g.setTurniInPrigione(g.getTurniInPrigione()-1);
        }
    }
    public String toString(){
        String s = "";
        s += "Nome: " + nome + "\n";
        s += "Posizione" + posizione + "\n";
        return s;
    }
}
