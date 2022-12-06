package Cliente;

import java.awt.*;
import javax.swing.*;
public class Ganhador extends JFrame {
    protected static final long serialVersionUID = 1L;

    protected JButton btnJogar = new JButton("Jogar novamente");
    protected JLabel fimDeJogo = new JLabel("Fim de Jogo!!!"),
            lbComemoracao = new JLabel("O ganhador foi "),
            lbNome = new JLabel();
    private BorderLayout layout;

    protected JPanel jpanel = new JPanel();

    JFrameComFundo jff = new JFrameComFundo("Jogo da Memória", "imagens/FundoFesta_resized.png");

    String nomeGanhador;

    public Ganhador(String nomeGanhador)
    {
        super("Jogo da memória");

        Color roxo = new Color(110, 10, 120);

        layout = new BorderLayout(5, 5);
        jff.setLayout(layout);
        jff.setLayout(null);

        fimDeJogo.setFont(new Font("Verdana", Font.PLAIN, 40));
        lbNome.setFont(new Font("Verdana", Font.PLAIN, 40));
        lbComemoracao.setFont(new Font("Verdana", Font.PLAIN, 40));

        fimDeJogo.setBounds(420, 100, 900, 90);
        fimDeJogo.setForeground(Color.BLACK);
        jff.add(fimDeJogo);



        lbNome.setText(nomeGanhador);

        lbComemoracao.setBounds(420, 150, 900, 90);
        lbComemoracao.setForeground(Color.BLACK);
        jff.add(lbComemoracao);

        lbNome.setBounds(500, 200, 900, 90);
        lbNome.setForeground(Color.BLACK);
        jff.add(lbNome);

        btnJogar.setBounds(480, 290, 150, 30);
        btnJogar.setForeground(Color.WHITE);
        jff.add(btnJogar);

        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new Entrar();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jpanel.setBounds(300, 110, 500, 250);
        jpanel.setBackground(Color.YELLOW);
        jff.add(jpanel);

        jff.setBounds(240, 20, 987, 650);
        jff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jff.setVisible(true);

        btnJogar.setOpaque(true);
        btnJogar.setBackground(roxo);


    }
}
