import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenido extends JFrame {
    private JPanel Bienvenido_panel;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JButton btnSuma;
    private JButton btnResta;
    private JButton btnMulti;
    private JButton btnDivision;
    private JButton btnDiv;

    public Bienvenido(){
        setTitle("Pantalla Pricipal");
        setContentPane(Bienvenido_panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        setLocationRelativeTo(null);
        setSize(400,400); // Para dimensionar la ventana emergente


        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double valor1 = Double.parseDouble(text1.getText());
                Double valor2 = Double.parseDouble(text2.getText());
                double suma = valor1 + valor2;
                text3.setText(Double.toString(suma));
            }
        });
        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double valor1 = Double.parseDouble(text1.getText());
                Double valor2 = Double.parseDouble(text2.getText());
                double resta = valor1 - valor2;
                text3.setText(Double.toString(resta));
            }
        });


        btnMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double valor1 = Double.parseDouble(text1.getText());
                Double valor2 = Double.parseDouble(text2.getText());
                double multiplicacion = valor1 * valor2;
                text3.setText(Double.toString(multiplicacion));
            }
        });


        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor1 = Double.parseDouble(text1.getText());
                double valor2 = Double.parseDouble(text2.getText());
                if (valor2 == 0){
                    JOptionPane.showMessageDialog(null,"El segundo valor no puede ser cero");
                    JOptionPane.showMessageDialog(null,"Ingrese valores correctos");
                }else{
                    double division = valor1 / valor2;
                    text3.setText(Double.toString(division));
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
