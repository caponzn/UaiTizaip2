package Cliente;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
public class Cliente1 {
    public static void main(String[] args) {;
        String nome = showInputDialog(null, "Digite seu nome: "," ", PLAIN_MESSAGE);
        Chat chat = new Chat(nome);
        chat.setVisible(true);
    }
}
