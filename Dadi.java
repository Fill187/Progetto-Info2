import java.util.Random;

public class Dadi{
    private int valore1;
    private int valore2;
    private boolean wasLancioDoppio;
    
    public Dadi(){
        this.valore1 = 0;
        this.valore2 = 0;
        this.wasLancioDoppio = false;
    }
    
    public int getValore1() {
        return valore1;
    }
    
    public void setValore1(int valore1) {
        this.valore1 = valore1;
    }
    
    public int getValore2() {
        return valore2;
    }
    
    public void setValore2(int valore2) {
        this.valore2 = valore2;
    }
    
    public boolean isWasLancioDoppio() {
        return wasLancioDoppio;
    }
    
    public void setWasLancioDoppio(boolean wasLancioDoppio) {
        this.wasLancioDoppio = wasLancioDoppio;
    }
    
    public int lancia(){
        Random random = new Random();
        this.valore1 = random.nextInt(6) + 1; // da 1 a 6
        this.valore2 = random.nextInt(6) + 1;
        int somma = valore1 + valore2;
        return somma;
    }
    public boolean isDoppio(){
        boolean res = false;
        if(valore1 == valore2){
            res = true;
        }
        setWasLancioDoppio(res);
        return res;
    }
}
