
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

public class Memoria extends JFrame {
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
            Carta carta = new Carta(botao, imagensCartas[i]);
            cartas.add(carta);
        }
    }

    private void definirImagens() {
        Icon[] icon = {new ImageIcon("imagens/turmaDaMonica.jpg"), 
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

    protected Memoria() {
        super("Jogo da Memória");

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
                            cartasClicadas.get(1).getBotao().setIcon(card);
                        }

                        cartasClicadas = new ArrayList<Carta>();
                    }
                }
            });
        }

        this.setBounds(240, 20, 987, 650);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}