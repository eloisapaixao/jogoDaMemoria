import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {
    public static void main(String[] args)
    {
        try {
            ServerSocket server = new ServerSocket(3000);
            new AceitadoraDeConexoes(server).start();
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor!");
            System.exit(0);
        }
    }
}
