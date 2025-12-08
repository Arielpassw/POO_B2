import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JPanel panel;
    private JTextField text3;
    private JTextField text2;
    private JTextField text1;
    private JButton btnResta;
    private JButton btnMultiplicacion;
    private JButton btnDivision;
    private JButton btnSuma;

    public Calculadora() {
        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(text1.getText());
                double num2 = Double.parseDouble(text2.getText());
                double resultado = num1 + num2 ;
                text3.setText(Double.toString(resultado));
            }
        });
        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(text1.getText());
                double num2 = Double.parseDouble(text2.getText());
                double resultado = num1 - num2;
                text3.setText(Double.toString(resultado));
            }
        });

       btnMultiplicacion.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               double num1 = Double.parseDouble(text1.getText());
               double num2 = Double.parseDouble(text2.getText());
               double resultado = num1 * num2;
               text3.setText(Double.toString(resultado));

           }
       });

       btnDivision.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               double num1 = Double.parseDouble(text1.getText());
               double num2 = Double.parseDouble(text2.getText());
               if (num2 == 0) {
                   JOptionPane.showMessageDialog(null, "El segundo número no puede ser 0");
                   JOptionPane.showMessageDialog(null, "Ingrese números válidos");
               }
               else  {
                   double resultado = num1 / num2;
                   text3.setText(Double.toString(resultado));
               }
           }
       });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
    }
}
