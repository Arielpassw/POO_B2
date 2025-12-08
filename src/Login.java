import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel Login_Panel;
    private JTextField textUsuario;
    private JTextField textpassword;
    private JButton btnIniciar;

    public Login() {
    setContentPane(Login_Panel);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);
   setLocationRelativeTo(null);
   setSize(400,400); // Para dimensionar la ventana emergente


       btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario="ariel";
                String password="arias";
                if(textUsuario.getText().equals(usuario) && textpassword.getText().equals(password)){
                    JOptionPane.showMessageDialog(null,"Bienvenido "+usuario);
                    new Bienvenido();
                    dispose(); // para cerrar la pantalla de login
                }else{
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
                    textUsuario.setText("");
                    textpassword.setText("");
                }
            }
        });
    }


}
