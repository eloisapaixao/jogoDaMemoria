package controller;

public class PedidoDeNome extends Comunicado {
    public final String NOME;
    public final Integer POSICAO;
    public PedidoDeNome(String nome)
    {
        this(nome, null);
    }

    public PedidoDeNome(int posicao)
    {
        this(null, posicao);
    }

    protected PedidoDeNome(String nome, Integer posicao)
    {
        this.NOME = nome;
        this.POSICAO = posicao;
    }

    public String toString()
    {
        return(""+this.NOME+" "+this.POSICAO);
    }
}