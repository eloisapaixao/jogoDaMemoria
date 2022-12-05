package controller;

public class PedidoDePontos extends Comunicado
{
    private int ponto;
    
    public PedidoDePontos (int ponto)
    {
        this.ponto = ponto;
    }
    
    public int getPonto ()
    {
        return this.ponto;
    }
    
    public String toString ()
    {
        return (""+this.ponto);
    }
}