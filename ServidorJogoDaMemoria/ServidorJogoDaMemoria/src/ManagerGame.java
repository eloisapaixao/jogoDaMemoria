import controller.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ManagerGame {
    private List<Cliente> players;
    public final Baralho baralho;
    private Vector<Integer> cartasViradas;
    private int turn;

    private Integer cartaA;

    public ManagerGame()
    {
        this.baralho = new Baralho();
        this.players = new ArrayList<>();
        this.cartasViradas = new Vector<>();
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
        int carta = baralho.cartas[index];

        if(cartaA == null)
            cartaA = carta;
        else {
            if(cartaA == carta)
            {
                players.get(turn).addScore(1);
                sendObjectAllPlayers(new EnviaCarta(carta));
                sendObjectAllPlayers(new EnviaPontos(players.get(turn).getScore(), turn));
                cartasViradas.add(carta);
                cartasViradas.add(cartaA);
                if(cartasViradas.size() == 18)
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
