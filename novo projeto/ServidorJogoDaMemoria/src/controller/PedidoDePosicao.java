package controller;

public class PedidoDePosicao extends Comunicado {
    public final String POSICAO;
    public PedidoDePosicao(String posicao){this.POSICAO = posicao;}

    public String getPESSOAVENCEDORA(){
        return this.POSICAO;
    }

    public String toString()
    {
        return(""+this.POSICAO);
    }
}
