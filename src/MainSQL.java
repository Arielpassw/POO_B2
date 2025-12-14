import java.sql.*;
import java.sql.Statement;

public class MainSQL {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/almacen";
        String user = "root";
        String password = "2004Franzu";
        Connection connection = DriverManager.getConnection(url,user,password);

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM usuarios_cliente";
        ResultSet resultSet = statement.executeQuery(sql);
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
