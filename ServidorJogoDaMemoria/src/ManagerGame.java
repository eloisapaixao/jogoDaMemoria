import controller.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ManagerGame {
    private List<Cliente> players;
    public final Baralho baralho;
    private boolean[] cartasViradas;
    private int turn;

    private Integer cartaA;

    public ManagerGame()
    {
        this.baralho = new Baralho();
        this.players = new ArrayList<>();
        this.cartasViradas = new boolean[baralho.cartas.length];
        for (int i = 0; i < cartasViradas.length; i++)
            cartasViradas[i] = false;
        this.turn = 0;
    }

    public void sendObjectAllPlayers(Comunicado comunicado) throws Exception
    {
        for(Cliente player : players)
            player.PARCEIRO.sendObject(comunicado);
    }

    public void sendObjcetToPlayer(Comunicado comunicado, int index) throws Exception
    {
        players.get(index).PARCEIRO.sendObject(comunicado);
    }

    public void addPlayer(Cliente value) throws Exception
    {
        if(players.size() > 2)
            throw new Exception("Limite de Jogadores atingido!");

        players.add(value);
    }

    public void reveleCarta(int index) throws Exception
    {
        if(cartasViradas[index])
            return;
        int carta = baralho.cartas[index];
        sendObjectAllPlayers(new EnviaCarta(carta, index));
        System.out.println("Carta revelada: " + carta);

        if(cartaA == null)
            cartaA = index;
        else {
            if(baralho.cartas[cartaA] == carta)
            {
                cartasViradas[cartaA] = true;
                cartasViradas[index] = true;
                players.get(turn).addScore(1);

                sendObjectAllPlayers(new EnviaPontos(players.get(turn).getScore(), turn));
                if(isFinish())
                {
                    sendObjectAllPlayers(new EnviaResultado(getPlayerVencedor()));
                    System.exit(0);
                }
            }
            else
            {
                changeTurn();
                sendObjectAllPlayers(new EnviaVez(turn));
            }
            cartaA = null;
        }
    }

    protected boolean isFinish() {
        for(boolean cartaVirada : cartasViradas)
            if(!cartaVirada)
                return false;
        return true;
    }

    public Cliente[] getPlayers()
    {
        Cliente[] clients = new Cliente[players.size()];
        players.toArray(clients);
        return clients;
    }

    public String getPlayerVencedor() {
        int maior = 0;
        int indexMaior = 0;

        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getScore() > maior)
            {
                maior = players.get(i).getScore();
                indexMaior = i;
            }
        }

        return players.get(indexMaior).USERNAME;
    }

    public int getLastPlayer()
    {
        return players.size() - 1;
    }

    public boolean isStarted()
    {
        if(players.size() < 2)
            return false;

        for (Cliente c: players)
            if(!c.isStarted())
                return false;

        return true;
    }

    protected void changeTurn()
    {
        turn = (turn == 0) ? 1 : 0;
    }
}
