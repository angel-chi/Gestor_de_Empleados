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
                        "INSERT INTO empleados(id,nombre,apellido,edad,genero,tipo_documento,"
                        + " numero_documento,correo_electronico,numero_telefono,fecha_inicio,cantidad_hs_semanales,sueldo)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, estudiante.getId());
                    consultaPreparada.setString(2, estudiante.getNombre());
                    consultaPreparada.setString(3, estudiante.getApellido());
                    consultaPreparada.setInt(4, estudiante.getEdad());
                    consultaPreparada.setString(5, estudiante.getGenero());
                    consultaPreparada.setString(6, estudiante.getTipo_documento());
                    consultaPreparada.setString(7, estudiante.getNumero_documento());
                    consultaPreparada.setString(8, estudiante.getCorreo_electronico());
                    consultaPreparada.setString(9, estudiante.getNumero_telefono());
                    consultaPreparada.setString(10, estudiante.getFecha_inicio());
                    consultaPreparada.setInt(11, estudiante.getCantidad_hs_semanales());
                    consultaPreparada.setFloat(12, estudiante.getSueldo());

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
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM estudiantes WHERE id=?")) {

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
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE empleados SET nombre=?,apellido=?,edad=?,genero=?,tipo_documento=?,"
                        + " numero_documento=?,correo_electronico=?,numero_telefono=?,fecha_inicio=?,cantidad_hs_semanales=?,sueldo=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, estudiante.getNombre());
            consultaPreparada.setString(2, estudiante.getApellido());
            consultaPreparada.setInt(3, estudiante.getEdad());
            consultaPreparada.setString(4, estudiante.getGenero());
            consultaPreparada.setString(5, estudiante.getTipo_documento());
            consultaPreparada.setString(6, estudiante.getNumero_documento());
            consultaPreparada.setString(7, estudiante.getCorreo_electronico());
            consultaPreparada.setString(8, estudiante.getNumero_telefono());
            consultaPreparada.setString(9, estudiante.getFecha_inicio());
            consultaPreparada.setInt(10, estudiante.getCantidad_hs_semanales());
            consultaPreparada.setFloat(11, estudiante.getSueldo());
            consultaPreparada.setInt(12, estudiante.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> getAll() {

        List<Estudiante> listaEstudiantes = new ArrayList();

        try ( ResultSet resultSetEmpleados
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM estudiantes")) {
                    while (resultSetEmpleados.next()) {

                        listaEstudiantes.add(new Estudiante(
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
                return listaEstudiantes;
    }

}
