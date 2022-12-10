package controller;

public class PedidoDePosicao extends Comunicado {
    public final int CARTA;
    public PedidoDePosicao(int carta)
    {
        this.CARTA = carta;
    }

    public String toString()
    {
        return(""+this.CARTA);
    }
}
