package Servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.*;

import controller.*;

public class AceitadoraDeConexao extends Thread
{
    private ServerSocket        pedido;
    private ArrayList<Parceiro> usuarios;
    private Baralho             baralho;

    public AceitadoraDeConexao
    (String porta, ArrayList<Parceiro> usuarios)
    throws Exception
    {
        if (porta==null)
            throw new Exception ("Porta ausente");

        try
        {
            this.pedido =
            new ServerSocket (Integer.parseInt(porta));
        }
        catch (Exception  erro)
        {
            throw new Exception ("Porta invalida");
        }

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.usuarios = usuarios;
        this.baralho = new Baralho();
    }

    public void run ()
    {
        while(true)
        {
            Socket conexao=null;
            try
            {
                conexao = this.pedido.accept();
            }
            catch (Exception erro)
            {
                continue;
            }

            SupervisoraDeConexao supervisoraDeConexao=null;
            try
            {
                ObjectOutputStream transmissor;
                try {
                    transmissor =
                            new ObjectOutputStream(
                                    conexao.getOutputStream());
                } catch (Exception erro) {
                    return;
                }

                ObjectInputStream receptor = null;
                try {
                    receptor = new ObjectInputStream(conexao.getInputStream());
                } catch (Exception err0) {
                    try {
                        transmissor.close();
                    } catch (Exception falha) {
                    }

                    return;
                }
                try {
                    Parceiro jogador = new Parceiro(conexao,
                            receptor,
                            transmissor);
                    jogador.receba(this.baralho);
                    supervisoraDeConexao =
                            new SupervisoraDeConexao (jogador, usuarios);
                } catch (Exception erro) {
                }
            }
            catch (Exception erro)
            {} 
            supervisoraDeConexao.start();
        }
    }
} 
