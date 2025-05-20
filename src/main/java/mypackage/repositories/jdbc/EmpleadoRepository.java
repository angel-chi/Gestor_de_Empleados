package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Estudiante;
import mypackage.repositories.interfaces.I_EmpleadoRepository;

public class EmpleadoRepository implements I_EmpleadoRepository {

    private Connection conexionDB;

    public EmpleadoRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Estudiante estudiante) {
        if (estudiante == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO empleados(id,nombre,apellido,edad,genero,correo_electronico,numero_telefono,num_materias,matricula,semestre)"
                        + "values(?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, estudiante.getId());
                    consultaPreparada.setString(2, estudiante.getNombre());
                    consultaPreparada.setString(3, estudiante.getApellido());
                    consultaPreparada.setInt(4, estudiante.getEdad());
                    consultaPreparada.setString(5, estudiante.getGenero());
                    consultaPreparada.setString(6, estudiante.getCorreo_electronico());
                    consultaPreparada.setLong(7, estudiante.getNumero_telefono());
                    consultaPreparada.setInt(8, estudiante.getNum_materias());
                    consultaPreparada.setLong(9, estudiante.getMatricula());
                    consultaPreparada.setFloat(10, estudiante.getSemestre());

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
                = conexionDB.prepareStatement("DELETE FROM empleados WHERE id=?")) {

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
            consultaPreparada.setString(7, estudiante.getCorreo_electronico());
            consultaPreparada.setLong(8, estudiante.getNumero_telefono());
            consultaPreparada.setInt(9, estudiante.getNum_materias());
            consultaPreparada.setLong(10, estudiante.getMatricula());
            consultaPreparada.setFloat(11, estudiante.getSemestre());
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
                        .executeQuery("SELECT * FROM empleados")) {
                    while (resultSetEmpleados.next()) {

                        listaEstudiantes.add(new Estudiante(
                                resultSetEmpleados.getInt("id"),
                                resultSetEmpleados.getString("nombre"),
                                resultSetEmpleados.getString("apellido"),
                                resultSetEmpleados.getInt("edad"),
                                resultSetEmpleados.getString("genero"),
                                resultSetEmpleados.getString("correo_electronico"),
                                resultSetEmpleados.getLong("numero_telefono"),
                                resultSetEmpleados.getInt("num_materias"),
                                resultSetEmpleados.getLong("matricula"),
                                resultSetEmpleados.getInt("semestre")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaEstudiantes;
    }

}
