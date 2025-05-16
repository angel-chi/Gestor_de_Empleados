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

    //explicación de esto
    public EstudianteRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Estudiante estudiante) {
        if (estudiante == null) {
            return;
        }
        try (PreparedStatement consultaPreparada = conexionDB.prepareStatement(
                "INSERT INTO estudiantes(id, nombre, apellido, edad, genero, matricula, "
                        + "semestre, correo_electronico, numero_telefono, fecha_inicio, "
                        + "facultad,hrsclases, gastada) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS)) {

            consultaPreparada.setInt(1, estudiante.getId());
            consultaPreparada.setString(2, estudiante.getNombre());
            consultaPreparada.setString(3, estudiante.getApellido());
            consultaPreparada.setInt(4, estudiante.getEdad());
            consultaPreparada.setString(5, estudiante.getGenero());
            consultaPreparada.setString(6, estudiante.getMatricula());
            consultaPreparada.setString(7, estudiante.getSemestre());
            consultaPreparada.setString(8, estudiante.getCorreo_electronico());
            consultaPreparada.setString(9, estudiante.getNumero_telefono());
            consultaPreparada.setString(10, estudiante.getFecha_inicio());
            consultaPreparada.setString(11, estudiante.getFacultad());
            consultaPreparada.setFloat(12, estudiante.getGastada());

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
        try (PreparedStatement consultaPreparada = conexionDB.prepareStatement(
                "UPDATE estudiantes SET nombre=?, apellido=?, edad=?, genero=?, matricula=?, "
                        + "semestre=?, correo_electronico=?, numero_telefono=?, fecha_inicio=?, "
                        + "facultad=?,hrsclases=?, gastada=? WHERE id=?")) {

            consultaPreparada.setString(1, estudiante.getNombre());
            consultaPreparada.setString(2, estudiante.getApellido());
            consultaPreparada.setInt(3, estudiante.getEdad());
            consultaPreparada.setString(4, estudiante.getGenero());
            consultaPreparada.setString(5, estudiante.getMatricula());
            consultaPreparada.setString(6, estudiante.getSemestre());
            consultaPreparada.setString(7, estudiante.getCorreo_electronico());
            consultaPreparada.setString(8, estudiante.getNumero_telefono());
            consultaPreparada.setString(9, estudiante.getFecha_inicio());
            consultaPreparada.setString(10, estudiante.getFacultad());
            consultaPreparada.setFloat(11, estudiante.getGastada());
            consultaPreparada.setInt(12, estudiante.getId());

            consultaPreparada.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> getAll() {
        List<Estudiante> listaEstudiantes = new ArrayList<>();

        try (ResultSet resultSetEstudiantes = conexionDB.createStatement().executeQuery("SELECT * FROM estudiantes")) {
            while (resultSetEstudiantes.next()) {
                listaEstudiantes.add(new Estudiante(
                        resultSetEstudiantes.getInt("id"),
                        resultSetEstudiantes.getString("nombre"),
                        resultSetEstudiantes.getString("apellido"),
                        resultSetEstudiantes.getInt("edad"),
                        resultSetEstudiantes.getString("genero"),
                        resultSetEstudiantes.getString("matricula"),
                        resultSetEstudiantes.getString("semestre"),
                        resultSetEstudiantes.getString("correo_electronico"),
                        resultSetEstudiantes.getString("numero_telefono"),
                        resultSetEstudiantes.getString("fecha_inicio"),
                        resultSetEstudiantes.getString("facultad"),
                        resultSetEstudiantes.getInt("hrsclases"),
                        resultSetEstudiantes.getFloat("gastada")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEstudiantes;
    }
}
