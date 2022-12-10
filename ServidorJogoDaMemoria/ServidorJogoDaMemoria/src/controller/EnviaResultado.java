package controller;

public class EnviaResultado extends Comunicado {
    public final String PESSOAVENCEDORA;
    public EnviaResultado(String pessoaVendora)
    {
        this.PESSOAVENCEDORA = pessoaVendora;
    }

    public String toString()
    {
        return(""+this.PESSOAVENCEDORA);
    }
}