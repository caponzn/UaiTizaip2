package Servidor;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class Servidor {
    public static void main(String[] args) {
        ArrayList<PrintStream> clientes = new ArrayList<>();
        try{
            ServerSocket serve = new ServerSocket(5000);
            Socket socket;
            System.out.println("Servidor On");
            while(true){
                socket = serve.accept();
               clientes.add(new PrintStream(socket.getOutputStream()));
               Mensagem mensagem = new Mensagem(socket, clientes);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
