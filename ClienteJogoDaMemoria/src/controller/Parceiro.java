package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Parceiro {
    public final Socket conexao;
    private final ObjectInputStream receptor;
    private final ObjectOutputStream transmissor;

    public Parceiro (Socket conexao)
            throws Exception //se parametro nulos
    {
        if (conexao == null)
            throw new Exception ("Conexao ausente");

        this.conexao = conexao;
        this.transmissor = new ObjectOutputStream(conexao.getOutputStream());
        this.receptor = new ObjectInputStream(conexao.getInputStream());
    }

    public void close() throws Exception
    {
        try {
            receptor.close();
            transmissor.close();
            conexao.close();
        }
        catch (Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }

    public void sendObject(Comunicado x) throws Exception
    {
        try
        {
            this.transmissor.writeObject (x);
            this.transmissor.flush       ();
        } //vai mandar a acao para o servidor
        catch (IOException erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro de transmissao");
        }
    }

    public Comunicado getObject() throws Exception
    {
        try {
            return (Comunicado)this.receptor.readObject();
        }
        catch (Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
}
