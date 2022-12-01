public class PedidoDeOperacao extends Comunicado
{
    private int posicao;
    
    public PedidoDeOperacao (int posicao)
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
