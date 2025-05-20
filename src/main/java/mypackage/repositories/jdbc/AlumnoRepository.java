package mypackage.repositories.jdbc;

import mypackage.entities.Alumno;
import mypackage.repositories.interfaces.I_AlumnoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                        "INSERT INTO alumnos(id,nombre,apellido,edad,genero,curso,"
                        + " matricula,promedio,fecha_ingreso,email)"
                        + "values(?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, alumno.getId());
                    consultaPreparada.setString(2, alumno.getNombre());
                    consultaPreparada.setString(3, alumno.getApellido());
                    consultaPreparada.setInt(4, alumno.getEdad());
                    consultaPreparada.setString(5, alumno.getGenero());
                    consultaPreparada.setString(6, alumno.getCurso());
                    consultaPreparada.setString(7, alumno.getMatricula());
                    consultaPreparada.setDouble(8, alumno.getPromedio());
                    consultaPreparada.setString(9, alumno.getFecha_ingreso());
                    consultaPreparada.setString(10, alumno.getEmail());
//                    consultaPreparada.setInt(11, alumno.getCantidad_hs_semanales());
//                    consultaPreparada.setFloat(12, alumno.getSueldo());

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
                = conexionDB.prepareStatement("DELETE FROM alumnos WHERE id=?")) {

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
                        "UPDATE alumnos SET nombre=?,apellido=?,edad=?,genero=?,matricula=?,"
                        + " promedio=?,fecha_ingreso=?,email=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, alumno.getNombre());
            consultaPreparada.setString(2, alumno.getApellido());
            consultaPreparada.setInt(3, alumno.getEdad());
            consultaPreparada.setString(4, alumno.getGenero());
            consultaPreparada.setString(5, alumno.getCurso());
            consultaPreparada.setString(6, alumno.getMatricula());
            consultaPreparada.setDouble(7, alumno.getPromedio());
            consultaPreparada.setString(8, alumno.getFecha_ingreso());
            consultaPreparada.setString(9, alumno.getEmail());
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
                        .executeQuery("SELECT * FROM alumnos")) {
                    while (resultSetAlumnos.next()) {

                        listaAlumnos.add(new Alumno(
                                resultSetAlumnos.getInt("id"),
                                resultSetAlumnos.getString("nombre"),
                                resultSetAlumnos.getString("apellido"),
                                resultSetAlumnos.getInt("edad"),
                                resultSetAlumnos.getString("genero"),
                                resultSetAlumnos.getString("curso"),
                                resultSetAlumnos.getString("matricula"),
                                resultSetAlumnos.getDouble("promedio"),
                                resultSetAlumnos.getString("fecha_ingreso"),
                                resultSetAlumnos.getString("email")


                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaAlumnos;
    }

}
