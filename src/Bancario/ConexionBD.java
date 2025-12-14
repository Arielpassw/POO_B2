package Bancario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/DB_Banco";
        String user = "root";
        String password = "2004Franzu";
        return DriverManager.getConnection(url, user, password);
    }
}

