public class PedidoDePosicao extends Comunicado
{
    private int posicao;
    
    public PedidoDePosicao (int posicao)
    {
        this.posicao = posicao;
    }
    
    public char getPosicao ()
    {
        return this.posicao;
    }
    
    public String toString ()
    {
        return (""+this.posicao);
    }
}