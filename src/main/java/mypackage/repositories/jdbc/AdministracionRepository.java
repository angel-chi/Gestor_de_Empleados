
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Administracion_CE;
import mypackage.repositories.interfaces.I_AdministracionRepository;


public class AdministracionRepository implements I_AdministracionRepository {
    
       private Connection conexionDB;

    public AdministracionRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Administracion_CE administracionCE) {
        if (administracionCE == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO administracion(id,id_empleados,puesto,habilidades)"
                        + "values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, administracionCE.getId());
                    consultaPreparada.setInt(2, administracionCE.getId_empleados());
                    consultaPreparada.setString(3, administracionCE.getPuesto());
                    consultaPreparada.setString(4, administracionCE.getConocimientos());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        administracionCE.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Administracion_CE administracionCE) {
        if (administracionCE == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM administracion WHERE id=?")) {

            consultaPreparada.setInt(1, administracionCE.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Administracion_CE administracionCE) {
        if (administracionCE == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE administracion SET id_empleados=?,puesto=?,habilidades=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, administracionCE.getId_empleados());
            consultaPreparada.setString(2, administracionCE.getPuesto());
            consultaPreparada.setString(3, administracionCE.getConocimientos());
            consultaPreparada.setInt(4, administracionCE.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Administracion_CE> getAll() {

        List<Administracion_CE> listaAdministracionCE = new ArrayList();

        try ( ResultSet resultSetAdministracion
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM administracion")) {
                    while (resultSetAdministracion.next()) {

                        listaAdministracionCE.add(new Administracion_CE(
                                resultSetAdministracion.getInt("id"),
                                resultSetAdministracion.getInt("id_empleados"),
                                resultSetAdministracion.getString("puesto"),
                                resultSetAdministracion.getString("habilidades")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaAdministracionCE;
    }


}
