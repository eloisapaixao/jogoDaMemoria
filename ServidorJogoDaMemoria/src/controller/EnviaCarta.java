package controller;

public class EnviaCarta extends Comunicado {
    public final int CARTA;
    public final int POSICAO;
    public EnviaCarta(int carta, int posicao)
    {
        this.CARTA = carta;
        this.POSICAO = posicao;
    }
}
