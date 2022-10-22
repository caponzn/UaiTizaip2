package Servidor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
public class Mensagem {
    private Socket s;
    private ArrayList<PrintStream> Clientes;


    public Mensagem(Socket s, ArrayList<PrintStream> Clientes) {
        this.s = s;
        this.Clientes = Clientes;
        theard();
    }
    private void theard(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String mensagem = " ";
                try{
                    InputStreamReader isr = new InputStreamReader(s.getInputStream());
                    BufferedReader br = new BufferedReader(isr);

                    while((mensagem = br.readLine()) != null){
                        enviarMensagem(mensagem);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
    private void enviarMensagem(String mensagem){
        for(int i = 0; i < Clientes.size(); i++){
            Clientes.get(i).println(mensagem);
            Clientes.get(i).flush();
        }
    }
}
