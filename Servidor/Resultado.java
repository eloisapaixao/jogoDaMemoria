public class Resultado extends Comunicado
{
    private String pessoaVencedora;
    public Resultado (String pessoaVencedora)
    {
        this.pessoaVencedora = pessoaVencedora;
    }

    public double getPessoaVencedora ()
    {
        return this.pessoaVencedora;
    }
    
    public String toString ()
    {
		return (""+this.pessoaVencedora);
	}

}
