    import javax.swing.*;
    import java.awt.*;

    public class FormularioEncuesta extends JFrame {

        public FormularioEncuesta() {
            setTitle("Encuesta");
            setSize(350, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(4, 1));

            // Pregunta 1
            JRadioButton p1_si = new JRadioButton("Sí");
            JRadioButton p1_aveces = new JRadioButton("A veces");
            JRadioButton p1_no = new JRadioButton("No");
            ButtonGroup g1 = new ButtonGroup();
            g1.add(p1_si); g1.add(p1_aveces); g1.add(p1_no);

            JPanel q1 = new JPanel();
            q1.add(new JLabel("¿Deseas seguir una maestría?"));
            q1.add(p1_si); q1.add(p1_aveces); q1.add(p1_no);

            // Pregunta 2
            JRadioButton p2_si = new JRadioButton("Sí");
            JRadioButton p2_aveces = new JRadioButton("A veces");
            JRadioButton p2_no = new JRadioButton("No");
            ButtonGroup g2 = new ButtonGroup();
            g2.add(p2_si); g2.add(p2_aveces); g2.add(p2_no);

            JPanel q2 = new JPanel();
            q2.add(new JLabel("¿Te gusta programar?"));
            q2.add(p2_si); q2.add(p2_aveces); q2.add(p2_no);

            // Pregunta 3
            JRadioButton p3_si = new JRadioButton("Sí");
            JRadioButton p3_aveces = new JRadioButton("A veces");
            JRadioButton p3_no = new JRadioButton("No");
            ButtonGroup g3 = new ButtonGroup();
            g3.add(p3_si); g3.add(p3_aveces); g3.add(p3_no);

            JPanel q3 = new JPanel();
            q3.add(new JLabel("¿Estudias mejor de noche?"));
            q3.add(p3_si); q3.add(p3_aveces); q3.add(p3_no);

            // Botón
            JButton enviar = new JButton("Enviar respuestas");
            enviar.addActionListener(e -> {
                String r1 = seleccion(g1);
                String r2 = seleccion(g2);
                String r3 = seleccion(g3);

                JOptionPane.showMessageDialog(this,
                        "Resultados:\n1. " + r1 + "\n2. " + r2 + "\n3. " + r3);
            });

            add(q1); add(q2); add(q3); add(enviar);
        }

        private String seleccion(ButtonGroup g) {
            for (var e = g.getElements(); e.hasMoreElements(); ) {
                AbstractButton rb = e.nextElement();
                if (rb.isSelected()) return rb.getText();
            }
            return "Sin respuesta";
        }

        public static void main(String[] args) {
            new FormularioEncuesta().setVisible(true);
        }
    }
