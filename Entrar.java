import java.awt.*;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

public class Entrar extends JFrame {

    protected static final long serialVersionUID = 1L;

    protected JButton btnJogar = new JButton("Jogar");

    protected JFormattedTextField txtNome  = new JFormattedTextField(),
                                  txtIP    = new JFormattedTextField(),
                                  txtPorta = new JFormattedTextField();

    protected JLabel lbNome  = new JLabel("Nome do jogador"),
                     lnIP    = new JLabel("IP: "),
                     lbPorta = new JLabel("Porta:"),
                     msg     = new JLabel();

    private BorderLayout layout;

    protected JPanel jpanel = new JPanel();

    JFrameComFundo jff = new JFrameComFundo("Jogo da Memória", "fundo.jpg");

    String ip;
    Integer porta;
    Socket conexao; 

    public Entrar() {

        super("Jogo da memória");

        Color roxo = new Color(110, 10, 120);

        layout = new BorderLayout(5, 5);
        jff.setLayout(layout);
        jff.setLayout(null);

        btnJogar.setBounds(530, 350, 150, 30);
        btnJogar.setForeground(Color.WHITE);
        jff.add(btnJogar);

        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Memoria(txtNome.getText());

                try {
                    ip = txtIP.getText();
                    porta = Integer.parseInt(txtPorta.getText());
                    conexao = new Socket(ip, porta);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"Conexão falhou!");
                }
            }
        });

        lbNome.setBounds(440, 260, 150, 90);
        lbNome.setForeground(Color.WHITE);
        txtNome.setBounds(560, 295, 200, 20);

        lnIP.setBounds(440, 200, 150, 90);
        lnIP.setForeground(Color.WHITE);
        txtIP.setBounds(560, 235, 200, 20);

        lbPorta.setBounds(440, 230, 150, 90);
        lbPorta.setForeground(Color.WHITE);
        txtPorta.setBounds(560, 265, 200, 20);

        jff.add(txtNome);
        jff.add(lbNome);
        jff.add(lnIP);
        jff.add(txtIP);
        jff.add(lbPorta);
        jff.add(txtPorta);

        jpanel.setBounds(350, 210, 500, 250);
        jpanel.setBackground(Color.BLACK);
        jff.add(jpanel);

        btnJogar.setOpaque(true);
        btnJogar.setBackground(roxo);

        jff.setBounds(240, 20, 987, 650);
        jff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jff.setVisible(true);

    }
}
