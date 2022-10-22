package com.mycompany.uaitizapi2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
    public static void main(String[] args) {
        try{
            ServerSocket serve = new ServerSocket(5000);
            Socket socket;
            String MensagemRecebida;
            
            while(true){
                socket = serve.accept();
                InputStreamReader ler = new InputStreamReader(socket.getInputStream());    
                BufferedReader buffer = new BufferedReader(ler);
                
                while((MensagemRecebida = buffer.readLine()) != null){
                    System.out.println(MensagemRecebida);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
