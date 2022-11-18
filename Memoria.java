import java.awt.*;
import javax.swing.*;

public class Memoria extends JFrame {

    private JButton botao1 = new JButton("botao1"),
            botao2 = new JButton("botao2"),
            botao3 = new JButton("botao3"),
            botao4 = new JButton("botao4"),
            botao5 = new JButton("botao5"),
            botao6 = new JButton("botao6"),
            botao7 = new JButton("botao7"),
            botao8 = new JButton("botao8"),
            botao9 = new JButton("botao9"),
            botao10 = new JButton("botao10"),
            botao11 = new JButton("botao11"),
            botao12 = new JButton("botao12"),
            botao13 = new JButton("botao13"),
            botao14 = new JButton("botao14"),
            botao15 = new JButton("botao15"),
            botao16 = new JButton("botao16"),
            botao17 = new JButton("botao17"),
            botao18 = new JButton("botao18");

    private JPanel painel;

    protected Memoria() {
        super("Jogo da Memória");

        painel = new JPanel();
        this.add(painel);
        painel.setLayout(null);

        painel.add(botao1);
        botao1.setBounds(10, 100, 150, 150);

        painel.add(botao2);
        botao2.setBounds(170, 100, 150, 150);

        painel.add(botao3);
        botao3.setBounds(330, 100, 150, 150);

        painel.add(botao4);
        botao4.setBounds(490, 100, 150, 150);

        painel.add(botao5);
        botao5.setBounds(650, 100, 150, 150);

        painel.add(botao6);
        botao6.setBounds(810, 100, 150, 150);

        painel.add(botao7);
        botao7.setBounds(10, 270, 150, 150);

        painel.add(botao8);
        botao8.setBounds(170, 270, 150, 150);

        painel.add(botao9);
        botao9.setBounds(330, 270, 150, 150);

        painel.add(botao10);
        botao10.setBounds(490, 270, 150, 150);

        painel.add(botao11);
        botao11.setBounds(650, 270, 150, 150);

        painel.add(botao12);
        botao12.setBounds(810, 270, 150, 150);

        painel.add(botao13);
        botao13.setBounds(10, 440, 150, 150);

        painel.add(botao14);
        botao14.setBounds(170, 440, 150, 150);

        painel.add(botao15);
        botao15.setBounds(330, 440, 150, 150);

        painel.add(botao16);
        botao16.setBounds(490, 440, 150, 150);

        painel.add(botao17);
        botao17.setBounds(650, 440, 150, 150);

        painel.add(botao18);
        botao18.setBounds(810, 440, 150, 150);

        botao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                ((JButton) evt.getSource()).setBackground(Color.GREEN);
                // controle.selecionarBotao((JButton)evt.getSource(), Boolean.TRUE);
                // ((JButton)evt.getSource()).setText(controle.getNmBotao());

            }
        });

        this.setBounds(240, 20, 987, 650);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}