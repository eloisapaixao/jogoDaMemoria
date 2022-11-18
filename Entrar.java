import java.awt.*;
import javax.swing.*;

public class Entrar extends JFrame {

    protected static final long serialVersionUID = 1L;

    protected JButton btnJogar = new JButton("Jogar");

    protected JFormattedTextField txtNome = new JFormattedTextField();

    protected JLabel lbNome = new JLabel("Nome do jogador");

    private BorderLayout layout;

    protected JPanel jpanel = new JPanel();

    JFrameComFundo jff = new JFrameComFundo("Jogo da Memória", "fundo.jpg");

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
                new Memoria();
            }
        });

        lbNome.setBounds(440, 250, 150, 90);
        lbNome.setForeground(Color.WHITE);
        txtNome.setBounds(560, 285, 200, 20);

        jff.add(txtNome);
        jff.add(lbNome);

        jpanel.setBounds(350, 210, 500, 250);
        jpanel.setBackground(Color.BLACK);
        jff.add(jpanel);

        btnJogar.setOpaque(true);
        btnJogar.setBackground(roxo);

        jff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jff.setVisible(true);

    }
}
