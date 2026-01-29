public class Tabellone {

    private Casella caselle[];
    private int numeroCaselle;

    public Tabellone() {
        caselle=new Casella[24];
        numeroCaselle=0;
    }

    public void aggiungiCasella(Casella c) {
    if (numeroCaselle == 0) {
        caselle[0] = c;
        c.setPrecedente(c);
        c.setSuccessiva(c);
        numeroCaselle++;
        return;
    }
    Casella prima = caselle[0];
    Casella ultima = caselle[numeroCaselle - 1];
    ultima.setSuccessiva(c);
    c.setPrecedente(ultima);
    c.setSuccessiva(prima);
    prima.setPrecedente(c);
    caselle[numeroCaselle] = c;
    numeroCaselle++;
}


    public Casella getCasellaIniziale(){
        return caselle[0];
    }

    public Casella getPrigione() {
        return caselle[5];
    }

    public int getNumeroCaselle() {
        return numeroCaselle;
    }

    public void stampaTabellone(){
        System.out.println("TABELLONE DI GIOCO");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        for(int cont1=0;cont1<caselle.length;cont1++){
            System.out.println(caselle[cont1].toString());
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
        }
    }
}
