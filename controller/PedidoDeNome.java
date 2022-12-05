package controller;

public class PedidoDeNome extends Comunicado
{
    private String nome;
    
    public PedidoDeNome (String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String toString ()
    {
        return (""+this.nome);
    }
}