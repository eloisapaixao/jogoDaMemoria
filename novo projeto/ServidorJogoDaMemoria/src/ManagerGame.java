import controller.Baralho;
import java.util.List;

public class ManagerGame {
    private List<Cliente> players;
    private Baralho baralho;
    private int turn;

    public void addPlayer(Cliente value) throws Exception
    {
        if(players.size() > 2)
            throw new Exception("Limite de Jogadores atingido!");

        players.add(value);
    }
    public Baralho getBaralho()
    {
        return baralho;
    }

    public Cliente[] getPlayers()
    {
        Cliente[] clients = new Cliente[players.size()];
        players.toArray(clients);
        return clients;
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

    public void changeTurn()
    {
        if(turn == 1)
            turn = 0;
        else turn = 1;
    }
}
