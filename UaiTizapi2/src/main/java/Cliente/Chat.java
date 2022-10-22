
package Cliente;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Chat extends javax.swing.JFrame {
    private String nome;
    private Socket s;
    private BufferedReader br;
    private InputStreamReader isr;
    private boolean rodar;
    
    public Chat(String nome) {
        initComponents();
        rodar = true;
        this.nome = nome;
        try{
          s = new Socket("192.168.0.102", 5000);  
        }catch(IOException e){
            showMessageDialog(null, "Não se conectou ao servidor", "",ERROR_MESSAGE);
            System.exit(0);
        }
        Thread();
    }

    private Chat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void Thread(){
        
        Thread t = new Thread(new Runnable() {
            String mensagem;
            @Override
            public void run() {
                try{
                    isr = new InputStreamReader(s.getInputStream());
                    br = new BufferedReader(isr);
                    while((mensagem = br.readLine()) != null){
                        MensagemRecebida.setText(MensagemRecebida.getText()+ mensagem + "\n");
                        if(!rodar){
                            break;
                        }
                    }
                }
                catch(IOException e){
                    showMessageDialog(null, "Erro na conexão com o servidor", "", ERROR_MESSAGE);
                }
            }
        });
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MensagemRecebida = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        Enviar = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MensagemEnviada = new javax.swing.JTextArea();
        sair = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        MensagemRecebida.setColumns(20);
        MensagemRecebida.setRows(5);
        jScrollPane1.setViewportView(MensagemRecebida);

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        Enviar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        MensagemEnviada.setColumns(20);
        MensagemEnviada.setRows(5);
        MensagemEnviada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MensagemEnviadaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(MensagemEnviada);

        sair.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sair.setText("sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Enviar))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sair)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
       String mensagem = nome + " disse: ";
       
      try{
          PrintStream tela = new PrintStream(s.getOutputStream());
          mensagem += MensagemEnviada.getText();
          tela.println(mensagem);
          tela.flush();
          MensagemEnviada.setText("");
      }catch(IOException e){
          showMessageDialog(null, "impossivel enviar esta mensagem!", "", ERROR_MESSAGE);
      }
    }//GEN-LAST:event_EnviarActionPerformed

    private void MensagemEnviadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MensagemEnviadaKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             String mensagem = nome + " disse: ";
            try{
                PrintStream tela = new PrintStream(s.getOutputStream());
                mensagem += MensagemEnviada.getText();
                tela.println(mensagem);
                tela.flush();
                MensagemEnviada.setText("");
            }catch(IOException e){
                showMessageDialog(null, "Não foi possivel enviar a mensagem!", "", ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_MensagemEnviadaKeyPressed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        
        try{
            s.close();
            
            System.exit(0);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_sairActionPerformed
    
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Enviar;
    private javax.swing.JTextArea MensagemEnviada;
    private javax.swing.JTextArea MensagemRecebida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton sair;
    // End of variables declaration//GEN-END:variables
}
