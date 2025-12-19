package Bancario;

import javax.swing.*;
import java.sql.*;

public class Login_bancario extends JFrame {

    private JPanel Log_bancario;
    private JTextField textUser;
    private JButton btnIngreso;
    private JPasswordField password;

    // Contador de intentos fallidos
    private int intentos = 0;

    public Login_bancario() {

        setTitle("Login Bancario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(Log_bancario);
        setVisible(true);

        btnIngreso.addActionListener(e -> {
            try {
                validarLogin();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error de conexión con la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Valida las credenciales del usuario contra la base de datos.
     * Permite el acceso solo si el usuario existe, la contraseña es correcta
     * y el usuario se encuentra activo.
     */
    private void validarLogin() throws SQLException {

        String user = textUser.getText().trim();
        String pass = String.valueOf(password.getPassword()).trim();

        // Validación de campos vacíos
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese usuario y contraseña",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql = "SELECT nombre FROM usuarios " +
                "WHERE usuario=? AND contraseña=? AND activo=1";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    String nombre = rs.getString("nombre");

                    JOptionPane.showMessageDialog(this,
                            "Bienvenido/a " + nombre);

                    // Se abre la ventana principal del banco
                    Banco banco = new Banco(user, nombre);
                    banco.setVisible(true);
                    dispose();

                } else {

                    intentos++;
                    JOptionPane.showMessageDialog(this,
                            "Credenciales incorrectas (" + intentos + "/3)",
                            "Error", JOptionPane.ERROR_MESSAGE);

                    // Bloqueo por 3 intentos fallidos
                    if (intentos == 3) {
                        JOptionPane.showMessageDialog(this,
                                "Acceso bloqueado por 3 intentos fallidos",
                                "Bloqueado", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
