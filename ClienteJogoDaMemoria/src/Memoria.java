
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.io.*;
import java.net.*;

import controller.*;

import javax.swing.*;

public class Memoria extends JFrame implements Runnable {
    protected JLabel jogador1 = new JLabel("Jogador 1"),
            jogador2 = new JLabel("jogador 2");

    Icon[] botoesIcon = {new ImageIcon("imagens/turmaDaMonica_resized.jpg"),
            new ImageIcon("imagens/looney-tunes_resized.jpg"),
            new ImageIcon("imagens/padrinhosMagicos_resized.jpg"),
            new ImageIcon("imagens/perry-o-ornitorrinco_resized.png"),
            new ImageIcon("imagens/Rei-LEao_resized.jpg"),
            new ImageIcon("imagens/scoobDoo_resized.jpg"),
            new ImageIcon("imagens/toyStory_resized.webp"),
            new ImageIcon("imagens/mickey_resized.jpg"),
            new ImageIcon("imagens/tresespias_resized.jpg")
    };

    String[] botoesNome =
            {
                "Turma da Mônica",
                "Looney Tunes",
                "Os Padrinhos Mágicos",
                "Perry o Ornitorrinco",
                "O Rei Leão",
                "Scooby Doo",
                "Toy Story",
                "Mickey",
                "Três Espiãs Demais"
            };
    private Parceiro servidor;
    private JLabel x = new JLabel("X");
    private JLabel pt1 = new JLabel("0");
    private JLabel pt2 = new JLabel("0");
    private int turn = 0;
    private int playerIndex = 0;
    private Integer CartaInA;
    private Integer CartaInB;
    private String nome, ip;
    private int porta;
    private Integer pontos = 0;
    private JPanel ponto1 = new JPanel(),
            ponto2 = new JPanel();
    private boolean[] cartasJaClicadasDoJogo = new boolean[18];
    private List<Carta> cartas = new ArrayList<Carta>();
    private List<Icon> imagens = new ArrayList<Icon>();
    private List<Carta> cartasClicadas = new ArrayList<Carta>();
    private Icon card = new ImageIcon("imagens/card.png");
    JPanel painel;

