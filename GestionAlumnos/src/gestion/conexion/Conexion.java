package gestion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL ="jdbc:mariadb://localhost:3306/gestion_alumnos";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "5465";

	    /**
	     * Establece la conexión con MariaDB.
	     *
	     * @return conexión a la base de datos.
	     * @throws SQLException si falla la conexión.
	     */
	    public static Connection conectar() throws SQLException {

	        return DriverManager.getConnection(
	            URL, USUARIO, PASSWORD
	        );
	    }
}
