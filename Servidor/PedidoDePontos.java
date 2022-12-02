public class PedidoDePontos extends Comunicado
{
    private int ponto;
    
    public PedidoDePontos (int ponto)
    {
        this.ponto = ponto;
    }
    
    public char getPonto ()
    {
        return this.ponto;
    }
    
    public String toString ()
    {
        return (""+this.ponto);
    }
}