import javax.swing.JButton;

public class Carta {
    private JButton botao;
    private Integer imagem;

    public Carta(JButton botao, Integer imagem) {
        this.botao = botao;
        this.setImagem(imagem);
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    public JButton getBotao() {
        return botao;
    }

    public void setBotao(JButton botao) {
        this.botao = botao;
    }
}
