
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Administracion;
import mypackage.repositories.interfaces.I_AdministracionRepository;


public class AdministracionRepository implements I_AdministracionRepository {
    
       private Connection conexionDB;

    public AdministracionRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Administracion administracion) {
        if (administracion == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO administracion(id,id_estudiantes,puesto,habilidades)"
                        + "values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, administracion.getId());
                    consultaPreparada.setInt(2, administracion.getId_estudiantes());
                    consultaPreparada.setString(3, administracion.getPuesto());
                    consultaPreparada.setString(4, administracion.getHabilidades());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        administracion.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Administracion administracion) {
        if (administracion == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM administracion WHERE id=?")) {

            consultaPreparada.setInt(1, administracion.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Administracion administracion) {
        if (administracion == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE administracion SET id_estudiantes=?,puesto=?,habilidades=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, administracion.getId_estudiantes());
            consultaPreparada.setString(2, administracion.getPuesto());
            consultaPreparada.setString(3, administracion.getHabilidades());
            consultaPreparada.setInt(4, administracion.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Administracion> getAll() {

        List<Administracion> listaAdministracion = new ArrayList();

        try ( ResultSet resultSetAdministracion
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM administracion")) {
                    while (resultSetAdministracion.next()) {

                        listaAdministracion.add(new Administracion(
                                resultSetAdministracion.getInt("id"),
                                resultSetAdministracion.getInt("id_estudiantes"),
                                resultSetAdministracion.getString("puesto"),
                                resultSetAdministracion.getString("habilidades")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaAdministracion;
    }


}
