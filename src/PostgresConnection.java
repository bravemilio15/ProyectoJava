
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class PostgresConnection {

    public void conexion(int puntaje, int tiempo, String nombre) {
        // Establecer la información de conexión
        
        
        
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=Proyecto1";

        String user = "postgres";
        String password = "1234";

        try {
            // Cargar el driver de Postgres
            Class.forName("org.postgresql.Driver");

            // Establecer la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            // Preparar la sentencia SQL con PreparedStatement
            String sql = "INSERT INTO \"Proyecto1\".proyecto (nombre, puntaje, tiempo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre );
            statement.setDouble(2,puntaje);
            statement.setInt(3, tiempo);

            // Ejecutar la sentencia SQL
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se inserto el nuevo proyecto con exito");
            }

            // Cerrar la conexión y la sentencia
            statement.close();
            connection.close();

            // Cerrar la conexión
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO proyecto (nombre, puntaje, tiempo) VALUES (?, ?, ?)";

    }
}
