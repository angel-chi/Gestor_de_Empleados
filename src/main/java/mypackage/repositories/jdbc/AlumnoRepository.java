package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Alumno;
import mypackage.repositories.interfaces.I_AlumnoRepository;

public class AlumnoRepository implements I_AlumnoRepository {

    private Connection conexionDB;

    public AlumnoRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Alumno alumno) {
        if (alumno == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO alumnos(id,nombre,apellido,edad,genero,semestre,"
                        + "correo_electronico,numero_telefono,matricula,promedio)"
                        + "values(?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, alumno.getId());
                    consultaPreparada.setString(2, alumno.getNombre());
                    consultaPreparada.setString(3, alumno.getApellido());
                    consultaPreparada.setInt(4, alumno.getEdad());
                    consultaPreparada.setString(5, alumno.getGenero());
                    consultaPreparada.setString(6, alumno.getSemestre());
                    consultaPreparada.setString(7, alumno.getCorreo_electronico());
                    consultaPreparada.setString(8, alumno.getNumero_telefono());
                    consultaPreparada.setInt(9, alumno.getMatricula());
                    consultaPreparada.setFloat(10, alumno.getPromedio());

                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        alumno.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    @Override
    public void remove(Alumno alumno) {
        if (alumno == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM alumno WHERE id=?")) {

            consultaPreparada.setInt(1, alumno.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Alumno alumno) {
        if (alumno == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE alumnos SET nombre=?,apellido=?,edad=?,genero=?,semestre=?,"
                        + "correo_electronico=?,numero_telefono=?,matricula=?,promedio=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, alumno.getNombre());
            consultaPreparada.setString(2, alumno.getApellido());
            consultaPreparada.setInt(3, alumno.getEdad());
            consultaPreparada.setString(4, alumno.getGenero());
            consultaPreparada.setString(5, alumno.getSemestre());
            consultaPreparada.setString(6, alumno.getCorreo_electronico());
            consultaPreparada.setString(7, alumno.getNumero_telefono());
            consultaPreparada.setInt(8, alumno.getMatricula());
            consultaPreparada.setFloat(9, alumno.getPromedio());
            consultaPreparada.setInt(10, alumno.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Alumno> getAll() {

        List<Alumno> listaAlumnos = new ArrayList();

        try ( ResultSet resultSetAlumnos
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM alumno")) {
                    while (resultSetAlumnos.next()) {

                        listaAlumnos.add(new Alumno(
                                resultSetAlumnos.getInt("id"),
                                resultSetAlumnos.getString("nombre"),
                                resultSetAlumnos.getString("apellido"),
                                resultSetAlumnos.getInt("edad"),
                                resultSetAlumnos.getString("genero"),
                                resultSetAlumnos.getString("semestre"),
                                resultSetAlumnos.getString("correo_electronico"),
                                resultSetAlumnos.getString("numero_telefono"),
                                resultSetAlumnos.getInt("matricula"),
                                resultSetAlumnos.getFloat("promedio")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaAlumnos;
    }

}
