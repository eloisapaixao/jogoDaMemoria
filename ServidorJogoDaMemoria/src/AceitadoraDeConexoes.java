import controller.*;

import java.net.ServerSocket;
import java.net.Socket;

public class AceitadoraDeConexoes extends Thread {
    public final ServerSocket server;
    public final ManagerGame manager;

    public AceitadoraDeConexoes(ServerSocket server)
    {
        this.server = server;
        this.manager = new ManagerGame();
    }

    public void run()
    {
        while(true)
        {
            try {
                Parceiro cliente = new Parceiro(server.accept());

                new SupervisoraDeConexao(cliente).start();
            } catch (Exception e) {
                System.err.println("Erro ao aceitar conexão!");
            }
        }
    }

    protected class SupervisoraDeConexao extends Thread {
        public final Parceiro PARCEIRO;

        public SupervisoraDeConexao(Parceiro parceiro)
        {
            this.PARCEIRO = parceiro;
        }

        public void run()
        {
            while(true)
            {
                try {
                    Comunicado comunicado = PARCEIRO.getObject();
                    if(comunicado instanceof PedidoDeNome)
                    {
                        var pedido = (PedidoDeNome)comunicado;
                        System.out.println("Nome recebido: " + pedido.NOME);
                        manager.addPlayer(new Cliente(pedido.NOME, PARCEIRO));

                        PARCEIRO.sendObject(new PedidoDeNome(manager.getLastPlayer()));
                        if(manager.getLastPlayer() == 1) {
                            manager.sendObjcetToPlayer(pedido, 0);
                            manager.sendObjcetToPlayer(new PedidoDeNome(manager.getPlayers()[0].USERNAME), 1);
                        }
                    }
                    if(comunicado instanceof PedidoDePosicao)
                    {
                        var pedido = (PedidoDePosicao)comunicado;

                        System.out.println("Posição recebida: " + pedido.CARTA);
                        manager.reveleCarta(pedido.CARTA);
                    }
                    if(comunicado instanceof PedidoDeSair)
                    {
                        manager.sendObjectAllPlayers(new PedidoDeSair());
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.err.println("Erro em SupervisoraDeConexao! "+e.getMessage());
                    System.exit(0);
                }
            }
        }
    }
}
