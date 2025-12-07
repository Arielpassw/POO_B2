import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOperaciones extends JFrame {

    private JTextField txtValor1;
    private JTextField txtValor2;
    private JTextField txtResultado;

    public VentanaOperaciones() {
        setTitle("Operaciones Matemáticas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        setLayout(new GridLayout(5, 2, 10, 10));

        // Etiquetas
        add(new JLabel("Valor 1:"));
        txtValor1 = new JTextField();
        add(txtValor1);

        add(new JLabel("Valor 2:"));
        txtValor2 = new JTextField();
        add(txtValor2);

        add(new JLabel("Resultado:"));
        txtResultado = new JTextField();
        txtResultado.setEditable(false);
        add(txtResultado);

        // Botones
        JButton btnSumar = new JButton("Sumar");
        JButton btnRestar = new JButton("Restar");
        JButton btnMultiplicar = new JButton("Multiplicar");
        JButton btnDividir = new JButton("Dividir");

        // Agregar botones al panel
        add(btnSumar);
        add(btnRestar);
        add(btnMultiplicar);
        add(btnDividir);

        // Acciones de los botones
        btnSumar.addActionListener(new OperacionListener("+"));
        btnRestar.addActionListener(new OperacionListener("-"));
        btnMultiplicar.addActionListener(new OperacionListener("*"));
        btnDividir.addActionListener(new OperacionListener("/"));
    }

    private class OperacionListener implements ActionListener {

        private String operacion;

        public OperacionListener(String operacion) {
            this.operacion = operacion;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double v1 = Double.parseDouble(txtValor1.getText());
                double v2 = Double.parseDouble(txtValor2.getText());
                double resultado = 0;

                switch (operacion) {
                    case "+":
                        resultado = v1 + v2;
                        break;
                    case "-":
                        resultado = v1 - v2;
                        break;
                    case "*":
                        resultado = v1 * v2;
                        break;
                    case "/":
                        if (v2 == 0) {
                            JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
                            return;
                        }
                        resultado = v1 / v2;
                        break;
                }

                txtResultado.setText(String.valueOf(resultado));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese solo números válidos");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaOperaciones().setVisible(true));
    }
}
