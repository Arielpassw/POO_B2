import java.nio.channels.SelectionKey;
import java.sql.*;
import java.nio.channels.SelectionKey;


public class MainPost {
    public static void main(String[] args) throws SQLException {


        String url = "jdbc:postgresql://localhost:5432/almacen";
        String user = "postgres";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM usuarios_cliente";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String correo = resultSet.getString("correo");
            String clave = resultSet.getString("clave");
            System.out.println(id + " | " + nombre + " | " + correo + " | " + clave);
        }

        if(connection != null){
            System.out.println("Conectado con existo");
            connection.close();
        }
        else {
            System.out.println("No se puede conectar con el BD");
        }

    }
}

