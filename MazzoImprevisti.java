import java.util.ArrayList;
import java.util.Random;

public class MazzoImprevisti {
    private ArrayList<CartaImprevisto> carte;
    private int indiceCorrente;
    
    public MazzoImprevisti(int numeroCarte){
        this.carte = new ArrayList<CartaImprevisto>(numeroCarte);
        this.indiceCorrente = carte.size();
    }
    
    public int getIndiceCorrente() {
        return indiceCorrente;
    }
    
    public void setIndiceCorrente(int indiceCorrente) {
        if (indiceCorrente >= 0 && indiceCorrente < carte.size()) {
            this.indiceCorrente = indiceCorrente;
        }
    }
    
    public boolean addCartaAlMazzo(CartaImprevisto cartaNuova){
        boolean res = false;
        for(int i = 0; i < carte.size(); i++){
            if(carte.get(i) != null){
                carte.add(cartaNuova);
                res = true;
            }
        }
        return res;
    }
    
    public void mescola(){
        Random random = new Random();
        for (int i = carte.size()-1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            CartaImprevisto temp = carte.get(i);
            carte.set(i, carte.get(j));
            carte.set(j, temp);
        }
    }
    
    public CartaImprevisto pescaCarta(){
        CartaImprevisto carta = carte.get(indiceCorrente);
        this.indiceCorrente = indiceCorrente - 1;
        return carta;
    }
}
