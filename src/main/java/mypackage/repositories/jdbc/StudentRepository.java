package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Student;
import mypackage.repositories.interfaces.I_StudentRepository;

public class StudentRepository implements I_StudentRepository {

    private final Connection conexionDB;
    private static final String TABLE_NAME = "students";

    public StudentRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Student student) {
        if (student == null) {
            return;
        }

        String sql = "INSERT INTO " + TABLE_NAME +
                "(id, nombre, apellido, edad, genero, grado, " +
                "matricula, correo_electronico, numero_telefono, " +
                "semestre, cantidad_hs_escolares, mesada) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = conexionDB.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getNombre());
            ps.setString(3, student.getApellido());
            ps.setInt(4, student.getEdad());
            ps.setString(5, student.getGenero());
            ps.setString(6, student.getGrado());
            ps.setString(7, student.getMatricula());
            ps.setString(8, student.getCorreo_electronico());
            ps.setString(9, student.getNumero_telefono());
            ps.setString(10, student.getSemestre());
            ps.setInt(11, student.getCantidad_hs_escolares());
            ps.setFloat(12, student.getMesada());

            ps.executeUpdate();

            try (ResultSet queryResults = ps.getGeneratedKeys()) {
                if (queryResults.next()) {
                    student.setId(queryResults.getInt(1));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Student student) {
        if (student == null) {
            return;
        }

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=?";

        try (PreparedStatement ps = conexionDB.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        if (student == null) {
            return;
        }

        String sql = "UPDATE " + TABLE_NAME + " SET " +
                "nombre=?, apellido=?, edad=?, genero=?, grado=?, " +
                "matricula=?, correo_electronico=?, numero_telefono=?, " +
                "semestre=?, cantidad_hs_escolares=?, mesada=? " +
                "WHERE id=?";

        try (PreparedStatement ps = conexionDB.prepareStatement(sql)) {

            ps.setString(1, student.getNombre());
            ps.setString(2, student.getApellido());
            ps.setInt(3, student.getEdad());
            ps.setString(4, student.getGenero());
            ps.setString(5, student.getGrado());
            ps.setString(6, student.getMatricula());
            ps.setString(7, student.getCorreo_electronico());
            ps.setString(8, student.getNumero_telefono());
            ps.setString(9, student.getSemestre());
            ps.setInt(10, student.getCantidad_hs_escolares());
            ps.setFloat(11, student.getMesada());
            ps.setInt(12, student.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (PreparedStatement ps = conexionDB.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                studentList.add(new Student(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("genero"),
                        rs.getString("grado"),
                        rs.getString("matricula"),
                        rs.getString("correo_electronico"),
                        rs.getString("numero_telefono"),
                        rs.getString("semestre"),
                        rs.getInt("cantidad_hs_escolares"),
                        rs.getFloat("mesada")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return studentList;
    }
}