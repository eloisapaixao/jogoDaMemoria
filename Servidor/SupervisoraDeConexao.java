package Servidor;

import controller.PedidoDePosicao;

import java.io.*;
import java.net.*;
import java.util.*;

import controller.*;

import javax.swing.*;
import Cliente.*;

public class SupervisoraDeConexao extends Thread {
    private Parceiro usuario;
    private ArrayList<Parceiro> usuarios;

    private int vez = 0;
    private List<Carta> cartas = new ArrayList<Carta>();
    private List<Icon> imagens = new ArrayList<Icon>();
    private List<Carta> cartasClicadas = new ArrayList<Carta>();

    public SupervisoraDeConexao
            (Parceiro conexao, ArrayList<Parceiro> usuarios)
            throws Exception {
        if (conexao == null)
            throw new Exception("Conexao ausente");

        if (usuarios == null)
            throw new Exception("Usuarios ausentes");

        this.usuario = conexao;
        this.usuarios = usuarios;
    }

    public void run() {
        try {
            synchronized (this.usuarios) {
                this.usuarios.add(this.usuario);
            }

            while(true) {
                System.out.println(usuarios.size());
                Comunicado comunicado = this.usuarios.get(0/*vez*/).envie();

                if (comunicado == null)
                    return;
                else if (comunicado instanceof PedidoDePosicao) {
                    PedidoDePosicao pedidoDePosicao = (PedidoDePosicao) comunicado;

                    System.out.println("posição: "+pedidoDePosicao.getPosicao());

                    synchronized (usuarios) {
                        for (int i = 0; i < usuarios.size(); i++) {
                            usuarios.get(i).receba(new PedidoDeNome("caju"));
                        }
                    }
                }
                else if(comunicado instanceof  PedidoDePontos)
                {
                    PedidoDePontos pedidoDePontos = (PedidoDePontos) comunicado;

                    System.out.println(pedidoDePontos.getPonto());

                    synchronized (usuarios) {
                        for (int i = 0; i < usuarios.size(); i++) {
                            usuarios.get(i).receba(new PedidoDeNome("caju"));
                        }
                    }
                }
                else if(comunicado instanceof  Resultado)
                {
                    Resultado resultado = (Resultado) comunicado;

                    System.out.println(resultado.getPessoaVencedora());
                    String ganhador = resultado.getPessoaVencedora();
                    synchronized (usuarios) {
                        for (int i = 0; i < usuarios.size(); i++) {
                            usuarios.get(i).receba(new PedidoDeNome(ganhador));
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
                usuario.adeus();
            } catch (Exception falha) {
            } // so tentando fechar antes de acabar a thread

            return;
        }
    }
}
