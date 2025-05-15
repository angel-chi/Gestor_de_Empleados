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
    public void save(Estudiante Estudiante) {
        if (Estudiante == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO Estudiantes(id,nombre,apellido,edad,genero,tipo_documento,"
                        + " numero_documento,correo_electronico,numero_telefono,fecha_inicio,hs_de_clase,calificacion)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, Estudiante.getId());
                    consultaPreparada.setString(2, Estudiante.getNombre());
                    consultaPreparada.setString(3, Estudiante.getApellido());
                    consultaPreparada.setInt(4, Estudiante.getEdad());
                    consultaPreparada.setString(5, Estudiante.getGenero());
                    consultaPreparada.setString(6, Estudiante.getTipo_documento());
                    consultaPreparada.setString(7, Estudiante.getNumero_documento());
                    consultaPreparada.setString(8, Estudiante.getCorreo_electronico());
                    consultaPreparada.setString(9, Estudiante.getNumero_telefono());
                    consultaPreparada.setString(10, Estudiante.getFecha_inicio());
                    consultaPreparada.setInt(11, Estudiante.getHs_de_clase());
                    consultaPreparada.setFloat(12, Estudiante.getCalificacion());

                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        Estudiante.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    @Override
    public void remove(Estudiante Estudiante) {
        if (Estudiante == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM Estudiantes WHERE id=?")) {

            consultaPreparada.setInt(1, Estudiante.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Estudiante Estudiante) {
        if (Estudiante == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE Estudiantes SET nombre=?,apellido=?,edad=?,genero=?,tipo_documento=?,"
                        + " numero_documento=?,correo_electronico=?,numero_telefono=?,fecha_inicio=?,hs_de_clase=?,calificacion=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, Estudiante.getNombre());
            consultaPreparada.setString(2, Estudiante.getApellido());
            consultaPreparada.setInt(3, Estudiante.getEdad());
            consultaPreparada.setString(4, Estudiante.getGenero());
            consultaPreparada.setString(5, Estudiante.getTipo_documento());
            consultaPreparada.setString(6, Estudiante.getNumero_documento());
            consultaPreparada.setString(7, Estudiante.getCorreo_electronico());
            consultaPreparada.setString(8, Estudiante.getNumero_telefono());
            consultaPreparada.setString(9, Estudiante.getFecha_inicio());
            consultaPreparada.setInt(10, Estudiante.getHs_de_clase());
            consultaPreparada.setFloat(11, Estudiante.getCalificacion());
            consultaPreparada.setInt(12, Estudiante.getId());

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
                        .executeQuery("SELECT * FROM Estudiantes")) {
                    while (resultSetEstudiantes.next()) {

                        listaEstudiantes.add(new Estudiante(
                                resultSetEstudiantes.getInt("id"),
                                resultSetEstudiantes.getString("nombre"),
                                resultSetEstudiantes.getString("apellido"),
                                resultSetEstudiantes.getInt("edad"),
                                resultSetEstudiantes.getString("genero"),
                                resultSetEstudiantes.getString("tipo_documento"),
                                resultSetEstudiantes.getString("numero_documento"),
                                resultSetEstudiantes.getString("correo_electronico"),
                                resultSetEstudiantes.getString("numero_telefono"),
                                resultSetEstudiantes.getString("fecha_inicio"),
                                resultSetEstudiantes.getInt("hs_de_clase"),
                                resultSetEstudiantes.getFloat("calificacion")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaEstudiantes;
    }

}
