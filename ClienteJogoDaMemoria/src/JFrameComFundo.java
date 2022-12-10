import javax.swing.*;
import java.awt.*;

public class JFrameComFundo extends JFrame {
    public JFrameComFundo(String nomeFundo) {
        super();

        JPanelComFundo painel = new JPanelComFundo(nomeFundo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painel);
        this.pack();
        this.setResizable(false);

        Insets ocupadoTela = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        Dimension totalTela = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraUtil = totalTela.width - (ocupadoTela.left + ocupadoTela.right);
        int alturaUtil = totalTela.height - (ocupadoTela.top + ocupadoTela.bottom);

        this.setLocation(ocupadoTela.left + (larguraUtil - this.getWidth()) / 2,
                ocupadoTela.top + (alturaUtil - this.getHeight()) / 2);
    }

    public JFrameComFundo(String titulo, String nomeImagem) {
        this(nomeImagem);
        this.setTitle(titulo);
    }
}
