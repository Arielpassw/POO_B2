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
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        setContentPane(Log_bancario);
        setVisible(true);

        btnIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textUser.getText();
                String pass = String.valueOf(password.getPassword());

                if (user.equals("cliente123") && pass.equals("clave456")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido al Sistema Bancario.");
                    Banco banco = new Banco();
                    banco.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                }
            }
        });
    }
}
