package controller;

public class PedidoDeResultado extends Comunicado {
    public final String PESSOAVENCEDORA;
    public PedidoDeResultado(String pessoaVendora){this.PESSOAVENCEDORA = pessoaVendora;}

    public String getPESSOAVENCEDORA(){
        return this.PESSOAVENCEDORA;
    }

    public String toString()
    {
        return(""+this.PESSOAVENCEDORA);
    }
}