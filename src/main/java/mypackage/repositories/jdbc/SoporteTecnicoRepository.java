
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mypackage.entities.SoporteTecnico;
import mypackage.repositories.interfaces.I_SoporteTecnicoRepository;


public class SoporteTecnicoRepository implements I_SoporteTecnicoRepository{
   
    private Connection conexionDB;

    public SoporteTecnicoRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(SoporteTecnico soporteTecnico) {
        if (soporteTecnico == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO soporte_tecnico(id,id_empleados,puesto,formacion,certificaciones)"
                        + "values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, soporteTecnico.getId());
                    consultaPreparada.setInt(2, soporteTecnico.getId_alumnos());
                    consultaPreparada.setString(3, soporteTecnico.getPuesto());
                    consultaPreparada.setString(4, soporteTecnico.getFormacion());
                    consultaPreparada.setString(5, soporteTecnico.getCertificaciones());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        soporteTecnico.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(SoporteTecnico soporteTecnico) {
        if (soporteTecnico == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM soporte_tecnico WHERE id=?")) {

            consultaPreparada.setInt(1, soporteTecnico.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(SoporteTecnico soporteTecnico) {
        if (soporteTecnico == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE soporte_tecnico SET id_empleados=?,puesto=?,formacion=?,certificaciones=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, soporteTecnico.getId_alumnos());
            consultaPreparada.setString(2, soporteTecnico.getPuesto());
            consultaPreparada.setString(3, soporteTecnico.getFormacion());
            consultaPreparada.setString(4, soporteTecnico.getCertificaciones());
            consultaPreparada.setInt(5, soporteTecnico.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<SoporteTecnico> getAll() {

        List<SoporteTecnico> listaSoporteTecnico = new ArrayList();

        try ( ResultSet resultSetSoporteTecnico
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM soporte_tecnico")) {
                    while (resultSetSoporteTecnico.next()) {

                        listaSoporteTecnico.add(new SoporteTecnico(
                                resultSetSoporteTecnico.getInt("id"),
                                resultSetSoporteTecnico.getInt("id_empleados"),
                                resultSetSoporteTecnico.getString("puesto"),
                                resultSetSoporteTecnico.getString("formacion"),
                                resultSetSoporteTecnico.getString("certificaciones")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaSoporteTecnico;
    }


}
