

import javax.swing.JButton;

public class Carta {
    private JButton botao;
    private Integer imagem;
    private Integer posicao;

    public Carta(JButton botao, Integer imagem, Integer posicao) {
        this.botao = botao;
        this.setImagem(imagem);
        this.posicao = posicao;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
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
