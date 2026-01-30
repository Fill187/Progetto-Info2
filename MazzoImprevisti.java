import java.util.Random;

public class MazzoImprevisti {
    private CartaImprevisto[] carte;
    private int size;
    private int indiceCorrente = 0;
    private Random random = new Random();

    /** Costruisce un mazzo di 15 carte imprevisto. */
    public MazzoImprevisti(){
        this.size = 15;
        this.carte = new CartaImprevisto[size];

        int i = 0;
        // Carte BONUS / MALUS
        carte[i++] = new CartaImprevisto("Fortuna improvvisa", "Ricevi 200 euro", TipoAzione.BONUS_MALUS, 200);
        carte[i++] = new CartaImprevisto("Tassa inaspettata", "Perdi 150 euro", TipoAzione.BONUS_MALUS, -150);
        carte[i++] = new CartaImprevisto("Vendita riuscita", "Ricevi 100 euro", TipoAzione.BONUS_MALUS, 100);
        carte[i++] = new CartaImprevisto("Multa stradale", "Perdi 50 euro", TipoAzione.BONUS_MALUS, -50);
        carte[i++] = new CartaImprevisto("Eredità", "Ricevi 300 euro", TipoAzione.BONUS_MALUS, 300);
        carte[i++] = new CartaImprevisto("Riparazioni impreviste", "Perdi 200 euro", TipoAzione.BONUS_MALUS, -200);
        carte[i++] = new CartaImprevisto("Premio locale", "Ricevi 150 euro", TipoAzione.BONUS_MALUS, 150);
        carte[i++] = new CartaImprevisto("Furto subito", "Perdi 100 euro", TipoAzione.BONUS_MALUS, -100);

        // Carte VAI IN PRIGIONE (SPOSTAMENTO)
        for (; i < size; i++) {
            carte[i] = new CartaImprevisto("Vai in prigione", "Vai direttamente in prigione", TipoAzione.SPOSTAMENTO, 0);
        }

        mescola();
    }

    /** Mescola il mazzo usando Fisher-Yates. */
    public void mescola(){
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            CartaImprevisto tmp = carte[i];
            carte[i] = carte[j];
            carte[j] = tmp;
        }
        indiceCorrente = 0;
    }

    /** Pesca la carta corrente e avanza l'indice (ciclo circolare). */
    public CartaImprevisto pescaCarta(){
        if (carte == null || size == 0) return null;
        CartaImprevisto c = carte[indiceCorrente];
        indiceCorrente = (indiceCorrente + 1) % size;
        return c;
    }
}
