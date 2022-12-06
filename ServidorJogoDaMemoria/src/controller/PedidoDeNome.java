package controller;

public class PedidoDeNome extends Comunicado {
    public final String NOME;
    public PedidoDeNome(String nome){this.NOME = nome;}

    public String getPESSOAVENCEDORA(){
        return this.NOME;
    }

    public String toString()
    {
        return(""+this.NOME);
    }
}