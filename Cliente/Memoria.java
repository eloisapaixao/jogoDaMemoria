package Cliente;

import java.awt.Color;
import java.awt.Font;
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

public class Memoria extends JFrame {
    protected JLabel jogador1 = new JLabel("Jogador 1"),
            jogador2 = new JLabel("jogador 2");

    private JLabel x = new JLabel("X");
    private JLabel pt1 = new JLabel("0");
    private JLabel pt2 = new JLabel("0");

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

    public void embaralharCartas() {
        Integer[] imagensCartas = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};

        List<Integer> intList = Arrays.asList(imagensCartas);

        Collections.shuffle(intList);

        intList.toArray(imagensCartas);

        for (int i = 0; i < 18; i++) {
            JButton botao = new JButton(card);
            Carta carta = new Carta(botao, imagensCartas[i], i);
            cartas.add(carta);

        }
    }

    public void definirImagens() {
        Icon[] icon = {new ImageIcon("imagens/turmaDaMonica_resized.jpg"),
                new ImageIcon("imagens/looney-tunes_resized.jpg"),
                new ImageIcon("imagens/padrinhosMagicos_resized.jpg"),
                new ImageIcon("imagens/perry-o-ornitorrinco_resized.png"),
                new ImageIcon("imagens/Rei-LEao_resized.jpg"),
                new ImageIcon("imagens/scoobDoo_resized.jpg"),
                new ImageIcon("imagens/toyStory_resized.webp"),
                new ImageIcon("imagens/mickey_resized.jpg"),
                new ImageIcon("imagens/tresespias_resized.jpg")
        };
        for (int i = 0; i < 9; i++) {
            imagens.add(icon[i]);
        }
    }

    JPanel painel;

    protected Memoria(String nome, String ip, int porta) throws Exception {

        super("Jogo da Memória");

       this.nome = nome;
        this.ip = ip;
        this.porta = porta;

        Socket conexao = null;
        try {
            conexao = new Socket(this.ip, this.porta);
        } catch (Exception erro) {
            throw new Exception("porta: " + porta+ " ip: "+ip);
        }

        ObjectOutputStream transmissor = null;
        try {
            transmissor =
                    new ObjectOutputStream(
                            conexao.getOutputStream());
        } catch (Exception erro) {
            throw new Exception("Indique o servidor e a porta corretos!\n");
        }

        ObjectInputStream receptor = null;
        try {
            receptor =
                    new ObjectInputStream(
                            conexao.getInputStream());
        } catch (Exception erro) {
            throw new Exception("Indique o servidor e a porta corretos!\n");
        }

        Parceiro servidorparca = null;
        try {
            servidorparca =
                    new Parceiro(conexao, receptor, transmissor);
        } catch (Exception erro) {
            throw new Exception("Indique o servidor e a porta corretos!\n");
        }

        /*TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
        try {
            tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento(servidor);
        } catch (Exception erro) {
        }

        tratadoraDeComunicadoDeDesligamento.start();*/


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

        embaralharCartas();
        definirImagens();

        int cartasSize = cartas.size();

        for (int i = 0; i < cartasSize; i++) {
            JButton botao = cartas.get(i).getBotao();
            painel.add(botao);
            botao.setBounds(
                    posicoes.get(i)[0],
                    posicoes.get(i)[1],
                    posicoes.get(i)[2],
                    posicoes.get(i)[3]);

            Integer position = i;

            // Evento do botao:
            botao.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (!cartasJaClicadasDoJogo[position]) {
                        cartasJaClicadasDoJogo[position] = true;

                        if (cartasClicadas.size() < 2) {
                            cartasClicadas.add(cartas.get(position)); // Adiciona no array de cartas clicadas.
                            Integer posicaoImagem = cartas.get(position).getImagem(); // Pega a posição da imagem do array daqui.
                            Icon icon = imagens.get(posicaoImagem - 1); // Pega a imagem do array daqui.

                            botao.setIcon(icon); // Muda a imagem do botao, vulgo "gira a carta".

                        }
                        botao.validate();
                        botao.repaint();
                        if (cartasClicadas.size() == 2) {
                            if (cartasClicadas.get(0).getImagem() != cartasClicadas.get(1).getImagem()) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                /*Timer timer = new Timer(1000, new ActionListener(){
                                    public void actionPerformed(ActionEvent e) {
                                        // do something
                                    }
                                });
                                timer.setRepeats(false);
                                timer.start();*/

                                cartasClicadas.get(0).getBotao().setIcon(card); // Desvira
                                cartasJaClicadasDoJogo[cartasClicadas.get(0).getPosicao()] = false; // Marca como desvirada.

                                cartasClicadas.get(1).getBotao().setIcon(card); // Desvira.
                                cartasJaClicadasDoJogo[cartasClicadas.get(1).getPosicao()] = false; // Marca como desvirada.

                            } else {
                                pontos++;
                                pt1.setText(pontos + "");

                                if(pontos==9) {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    new Ganhador(nome);
                                }
                            }

                            cartasClicadas = new ArrayList<Carta>(); // Tá ok
                        }

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
}