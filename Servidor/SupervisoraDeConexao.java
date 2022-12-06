package Servidor;

import controller.PedidoDePosicao;

import java.io.*;
import java.net.*;
import java.util.*;

import controller.*;

import javax.swing.*;

public class SupervisoraDeConexao extends Thread {
    private Parceiro usuario;
    private Socket conexao;
    private ArrayList<Parceiro> usuarios;

    private int vez = 0;
    private List<Carta> cartas = new ArrayList<Carta>();
    private List<Icon> imagens = new ArrayList<Icon>();
    private List<Carta> cartasClicadas = new ArrayList<Carta>();

    public SupervisoraDeConexao
            (Socket conexao, ArrayList<Parceiro> usuarios)
            throws Exception {
        if (conexao == null)
            throw new Exception("Conexao ausente");

        if (usuarios == null)
            throw new Exception("Usuarios ausentes");

        this.conexao = conexao;
        this.usuarios = usuarios;
    }

    public void run() {

        ObjectOutputStream transmissor;
        try {
            transmissor =
                    new ObjectOutputStream(
                            this.conexao.getOutputStream());
        } catch (Exception erro) {
            return;
        }

        ObjectInputStream receptor = null;
        try {
            receptor = new ObjectInputStream(this.conexao.getInputStream());
        } catch (Exception err0) {
            try {
                transmissor.close();
            } catch (Exception falha) {
            }

            return;
        }
        try {
            this.usuario =
                    new Parceiro(this.conexao,
                            receptor,
                            transmissor);
        } catch (Exception erro) {
        }

        try {
            synchronized (this.usuarios) {
                this.usuarios.add(this.usuario);
            }

            for (; ;) {
                System.out.println(usuarios.size());
                Comunicado comunicado = this.usuarios.get(0/*vez*/).envie();

                if (comunicado == null)
                    return;
                else if (comunicado instanceof PedidoDePosicao) {
                    PedidoDePosicao pedidoDePosicao = (PedidoDePosicao) comunicado;

                    System.out.println(pedidoDePosicao.getPosicao());

                    synchronized (usuarios) {
                        for (int i = 0; i < usuarios.size(); i++) {
                            usuarios.get(i).receba(new PedidoDeNome("caju"));
                        }
                    }
                }
//                else if (comunicado instanceof PedidoDeNome)
//                {
//                    this.usuario.receba (new Resultado (this.valor));
//                }
//                else if (comunicado instanceof PedidoDePosicao)
//                {synchronized
//                     (this.usuarios)
//                    {
//                        this.usuarios.remove (this.usuario);
//                    }
//                    this.usuario.adeus();
//                }
//                 else if (comunicado instanceof PedidoDeResultado)
//                {
//                    synchronized (this.usuarios)
//                    {
//                        this.usuarios.remove (this.usuario);
//                    }
//                    this.usuario.adeus();
//                }

                vez++;
                vez = vez % 2;
            }
        } catch (Exception erro) {
            try {
                transmissor.close();
                receptor.close();
            } catch (Exception falha) {
            } // so tentando fechar antes de acabar a thread

            return;
        }
    }
}
