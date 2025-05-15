package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Student;
import mypackage.repositories.interfaces.I_StudentRepository;

public class StudentRepository implements I_StudentRepository {

    private Connection conexionDB;

    public StudentRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Student student) {
        if (student == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO students(id,nombre,apellido,edad,genero,facultad,"
                        + "carrera,correo_institucional,numero_telefono,semestre,promedio)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, student.getId());
                    consultaPreparada.setString(2, student.getNombre());
                    consultaPreparada.setString(3, student.getApellido());
                    consultaPreparada.setInt(4, student.getEdad());
                    consultaPreparada.setString(5, student.getGenero());
                    consultaPreparada.setString(6, student.getFacultad());
                    consultaPreparada.setString(7, student.getCarrera());
                    consultaPreparada.setString(8, student.getCorreo_istitucional());
                    consultaPreparada.setString(9, student.getNumero_telefono());
                    consultaPreparada.setInt(10, student.getSemestre());
                    consultaPreparada.setInt(11, student.getPromedio());


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
                = conexionDB.prepareStatement("DELETE FROM students WHERE id=?")) {

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
                        "UPDATE students SET nombre=?,apellido=?,edad=?,genero=?,facultad=?,"
                        + " carrera=?,correo_institucional=?,numero_telefono=?,semestre=?,promedio=?"
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, student.getNombre());
            consultaPreparada.setString(2, student.getApellido());
            consultaPreparada.setInt(3, student.getEdad());
            consultaPreparada.setString(4, student.getGenero());
            consultaPreparada.setString(5, student.getFacultad());
            consultaPreparada.setString(6, student.getCarrera());
            consultaPreparada.setString(7, student.getCorreo_istitucional());
            consultaPreparada.setString(8, student.getNumero_telefono());
            consultaPreparada.setInt(10, student.getSemestre());
            consultaPreparada.setInt(11, student.getPromedio());
            consultaPreparada.setInt(12, student.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {

        List<Student> listaStudents = new ArrayList();

        try ( ResultSet resultSetStudents
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM students")) {
                    while (resultSetStudents.next()) {

                        listaStudents.add(new Student(
                                resultSetStudents.getInt("id"),
                                resultSetStudents.getString("nombre"),
                                resultSetStudents.getString("apellido"),
                                resultSetStudents.getInt("edad"),
                                resultSetStudents.getString("genero"),
                                resultSetStudents.getString("facultad"),
                                resultSetStudents.getString("carrera"),
                                resultSetStudents.getString("correo_institucional"),
                                resultSetStudents.getString("numero_telefono"),
                                resultSetStudents.getInt("semestre"),
                                resultSetStudents.getInt("promedio")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaStudents;
    }

}
