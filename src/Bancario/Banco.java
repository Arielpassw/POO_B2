package Bancario;

import javax.swing.*;
import java.sql.*;

public class Banco extends JFrame {

    private JPanel PanelBanco;
    private JButton btnDeposito;
    private JButton btnRetiro;
    private JButton btnTransferencia;
    private JButton btnSalir;
    private JTextField txtSaldo;
    private JTextArea textArea1;

    private String usuario;
    private int usuarioId;
    private double saldo;

    public Banco(String usuario, String nombre) {
        this.usuario = usuario;

        setTitle("Banco - Bienvenido " + nombre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setContentPane(PanelBanco);
        setVisible(true);

        // Cargar datos reales desde la BD
        cargarDatosUsuario();

        // ---- DEPÓSITO ----
        btnDeposito.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Ingrese monto a depositar");

            if (input == null || input.isEmpty()) return;

            try {
                double monto = Double.parseDouble(input);
                saldo += monto;
                actualizarSaldoBD();

                txtSaldo.setText(String.valueOf(saldo));
                textArea1.append("Depósito: +" + monto + "\n");
                textArea1.append("Saldo actual: " + saldo + "\n\n");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Monto inválido");
            }
        });

        // ---- RETIRO ----
        btnRetiro.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Ingrese monto a retirar");

            if (input == null || input.isEmpty()) return;

            try {
                double monto = Double.parseDouble(input);

                if (monto > saldo) {
                    JOptionPane.showMessageDialog(this, "Saldo insuficiente");
                    return;
                }

                saldo -= monto;
                actualizarSaldoBD();

                txtSaldo.setText(String.valueOf(saldo));
                textArea1.append("Retiro: -" + monto + "\n");
                textArea1.append("Saldo actual: " + saldo + "\n\n");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Monto inválido");
            }
        });

        // ---- SALIR ----
        btnSalir.addActionListener(e -> System.exit(0));
    }

    /**
     * Obtiene el ID del usuario y su saldo desde la base de datos
     */
    private void cargarDatosUsuario() {
        String sql = """
            SELECT u.id, c.saldo
            FROM usuarios u
            JOIN cuentas c ON u.id = c.usuario_id
            WHERE u.usuario = ?
        """;

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuarioId = rs.getInt("id");
                saldo = rs.getDouble("saldo");
                txtSaldo.setText(String.valueOf(saldo));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar datos del usuario");
            e.printStackTrace();
        }
    }

    /**
     * Actualiza el saldo del usuario en la base de datos
     */
    private void actualizarSaldoBD() {
        String sql = "UPDATE cuentas SET saldo=? WHERE usuario_id=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, saldo);
            ps.setInt(2, usuarioId);
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al actualizar saldo");
            e.printStackTrace();
        }
    }
}
