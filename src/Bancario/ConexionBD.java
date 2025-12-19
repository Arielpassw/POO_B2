package Bancario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://bv65fjcidrdhoqrefng2-mysql.services.clever-cloud.com:3306/bv65fjcidrdhoqrefng2"
                    + "?useSSL=true"
                    + "&requireSSL=true"
                    + "&verifyServerCertificate=false"
                    + "&serverTimezone=UTC"
                    + "&allowPublicKeyRetrieval=true";

    private static final String USER = "um0fus60m1mffu1y";
    private static final String PASSWORD = "XzzzSA5CdSstdbYovTgG";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
