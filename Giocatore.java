public class Giocatore{
    protected boolean isPrigioniero; 
    protected boolean hasCartaEsciPrigione;
    protected int portafoglio;
    protected int posizioneGiocatore;
    protected int stazioniPossedute;
    protected int turniInPrigione;
    
    public Giocatore(int portafoglio){
        this.portafoglio = portafoglio;
        this.isPrigioniero = false;
        this.hasCartaEsciPrigione = false;
        this.posizioneGiocatore = 0;
        this.stazioniPossedute = 0;
    }
    
    public void passaPerVia(){
        if(posizioneGiocatore == 0){
            portafoglio += 200;
        }
    }
    public int getPortafoglio(){
        return portafoglio;
    }
    public void setPortafoglio(int portafoglio){
        this.portafoglio = portafoglio;
    }
    public void usaCartaEsciPrigione(){
        if(isPrigioniero){
            this.isPrigioniero = false;
        }
    }
    public void paga(int importo){
        this.portafoglio -= importo;
    }
    public int getStazioniPossedute(){
        return stazioniPossedute;
    }
    public void setStazioniPossedute(){
        this.stazioniPossedute = stazioniPossedute;
    }
    public int getTurniInPrigione(){
        return turniInPrigione;
    }
    public void setTurniInPrigione(int turniInPrigione){
        this.turniInPrigione = turniInPrigione;
    }
    public boolean getIsPrigioniero(){
        return isPrigioniero;
    }
    public void setIsPrigioniero(boolean isPrigioniero){
        this.isPrigioniero = isPrigioniero;
    }
    public String toString(){
        String s = "";
        s += "Portafoglio: " + portafoglio + "\n";
        s += "Posizione del Giocatore " + posizioneGiocatore + "\n";
        s += "Il giocatore è Prigioniero: " + isPrigioniero + "\n";
        s += "Turni In Prigione: " + turniInPrigione + "\n";
        s += "ha la Carta di Esci Prigione: " + hasCartaEsciPrigione + "\n";
        s += "stazioni Possedute dal giocatore: " + stazioniPossedute + "\n";
        return s;
    }
}
