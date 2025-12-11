import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Banco extends JFrame {
    private JPanel PanelBanco;
    private JButton btnDeposito;
    private JButton btnRetiro;
    private JButton btnTransferencia;
    private JButton btnSalir;
    private JTextField txtSaldo;
    private JTextArea textArea1;

    private double saldo = 1000.00;  // saldo inicial

    public Banco() {
        setTitle("Banco Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        setContentPane(PanelBanco);
        setVisible(true);

        // Mostrar saldo inicial
        txtSaldo.setText(String.valueOf(saldo));

        // ---- DEPÓSITO ----
        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Ingresa el monto a depositar");

                if (input != null && !input.isEmpty()) {
                    double monto = Double.parseDouble(input);
                    saldo += monto;
                    txtSaldo.setText(String.valueOf(saldo));

                    textArea1.append("Depósito: +" + monto + "\n");
                    textArea1.append("Saldo actual: " + saldo + "\n\n");
                    JOptionPane.showMessageDialog(null,"Deposito correctamente");
                }
            }
        });

        // ---- RETIRO ----
        btnRetiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String input = JOptionPane.showInputDialog(null, "Ingresa el monto a retirar");

                if (input != null && !input.isEmpty()) {
                    double monto = Double.parseDouble(input);

                    if (monto > saldo) {
                        JOptionPane.showMessageDialog(null, "Error: saldo insuficiente");
                        return;
                    }

                    saldo -= monto;
                    txtSaldo.setText(String.valueOf(saldo));

                    textArea1.append("Retiro: -" + monto + "\n");
                    textArea1.append("Saldo actual: " + saldo + "\n\n");
                    JOptionPane.showMessageDialog(null,"Retiro correctamente");
                }
            }
        });


        // ---- TRANSFERENCIA ----
        btnTransferencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Solicitar nombre del destinatario
                String destinatario = JOptionPane.showInputDialog(
                        null, "Ingrese el nombre del destinatario");

                if (destinatario == null || destinatario.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido.");
                    return;
                }

                // Solicitar monto a transferir
                String inputMonto = JOptionPane.showInputDialog(
                        null, "Ingrese el monto a transferir");

                if (inputMonto == null || inputMonto.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un monto válido.");
                    return;
                }

                double monto;

                try {
                    monto = Double.parseDouble(inputMonto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Monto inválido. Ingrese un número.");
                    return;
                }

                // Validar saldo suficiente
                if (monto > saldo) {
                    JOptionPane.showMessageDialog(null, "Error: saldo insuficiente para transferir.");
                    return;
                }

                // Realizar transferencia
                saldo -= monto;

                // Actualizar saldo en el formulario
                txtSaldo.setText(String.valueOf(saldo));

                // Mensaje de confirmación
                JOptionPane.showMessageDialog(null,
                        "Transferencia exitosa a " + destinatario +
                                " por $" + monto);

                // Registrar historial
                textArea1.append("Transferencia a " + destinatario + ": -" + monto + "\n");
                textArea1.append("Saldo actual: " + saldo + "\n\n");
            }
        });


        // ---- SALIR ----
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
