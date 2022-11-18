import java.awt.*;
import javax.swing.*;

class JPanelComFundo extends JPanel
{
	private ImageIcon imagem;

	public JPanelComFundo (String nomeFundo)
	{
		super ();
		this.imagem = new ImageIcon (nomeFundo);
		this.setPreferredSize(new Dimension (imagem.getIconWidth(), imagem.getIconHeight()));
	}

	public void paintComponent (Graphics grafico)
	{
		super.paintComponent (grafico);
		grafico.drawImage (this.imagem.getImage(), 0, 0, this);
	}
}