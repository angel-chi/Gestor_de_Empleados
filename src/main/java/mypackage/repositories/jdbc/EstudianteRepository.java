package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Estudiante;
import mypackage.repositories.interfaces.I_EstudianteRepository;

public class EstudianteRepository implements I_EstudianteRepository {

    private Connection conexionDB;

    public EstudianteRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Estudiante estudiante) {
        if (estudiante == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO estudiantes(matricula,nombre,apellido,edad,genero,modalidad,"
                        + " tipo_estudiante,correo_electronico,numero_telefono,domicilio,anio_ingreso,promedio_ingreso)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, estudiante.getMatricula());
                    consultaPreparada.setString(2, estudiante.getNombre());
                    consultaPreparada.setString(3, estudiante.getApellido());
                    consultaPreparada.setInt(4, estudiante.getEdad());
                    consultaPreparada.setString(5, estudiante.getGenero());
                    consultaPreparada.setString(6, estudiante.getModalidad());
                    consultaPreparada.setString(7, estudiante.getTipo_estudiante());
                    consultaPreparada.setString(8, estudiante.getCorreo_electronico());
                    consultaPreparada.setString(9, estudiante.getNumero_telefono());
                    consultaPreparada.setString(10, estudiante.getDomicilio());
                    consultaPreparada.setFloat(11, estudiante.getAnio_ingreso());
                    consultaPreparada.setFloat(12, estudiante.getPromedio_ingreso());

                    consultaPreparada.execute();

                    //ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                   // if (resultadoQuery.next()) {
                     //   estudiante.setMatricula(resultadoQuery.getInt(1));
                    //}
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    @Override
    public void remove(Estudiante estudiante) {
        if (estudiante == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM estudiantes WHERE matricula=?")) {

            consultaPreparada.setInt(1, estudiante.getMatricula());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Estudiante estudiante) {
        if (estudiante == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE estudiantes SET nombre=?,apellido=?,edad=?,genero=?,modalidad=?,"
                        + " tipo_estudiante=?,correo_electronico=?,numero_telefono=?,domicilio=?,anio_ingreso=?,promedio_ingreso=? "
                       + "WHERE matricula=?")) {

            consultaPreparada.setString(1, estudiante.getNombre());
            consultaPreparada.setString(2, estudiante.getApellido());
            consultaPreparada.setInt(3, estudiante.getEdad());
            consultaPreparada.setString(4, estudiante.getGenero());
            consultaPreparada.setString(5, estudiante.getModalidad());
            consultaPreparada.setString(6, estudiante.getTipo_estudiante());
            consultaPreparada.setString(7, estudiante.getCorreo_electronico());
            consultaPreparada.setString(8, estudiante.getNumero_telefono());
            consultaPreparada.setString(9, estudiante.getDomicilio());
            consultaPreparada.setFloat(10, estudiante.getAnio_ingreso());
            consultaPreparada.setFloat(11, estudiante.getPromedio_ingreso());
            consultaPreparada.setInt(12, estudiante.getMatricula());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> getAll() {

        List<Estudiante> listaEstudiantes = new ArrayList();

        try ( ResultSet resultSetEstudiantes
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM estudiantes")) {
                    while (resultSetEstudiantes.next()) {

                        listaEstudiantes.add(new Estudiante(
                                resultSetEstudiantes.getInt("matricula"),
                                resultSetEstudiantes.getString("nombre"),
                                resultSetEstudiantes.getString("apellido"),
                                resultSetEstudiantes.getInt("edad"),
                                resultSetEstudiantes.getString("genero"),
                                resultSetEstudiantes.getString("modalidad"),
                                resultSetEstudiantes.getString("tipo_estudiante"),
                                resultSetEstudiantes.getString("correo_electronico"),
                                resultSetEstudiantes.getString("numero_telefono"),
                                resultSetEstudiantes.getString("domicilio"),
                                resultSetEstudiantes.getInt("anio_ingreso"),
                                resultSetEstudiantes.getFloat("promedio_ingreso")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaEstudiantes;
    }

}
