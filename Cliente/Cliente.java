package Cliente;

/*import java.net.*;
import java.io.*;

public class Cliente
{
	public String ip;
	public int    porta;

	public static void main (String[] args)
	{*/


            /*System.out.print ("Sua opcao (+, -, *, /, =, [T]erminar)? ");

            try
            {
				opcao = Character.toUpperCase(controller.Teclado.getUmChar());
		    }
		    catch (Exception erro)
		    {
				System.err.println ("Opcao invalida!\n");
				continue;
			}

			if ("+-=T".indexOf(opcao)==-1)
		    {
				System.err.println ("Opcao invalida!\n");
				continue;
			}

			try
			{
				double valor=0;
				if ("+-".indexOf(opcao)!=-1)
				{
					System.out.print ("Valor? ");
					try
					{
						valor = controller.Teclado.getUmDouble();
						System.out.println();
						
						if (opcao=='/' && valor==0)
						{
							System.err.println ("Valor invalido!\n");
							continue;
						}
					}
					catch (Exception erro)
					{
						System.err.println ("Valor invalido!\n");
						continue;
					}*/


					/*servidor.receba (new PedidoDeOperacao (opcao,valor));
				}
				else if (opcao=='=')
				{
					servidor.receba (new PedidoDeResultado ());
					Comunicado comunicado = null;
					do
					{
						comunicado = (Comunicado)servidor.espie ();
					}
					while (!(comunicado instanceof Resultado));
					Resultado resultado = (Resultado)servidor.envie ();
					System.out.println ("Resultado atual: "+resultado.getValorResultante()+"\n");*/
			// 	}
			// }
			// catch (Exception erro)
			// {
			// 	System.err.println ("Erro de comunicacao com o servidor;");
			// 	System.err.println ("Tente novamente!");
			// 	System.err.println ("Caso o erro persista, termine o programa");
			// 	System.err.println ("e volte a tentar mais tarde!\n");
			// }//throw
        /*}
        while (opcao != 'T');

		try
		{
			servidor.receba (new PedidoParaSair ());
		}
		catch (Exception erro)
		{}
		
		System.out.println ("Obrigado por usar este programa!");
		System.exit(0);
	}
}*/
