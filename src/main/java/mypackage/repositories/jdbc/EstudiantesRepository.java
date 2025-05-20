package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Student;
import mypackage.repositories.interfaces.I_EstudiantesRepository;

public class EstudiantesRepository implements I_EstudiantesRepository {

    private Connection conexionDB;

    public EstudiantesRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Student student) {
        if (student == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO empleados(id,nombre,apellido,edad,genero,tipo_documento,"
                        + " numero_documento,correo_electronico,numero_telefono,fecha_inicio,cantidad_hs_semanales,sueldo)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, student.getId());
                    consultaPreparada.setString(2, student.getNombre());
                    consultaPreparada.setString(3, student.getApellido());
                    consultaPreparada.setInt(4, student.getEdad());
                    consultaPreparada.setString(5, student.getGenero());
                    consultaPreparada.setString(6, student.getTipo_documento());
                    consultaPreparada.setString(7, student.getNumero_de_matricula());
                    consultaPreparada.setString(8, student.getCorreo_electronico());
                    consultaPreparada.setString(9, student.getNumero_telefono());
                    consultaPreparada.setString(10, student.getFecha_inicio());
                    consultaPreparada.setInt(11, student.getSemestreEquivalente());
                    consultaPreparada.setFloat(12, student.getPromedio());

                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        student.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    @Override
    public void remove(Student student) {
        if (student == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM empleados WHERE id=?")) {

            consultaPreparada.setInt(1, student.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        if (student == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE empleados SET nombre=?,apellido=?,edad=?,genero=?,tipo_documento=?,"
                        + " numero_documento=?,correo_electronico=?,numero_telefono=?,fecha_inicio=?,cantidad_hs_semanales=?,sueldo=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, student.getNombre());
            consultaPreparada.setString(2, student.getApellido());
            consultaPreparada.setInt(3, student.getEdad());
            consultaPreparada.setString(4, student.getGenero());
            consultaPreparada.setString(5, student.getTipo_documento());
            consultaPreparada.setString(6, student.getNumero_de_matricula());
            consultaPreparada.setString(7, student.getCorreo_electronico());
            consultaPreparada.setString(8, student.getNumero_telefono());
            consultaPreparada.setString(9, student.getFecha_inicio());
            consultaPreparada.setInt(10, student.getSemestreEquivalente());
            consultaPreparada.setFloat(11, student.getPromedio());
            consultaPreparada.setInt(12, student.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {

        List<Student> listaStudents = new ArrayList();

        try ( ResultSet resultSetEmpleados
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM empleados")) {
                    while (resultSetEmpleados.next()) {

                        listaStudents.add(new Student(
                                resultSetEmpleados.getInt("id"),
                                resultSetEmpleados.getString("nombre"),
                                resultSetEmpleados.getString("apellido"),
                                resultSetEmpleados.getInt("edad"),
                                resultSetEmpleados.getString("genero"),
                                resultSetEmpleados.getString("tipo_documento"),
                                resultSetEmpleados.getString("numero_documento"),
                                resultSetEmpleados.getString("correo_electronico"),
                                resultSetEmpleados.getString("numero_telefono"),
                                resultSetEmpleados.getString("fecha_inicio"),
                                resultSetEmpleados.getInt("cantidad_hs_semanales"),
                                resultSetEmpleados.getFloat("sueldo")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaStudents;
    }

}
