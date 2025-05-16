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
        try (PreparedStatement consultaPreparada = conexionDB.prepareStatement(
                "INSERT INTO estudiantes(id,matricula,nombre,apellido_primero,apellido_segundo,edad,genero,"
                        + "correo_electronico,numero_telefono,horas_semanales,fecha_inicio,num_clases)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            consultaPreparada.setInt(1, estudiante.getId());
            consultaPreparada.setString(2, estudiante.getMatricula());
            consultaPreparada.setString(3, estudiante.getNombre());
            consultaPreparada.setString(4, estudiante.getApellido_primero());
            consultaPreparada.setString(5, estudiante.getApellido_segundo());
            consultaPreparada.setInt(6, estudiante.getEdad());
            consultaPreparada.setString(7, estudiante.getGenero());
            consultaPreparada.setString(8, estudiante.getCorreo_electronico());
            consultaPreparada.setString(9, estudiante.getNumero_telefono());
            consultaPreparada.setInt(10, estudiante.getHoras_semanales());
            consultaPreparada.setString(11, estudiante.getFecha_inicio());
            consultaPreparada.setInt(12, estudiante.getNum_clsases());

            consultaPreparada.execute();

            ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

            if (resultadoQuery.next()) {
                estudiante.setId(resultadoQuery.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Estudiante estudiante) {
        if (estudiante == null) {
            return;
        }
        try (PreparedStatement consultaPreparada = conexionDB.prepareStatement("DELETE FROM estudiantes WHERE id=?")) {

            consultaPreparada.setInt(1, estudiante.getId());

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
        try (PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE estudiantes SET matricula=?,nombre=?,apellido_primero=?,apellido_segundo=?,edad=?,genero=?,"
                                + "correo_electronico=?,numero_telefono=?,horas_semanales=?,fecha_inicio=?,num_clases=? "
                                + "WHERE id=?")) {

            consultaPreparada.setString(1, estudiante.getMatricula());
            consultaPreparada.setString(2, estudiante.getNombre());
            consultaPreparada.setString(3, estudiante.getApellido_primero());
            consultaPreparada.setString(4, estudiante.getApellido_segundo());
            consultaPreparada.setInt(5, estudiante.getEdad());
            consultaPreparada.setString(6, estudiante.getGenero());
            consultaPreparada.setString(7, estudiante.getCorreo_electronico());
            consultaPreparada.setString(8, estudiante.getNumero_telefono());
            consultaPreparada.setInt(9, estudiante.getHoras_semanales());
            consultaPreparada.setString(10, estudiante.getFecha_inicio());
            consultaPreparada.setInt(11, estudiante.getNum_clsases());
            consultaPreparada.setInt(12, estudiante.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> getAll() {

        List<Estudiante> listaEstudiantes = new ArrayList();

        try (ResultSet resultSetEstudiantes = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM estudiantes")) {
            while (resultSetEstudiantes.next()) {

                listaEstudiantes.add(new Estudiante(
                        resultSetEstudiantes.getInt("id"),
                        resultSetEstudiantes.getString("matricula"),
                        resultSetEstudiantes.getString("nombre"),
                        resultSetEstudiantes.getString("apellido_primero"),
                        resultSetEstudiantes.getString("apellido_segundo"),
                        resultSetEstudiantes.getInt("edad"),
                        resultSetEstudiantes.getString("genero"),
                        resultSetEstudiantes.getString("correo_electronico"),
                        resultSetEstudiantes.getString("numero_telefono"),
                        resultSetEstudiantes.getString("fecha_inicio"),
                        resultSetEstudiantes.getInt("horas_semanales"),
                        resultSetEstudiantes.getInt("num_clases")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEstudiantes;
    }

}
