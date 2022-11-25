
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

public class Memoria extends JFrame {

    protected JLabel jogador1 = new JLabel("Jogador 1"),
            jogador2 = new JLabel("jogador 2"),
            x = new JLabel("X"),
            pt1 = new JLabel("0"),
            pt2 = new JLabel("0");

    private String nome;
    private Integer pontos = 0;

    private JPanel ponto1 = new JPanel(),
            ponto2 = new JPanel();
    private boolean[] cartasJaClicadasDoJogo = new boolean[18];

    private List<Carta> cartas = new ArrayList<Carta>();
    private List<Icon> imagens = new ArrayList<Icon>();
    private List<Carta> cartasClicadas = new ArrayList<Carta>();
    Icon card = new ImageIcon("imagens/card.jpg");

    private void embaralharCartas() {
        Integer[] imagensCartas = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9 };

        List<Integer> intList = Arrays.asList(imagensCartas);

        Collections.shuffle(intList);

        intList.toArray(imagensCartas);

        for (int i = 0; i < 18; i++) {
            JButton botao = new JButton(card);
            Carta carta = new Carta(botao, imagensCartas[i], i);
            cartas.add(carta);
        }
    }

    private void definirImagens() {
        Icon[] icon = { new ImageIcon("imagens/turmaDaMonica.jpg"),
                new ImageIcon("C:/Users/u22127/Documents/GitHub/jogoDaMemoria/imagens/looney-tunes.jpg"),
                new ImageIcon("imagens/padrinhosMagicos.jpg"),
                new ImageIcon("imagens/perry-o-ornitorrinco.png"),
                new ImageIcon("imagens/Rei-LEao.jpg"),
                new ImageIcon("imagens/scoobDoo.jpg"),
                new ImageIcon("imagens/stitch.jpg"),
                new ImageIcon("imagens/mickey.jpg"),
                new ImageIcon("imagens/tresespias.jpg")
        };
        for (int i = 0; i < 9; i++) {
            imagens.add(icon[i]);
        }
    }

    private JPanel painel;

    protected Memoria(String nome) {
        super("Jogo da Memória");

        this.nome = nome;

        painel = new JPanel();
        this.add(painel);
        painel.setLayout(null);

        List<Integer[]> posicoes = new ArrayList<Integer[]>();
        Integer[] posicao1 = { 10, 100, 150, 150 };
        posicoes.add(posicao1);
        Integer[] posicao2 = { 170, 100, 150, 150 };
        posicoes.add(posicao2);
        Integer[] posicao3 = { 330, 100, 150, 150 };
        posicoes.add(posicao3);
        Integer[] posicao4 = { 490, 100, 150, 150 };
        posicoes.add(posicao4);
        Integer[] posicao5 = { 650, 100, 150, 150 };
        posicoes.add(posicao5);
        Integer[] posicao6 = { 810, 100, 150, 150 };
        posicoes.add(posicao6);
        Integer[] posicao7 = { 10, 270, 150, 150 };
        posicoes.add(posicao7);
        Integer[] posicao8 = { 170, 270, 150, 150 };
        posicoes.add(posicao8);
        Integer[] posicao9 = { 330, 270, 150, 150 };
        posicoes.add(posicao9);
        Integer[] posicao10 = { 490, 270, 150, 150 };
        posicoes.add(posicao10);
        Integer[] posicao11 = { 650, 270, 150, 150 };
        posicoes.add(posicao11);
        Integer[] posicao12 = { 810, 270, 150, 150 };
        posicoes.add(posicao12);
        Integer[] posicao13 = { 10, 440, 150, 150 };
        posicoes.add(posicao13);
        Integer[] posicao14 = { 170, 440, 150, 150 };
        posicoes.add(posicao14);
        Integer[] posicao15 = { 330, 440, 150, 150 };
        posicoes.add(posicao15);
        Integer[] posicao16 = { 490, 440, 150, 150 };
        posicoes.add(posicao16);
        Integer[] posicao17 = { 650, 440, 150, 150 };
        posicoes.add(posicao17);
        Integer[] posicao18 = { 810, 440, 150, 150 };
        posicoes.add(posicao18);

        embaralharCartas();
        definirImagens();

        for (int i = 0; i < cartas.size(); i++) {
            JButton botao = cartas.get(i).getBotao();
            painel.add(botao);
            botao.setBounds(
                    posicoes.get(i)[0],
                    posicoes.get(i)[1],
                    posicoes.get(i)[2],
                    posicoes.get(i)[3]);

            Integer position = i;

            botao.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (!cartasJaClicadasDoJogo[position]) {
                        cartasJaClicadasDoJogo[position] = true;

                        if (cartasClicadas.size() < 2) {
                            cartasClicadas.add(cartas.get(position));
                            Integer posicaoImagem = cartas.get(position).getImagem();
                            Icon icon = imagens.get(posicaoImagem - 1);
                            botao.setIcon(icon);
                        }
                        if (cartasClicadas.size() == 2) {
                            if (cartasClicadas.get(0).getImagem() != cartasClicadas.get(1).getImagem()) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                cartasClicadas.get(0).getBotao().setIcon(card);
                                cartasJaClicadasDoJogo[cartasClicadas.get(0).getPosicao()] = false;
                                cartasClicadas.get(1).getBotao().setIcon(card);
                                cartasJaClicadasDoJogo[cartasClicadas.get(1).getPosicao()] = false;
                            } else {
                                pontos++;
                                pt1.setText(pontos + "");
                            }

                            cartasClicadas = new ArrayList<Carta>();
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