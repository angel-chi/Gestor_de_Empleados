package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Empleado;
import mypackage.repositories.interfaces.I_EmpleadoRepository;

public class EmpleadoRepository implements I_EmpleadoRepository {

    private Connection conexionDB;

    public EmpleadoRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Empleado empleado) {
        if (empleado == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO empleados(id,nombre,apellido,edad,genero,tipo_documento,"
                        + " numero_documento,correo_electronico,numero_telefono,fecha_inicio,cantidad_hs_semanales,sueldo)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, empleado.getId());
                    consultaPreparada.setString(2, empleado.getNombre());
                    consultaPreparada.setString(3, empleado.getApellido());
                    consultaPreparada.setInt(4, empleado.getEdad());
                    consultaPreparada.setString(5, empleado.getGenero());
                    consultaPreparada.setString(6, empleado.getTipo_documento());
                    consultaPreparada.setString(7, empleado.getNumero_documento());
                    consultaPreparada.setString(8, empleado.getCorreo_electronico());
                    consultaPreparada.setString(9, empleado.getNumero_telefono());
                    consultaPreparada.setString(10, empleado.getFecha_inicio());
                    consultaPreparada.setInt(11, empleado.getCantidad_hs_semanales());
                    consultaPreparada.setFloat(12, empleado.getSueldo());

                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        empleado.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    @Override
    public void remove(Empleado empleado) {
        if (empleado == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM empleados WHERE id=?")) {

            consultaPreparada.setInt(1, empleado.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Empleado empleado) {
        if (empleado == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE empleados SET nombre=?,apellido=?,edad=?,genero=?,tipo_documento=?,"
                        + " numero_documento=?,correo_electronico=?,numero_telefono=?,fecha_inicio=?,cantidad_hs_semanales=?,sueldo=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, empleado.getNombre());
            consultaPreparada.setString(2, empleado.getApellido());
            consultaPreparada.setInt(3, empleado.getEdad());
            consultaPreparada.setString(4, empleado.getGenero());
            consultaPreparada.setString(5, empleado.getTipo_documento());
            consultaPreparada.setString(6, empleado.getNumero_documento());
            consultaPreparada.setString(7, empleado.getCorreo_electronico());
            consultaPreparada.setString(8, empleado.getNumero_telefono());
            consultaPreparada.setString(9, empleado.getFecha_inicio());
            consultaPreparada.setInt(10, empleado.getCantidad_hs_semanales());
            consultaPreparada.setFloat(11, empleado.getSueldo());
            consultaPreparada.setInt(12, empleado.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Empleado> getAll() {

        List<Empleado> listaEmpleados = new ArrayList();

        try ( ResultSet resultSetEmpleados
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM empleados")) {
                    while (resultSetEmpleados.next()) {

                        listaEmpleados.add(new Empleado(
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
                return listaEmpleados;
    }

}
