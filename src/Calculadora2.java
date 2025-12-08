import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora2 {
    private JPanel Panel2;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JButton btnSumar;
    private JButton btnResta;
    private JButton btnMultiplicacion;
    private JButton btnDivision;

    public Calculadora2() {
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double num1 = Double.parseDouble(text1.getText()); // Con el "parseDouble" cambiamos el tipo String a un dato double (Decimal)
                Double num2 = Double.parseDouble(text2.getText());
                Double resultado = num1 + num2;
                text3.setText(Double.toString(resultado));
            }
        });


        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double num1 = Double.parseDouble(text1.getText());
                Double num2 = Double.parseDouble(text2.getText());
                Double resultado = num1 - num2;
                text3.setText(Double.toString(resultado));
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double num1 = Double.parseDouble(text1.getText());
                Double num2 = Double.parseDouble(text2.getText());
                Double resultado = num1 * num2;
                text3.setText(Double.toString(resultado));
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double num1 = Double.parseDouble(text1.getText());
                Double num2 = Double.parseDouble(text2.getText());
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(null, "El segundo número no puede ser 0");
                    JOptionPane.showMessageDialog(null, "Ingrese números válidos");
                }
                else  {
                    Double resultado = num1 / num2;
                    text3.setText(Double.toString(resultado));
                }
            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora2");
        frame.setContentPane(new Calculadora2().Panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true); // Para que se vizualice la parte de la ventana emergente
        frame.setLocationRelativeTo(null); // Ocupamos para que nos muestre la ventana emergente en el centro
        frame.setSize(400,400); // Para dimensionar la ventana emergente
    }
}
