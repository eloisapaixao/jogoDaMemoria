import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {

        try {

            ServerSocket pedido = new ServerSocket(8080);

            Socket conexao = pedido.accept();
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}