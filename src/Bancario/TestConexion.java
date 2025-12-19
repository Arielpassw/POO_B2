package Bancario;

import javax.swing.JOptionPane;
import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "ANTES DE CONECTAR");

        try {
            Connection con = ConexionBD.conectar();
            JOptionPane.showMessageDialog(null, "CONECTADO A CLEVER CLOUD");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXIÓN");
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
    }
}
