package gestion.crud;

import gestion.modelo.Alumno;
import gestion.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoCrud {
	 // Registrar un alumno
    public void insertar(Alumno alumno) throws SQLException {

        String sql = "INSERT INTO alumnos "
                + "(nombre, nota1, nota2, matriculado) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setDouble(2, alumno.getNota1());
            ps.setDouble(3, alumno.getNota2());
            ps.setBoolean(4, alumno.isMatriculado());

            ps.executeUpdate();

            System.out.println("Alumno registrado correctamente.");
        }
    }

    // Consultar todos los alumnos
    public List<Alumno> listar() throws SQLException {

        List<Alumno> alumnos = new ArrayList<>();

        String sql = "SELECT * FROM alumnos";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Estructura repetitiva while
            while (rs.next()) {

                Alumno alumno = new Alumno();

                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setNota1(rs.getDouble("nota1"));
                alumno.setNota2(rs.getDouble("nota2"));
                alumno.setMatriculado(
                    rs.getBoolean("matriculado")
                );

                alumnos.add(alumno);
            }
        }

        return alumnos;
    }

    // Eliminar un alumno por ID
    public void eliminar(int id) throws SQLException {

        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Alumno eliminado.");
            } else {
                System.out.println("No existe ese alumno.");
            }
        }
    }
}
