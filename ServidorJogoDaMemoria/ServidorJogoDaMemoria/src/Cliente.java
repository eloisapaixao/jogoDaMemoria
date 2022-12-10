import controller.Parceiro;

public class Cliente {
    final Parceiro PARCEIRO;
    final String USERNAME;
    private boolean started;
    private int score;

    public Cliente(String username, Parceiro parceiro)
    {
        this.USERNAME = username;
        this.PARCEIRO = parceiro;
    }

    public int getScore()
    {
        return score;
    }

    public void addScore(int value)
    {
        this.score += value;
    }

    public void setScore(int value)
    {
        this.score = value;
    }

    public boolean isStarted()
    {
        return started;
    }

    public void close() throws Exception
    {
        this.PARCEIRO.close();
    }
}
