import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_bancario extends JFrame {
    private JPanel Log_bancario;
    private JTextField textUser;
    private JButton btnIngreso;
    private JPasswordField password;

    public Login_bancario() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setContentPane(Log_bancario);

        btnIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textUser.getText();
                char[] passArray = password.getPassword();
                String pass = new String(passArray);

                if (user.equals("cliente123") && pass.equals("clave456")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido al Sistema Bancario.");
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                }

            }
        });
    }
}
