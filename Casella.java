public class Casella {

    private String nome;
    private Casella precedente;
    private Casella successiva;

    public Casella(String nome) {
        this.nome = nome;
        this.precedente = null;
        this.successiva = null;
    }

    public String getNome() {
        return nome;
    }

    public Casella getSuccessiva() {
        return successiva;
    }

    public Casella getPrecedente() {
        return precedente;
    }

    public void setSuccessiva(Casella c) {
        successiva = c;
    }

    public void setPrecedente(Casella c) {
        precedente = c;
    }

    @Override
    public String toString() {
        String s="";
        return s+nome;
    }

    
}
