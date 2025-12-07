import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioCheckBox extends JFrame {

    private JCheckBox cbProgramacion;
    private JCheckBox cbRedes;
    private JCheckBox cbBD;
    private JCheckBox cbDiseno;
    private JCheckBox cbSeguridad;

    public FormularioCheckBox() {
        setTitle("Formulario de Intereses");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centrar ventana
        setLayout(new BorderLayout());

        //  TÍTULO
        JLabel lblTitulo = new JLabel("Seleccione sus intereses o preferencias:");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        // PANEL DE CHECKBOX
        JPanel panelChecks = new JPanel();
        panelChecks.setLayout(new GridLayout(5, 1, 5, 5));

        cbProgramacion = new JCheckBox("Programación");
        cbRedes = new JCheckBox("Redes");
        cbBD = new JCheckBox("Base de Datos");
        cbDiseno = new JCheckBox("Diseño");
        cbSeguridad = new JCheckBox("Seguridad Informática");

        panelChecks.add(cbProgramacion);
        panelChecks.add(cbRedes);
        panelChecks.add(cbBD);
        panelChecks.add(cbDiseno);
        panelChecks.add(cbSeguridad);

        add(panelChecks, BorderLayout.CENTER);

        // BOTÓN
        JButton btnProcesar = new JButton("Procesar selección");
        btnProcesar.setFont(new Font("Arial", Font.BOLD, 14));
        add(btnProcesar, BorderLayout.SOUTH);

        // ACCIÓN DEL BOTÓN
        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StringBuilder seleccion = new StringBuilder("Intereses seleccionados:\n");

                if (cbProgramacion.isSelected()) seleccion.append("- Programación\n");
                if (cbRedes.isSelected()) seleccion.append("- Redes\n");
                if (cbBD.isSelected()) seleccion.append("- Base de Datos\n");
                if (cbDiseno.isSelected()) seleccion.append("- Diseño\n");
                if (cbSeguridad.isSelected()) seleccion.append("- Seguridad Informática\n");

                // Si no selecciona nada
                if (seleccion.toString().equals("Intereses seleccionados:\n")) {
                    JOptionPane.showMessageDialog(null, "No seleccionó ningún interés.");
                    return;
                }

                JOptionPane.showMessageDialog(null, seleccion.toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioCheckBox().setVisible(true));
    }
}