    protected Memoria(Parceiro servidor, String nome) throws Exception {

        super("Jogo da Memória");

        this.servidor = servidor;
        this.nome = nome;

        new Thread(this).start();

        painel = new JPanel();
        this.add(painel);
        painel.setLayout(null);

        List<Integer[]> posicoes = new ArrayList<Integer[]>();
        Integer[] posicao1 = {10, 100, 150, 150};
        posicoes.add(posicao1);
        Integer[] posicao2 = {170, 100, 150, 150};
        posicoes.add(posicao2);
        Integer[] posicao3 = {330, 100, 150, 150};
        posicoes.add(posicao3);
        Integer[] posicao4 = {490, 100, 150, 150};
        posicoes.add(posicao4);
        Integer[] posicao5 = {650, 100, 150, 150};
        posicoes.add(posicao5);
        Integer[] posicao6 = {810, 100, 150, 150};
        posicoes.add(posicao6);
        Integer[] posicao7 = {10, 270, 150, 150};
        posicoes.add(posicao7);
        Integer[] posicao8 = {170, 270, 150, 150};
        posicoes.add(posicao8);
        Integer[] posicao9 = {330, 270, 150, 150};
        posicoes.add(posicao9);
        Integer[] posicao10 = {490, 270, 150, 150};
        posicoes.add(posicao10);
        Integer[] posicao11 = {650, 270, 150, 150};
        posicoes.add(posicao11);
        Integer[] posicao12 = {810, 270, 150, 150};
        posicoes.add(posicao12);
        Integer[] posicao13 = {10, 440, 150, 150};
        posicoes.add(posicao13);
        Integer[] posicao14 = {170, 440, 150, 150};
        posicoes.add(posicao14);
        Integer[] posicao15 = {330, 440, 150, 150};
        posicoes.add(posicao15);
        Integer[] posicao16 = {490, 440, 150, 150};
        posicoes.add(posicao16);
        Integer[] posicao17 = {650, 440, 150, 150};
        posicoes.add(posicao17);
        Integer[] posicao18 = {810, 440, 150, 150};
        posicoes.add(posicao18);

        for (int i = 0; i < 18; i++) {
            JButton botao = new JButton();
            painel.add(botao);
            botao.setBounds(
                    posicoes.get(i)[0],
                    posicoes.get(i)[1],
                    posicoes.get(i)[2],
                    posicoes.get(i)[3]
            );

            Integer position = i;

            // Evento do botao:
            botao.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        if(turn == playerIndex)
                            servidor.sendObject(new PedidoDePosicao(position));
                    } catch (Exception erro) {
                        JOptionPane.showMessageDialog(null, "Erro ao enviar pedido de posição");
                    }
                }
            });
        }

        Font jogador = new Font("Arial", Font.BOLD, 20);
        Font x1 = new Font("Arial", Font.BOLD, 40);

        jogador1.setBounds(340, 40, 100, 25);
        jogador1.setFont(jogador);
        jogador1.setText(nome);

        jogador2.setBounds(540, 40, 100, 25);
        jogador2.setFont(jogador);

        x.setBounds(475, 40, 100, 25);
        x.setFont(x1);

        pt1.setForeground(Color.WHITE);
        pt1.setBounds(15, 2, 40, 40);
        pt1.setFont(jogador);

        pt2.setForeground(Color.WHITE);
        pt2.setBounds(15, 2, 40, 40);
        pt2.setFont(jogador);

        ponto1.setBounds(280, 30, 40, 40);
        ponto1.setBackground(Color.BLACK);
        ponto1.setLayout(null);
        ponto1.add(pt1);

        ponto2.setBounds(650, 30, 40, 40);
        ponto2.setBackground(Color.BLACK);
        ponto2.setLayout(null);
        ponto2.add(pt2);

        painel.add(jogador1);
        painel.add(jogador2);
        painel.add(x);
        painel.add(ponto1);
        painel.add(ponto2);

        this.setBounds(240, 20, 987, 650);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void run(){
        while(true) {
            try {
                Comunicado comunicado = servidor.getObject();
                if(comunicado instanceof PedidoDeNome) {
                    var com = (PedidoDeNome) comunicado;
                    System.out.println(com);
                    if(com.POSICAO != null)
                        playerIndex = com.POSICAO;
                    if(com.NOME != null)
                        jogador2.setText(com.NOME);
                }
                if(comunicado instanceof EnviaCarta) {
                    var carta = (EnviaCarta)comunicado;
                    System.out.println("carta recebida: "+ carta.CARTA);
                    Component botao = painel.getComponent(carta.POSICAO);
                    int indexCarta = carta.CARTA - 1;

                    if(CartaInA == null)
                        CartaInA = carta.POSICAO;
                    else
                        CartaInB = carta.POSICAO;

                    ((JButton)(botao)).setText(botoesNome[indexCarta]);
                }
                if(comunicado instanceof EnviaPontos)
                {
                    var com = (EnviaPontos)comunicado;
                    if(com.PLAYER == playerIndex)
                    {
                        pt1.setText(String.valueOf(com.PONTOS));
                    }
                    else
                    {
                        pt2.setText(String.valueOf(com.PONTOS));
                    }

                    cartasJaClicadasDoJogo[CartaInA] = true;
                    cartasJaClicadasDoJogo[CartaInB] = true;
                }

                if(comunicado instanceof EnviaVez)
                {
                    var com = (EnviaVez)comunicado;
                    System.out.println("vez recebida: "+ com.VEZ);
                    turn = com.VEZ;
                    CartaInA = null;
                    CartaInB = null;
                    if(turn != playerIndex)
                    {
                        JOptionPane.showMessageDialog(null, "Aguarde sua vez");
                    }
                    for (int i = 0; i < 18; i++) {
                        if(cartasJaClicadasDoJogo[i]) continue;
                        Component botao = painel.getComponent(i);
                        ((JButton)(botao)).setText(" ");
                    }
                }
                if(comunicado instanceof EnviaResultado)
                {
                    var com = (EnviaResultado)comunicado;
                    System.out.println("resultado recebido: "+ com.PESSOAVENCEDORA);
                    new Ganhador(com.PESSOAVENCEDORA);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}