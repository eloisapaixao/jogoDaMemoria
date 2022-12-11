package controller;

public class EnviaPontos extends Comunicado {
    public final int PONTOS;
    public final int PLAYER;
    public EnviaPontos(int pontos, int player)
    {
        this.PONTOS = pontos;
        this.PLAYER = player;
    }
}