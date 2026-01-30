public class Main {
    public static void main(String[] args) {
        Tabellone tabellone=new Tabellone();
        creaTabellone(tabellone);
        Gioco gioco1=new Gioco(tabellone);
        aggiungiGiocatore(gioco1);
        tabellone.stampaTabellone(gioco1.getGiocatori());
        gioco1.avviaPartita();
        while (!gioco1.isFinita()) {
            tabellone.stampaTabellone(gioco1.getGiocatori());
            System.out.println("\nPremi INVIO per eseguire il prossimo turno");
            Leggi.unoString();
            gioco1.eseguiTurno();
        }
    }

    public static void creaTabellone(Tabellone tabellone){
        Casella t1=new Terreno("Mediterranean Avenue", "Marrone", 60, 40);
        Terreno t2=new Terreno("Baltic Avenue", "Marrone", 60, 40);
        Casella ci1=new CasellaImprevisti("Imprevisto!");
        Terreno t3=new Terreno("Oriental Avenue", "Azzurro", 100, 60);
        Terreno t4=new Terreno("Vermont Avenue", "Azzurro", 100, 60);
        Terreno t5=new Terreno("Connecticut Avenue", "Azzurro", 120, 80);
        Prigione p=new Prigione("Prigione");
        Terreno t6=new Terreno(" St. Charles Place", "Rosa", 140, 100);
        Terreno t7=new Terreno("States Avenue", "Rosa", 140, 100);
        Casella ci2=new CasellaImprevisti("Imprevisto");
        Terreno t8=new Terreno("Virginia Avenue", "Rosa", 160, 120);
        Terreno t9=new Terreno("St. James Place", "Arancione", 180, 140);
        Terreno t10=new Terreno("Tennessee Avenue", "Arancione", 180, 140);
        Terreno t11=new Terreno("New York Avenue", "Arancione", 200, 160);
        Terreno t12=new Terreno("Mediterranean Avenue", "Rosso", 60, 40);
        Casella ci3=new CasellaImprevisti("Imprevisto");
        Terreno t13=new Terreno("Mediterranean Avenue", "Rosso", 60, 40);
        Terreno t14=new Terreno("Mediterranean Avenue", "Rosso", 60, 40);
        Terreno t15=new Terreno("Mediterranean Avenue", "Giallo", 60, 40);
        Terreno t16=new Terreno("Mediterranean Avenue", "Giallo", 60, 40);
        Terreno t17=new Terreno("Mediterranean Avenue", "Giallo", 60, 40);
        Casella cs1=new CasellaSpeciale("Vai in prigione!");
        Terreno t18=new Terreno("Mediterranean Avenue", "Blu", 60, 40);
        Terreno t19=new Terreno("Mediterranean Avenue", "Blu", 60, 40);
        tabellone.aggiungiCasella(t1);
        tabellone.aggiungiCasella(t2);
        tabellone.aggiungiCasella(ci1);
        tabellone.aggiungiCasella(t3);
        tabellone.aggiungiCasella(t4);
        tabellone.aggiungiCasella(t5);
        tabellone.aggiungiCasella(p);
        tabellone.aggiungiCasella(t6);
        tabellone.aggiungiCasella(t7);
        tabellone.aggiungiCasella(ci2);
        tabellone.aggiungiCasella(t8);
        tabellone.aggiungiCasella(t9);
        tabellone.aggiungiCasella(t10);
        tabellone.aggiungiCasella(t11);
        tabellone.aggiungiCasella(t12);
        tabellone.aggiungiCasella(ci3);
        tabellone.aggiungiCasella(t13);
        tabellone.aggiungiCasella(t14);
        tabellone.aggiungiCasella(t15);
        tabellone.aggiungiCasella(t16);
        tabellone.aggiungiCasella(t17);
        tabellone.aggiungiCasella(cs1);
        tabellone.aggiungiCasella(t18);
        tabellone.aggiungiCasella(t19);
    }

    public static void aggiungiGiocatore(Gioco gioco1){
        System.out.println("Inserire numero giocatori: da 2 a 4");
        int numGicoatori=Leggi.unInt();
        gioco1.setNumMaxGiocatori(numGicoatori);
        if(numGicoatori==2){
            System.out.println("Inserire nome primo giocatore");
            Giocatore g1=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g1);    
            System.out.println("Inserire nome secondo giocatore");
            Giocatore g2=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g2);
        } else if(numGicoatori==3){
            System.out.println("Inserire nome primo giocatore");
            Giocatore g1=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g1);    
            System.out.println("Inserire nome secondo giocatore");
            Giocatore g2=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g2);
            System.out.println("Inserire nome terzo giocatore");
            Giocatore g3=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g3);
        } else if(numGicoatori==4){
            System.out.println("Inserire nome primo giocatore");
            Giocatore g1=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g1);    
            System.out.println("Inserire nome secondo giocatore");
            Giocatore g2=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g2);
            System.out.println("Inserire nome terzo giocatore");
            Giocatore g3=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g3);
            System.out.println("Inserire nome quarto giocatore");
            Giocatore g4=new Giocatore(Leggi.unoString(), 1000);
            gioco1.aggiungiGiocatore(g4);
        }
    }
}
