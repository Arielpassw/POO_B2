package Bancario;

import javax.swing.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login_bancario extends JFrame {

    private JPanel Log_bancario;
    private JTextField textUser;
    private JButton btnIngreso;
    private JPasswordField password;

    private int intentos = 0;

    public Login_bancario() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);
        setContentPane(Log_bancario);
        setVisible(true);

        btnIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    validarLogin();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Error de conexión con la base de datos");
                }
            }
        });
    }

    private void validarLogin() throws SQLException {

        String user = textUser.getText();
        String pass = String.valueOf(password.getPassword());

        Connection con = ConexionBD.conectar();

        String sql = "SELECT * FROM usuarios " +
                "WHERE usuario=? AND contraseña=? AND activo=1";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            String nombre = rs.getString("nombre");

            JOptionPane.showMessageDialog(null,
                    "Bienvenido/a " + nombre);

            Banco banco = new Banco(user, nombre);
            banco.setVisible(true);
            dispose();

        } else {

            intentos++;
            JOptionPane.showMessageDialog(null,
                    "Credenciales incorrectas (" + intentos + "/3)");

            if (intentos == 3) {
                JOptionPane.showMessageDialog(null,
                        "Acceso bloqueado por 3 intentos fallidos");
                System.exit(0);
            }
        }

        con.close();
    }
}
