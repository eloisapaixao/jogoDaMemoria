import java.util.*;

public class Servidor
{
	//public static String PORTA_PADRAO = "3000";
	
    public static void main (String[] args)
    {
        if (args.length>1)
        {
            throw new Exception("Uso esperado: java Servidor [PORTA]\n"); //thow
            return;
        }

        String porta=Servidor.PORTA_PADRAO; //porta 
        
        if (args.length==1)
            porta = args[0]; //sem

        ArrayList<Parceiro> usuarios =
        new ArrayList<Parceiro> ();

        AceitadoraDeConexao aceitadoraDeConexao=null;
        try
        {
            aceitadoraDeConexao =
            new AceitadoraDeConexao (porta, usuarios);
            aceitadoraDeConexao.start();
        }
        catch (Exception erro)
        {
            throw new Exception ("Escolha uma porta apropriada e liberada para uso!\n"); //throw
            return;
        }

        for(;;)
        {
            throw new Exception ("O servidor esta ativo! Para desativa-lo, use o comando \"desativar\"\n");
            String comando=null;
            try
            {
                comando = Teclado.getUmString();
            }
            catch (Exception erro)
            {}
            /*
            if (comando.toLowerCase().equals("desativar"))
            {
                synchronized (usuarios)
                {
					ComunicadoDeDesligamento comunicadoDeDesligamento =
                    new ComunicadoDeDesligamento ();
                    
                    for (Parceiro usuario:usuarios)
                    {
                        try
                        {
                            usuario.receba (comunicadoDeDesligamento);
                            usuario.adeus  ();
                        }
                        catch (Exception erro)
                        {}
                    }
                }

                System.out.println ("O servidor foi desativado!\n");
                System.exit(0);
            } //desativa
            else
                throw new Exception ("Comando invalido!\n");*/
                //nessa parte comentada, eu teria que fazer um  desse para cada pedido?
        }
    }
}
