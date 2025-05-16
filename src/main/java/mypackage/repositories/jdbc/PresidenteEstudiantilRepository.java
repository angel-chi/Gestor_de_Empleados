
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mypackage.repositories.interfaces.I_PresidenteEstudiantilRepository;


public class PresidenteEstudiantilRepository implements I_PresidenteEstudiantilRepository {
    
      private final Connection conexionDB;

    public PresidenteEstudiantilRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(mypackage.entities.PresidenteEstudiantil presidente) {
        if (presidente == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO presidente(id,matricula_estudiante,facultad,periodo,cantidad_proyectos)"
                        + "values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, presidente.getId());
                    consultaPreparada.setInt(2, presidente.getMatricula_estudiante());
                    consultaPreparada.setString(3, presidente.getFacultad());
                    consultaPreparada.setString(4, presidente.getPeriodo());
                    consultaPreparada.setInt(5, presidente.getCantidad_proyectos());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        presidente.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(mypackage.entities.PresidenteEstudiantil presidente) {
        if (presidente == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM presidente WHERE id=?")) {

            consultaPreparada.setInt(1, presidente.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(mypackage.entities.PresidenteEstudiantil presidente) {
        if (presidente == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE presidente SET matricula_estudiante=?,facultad=?,periodo=?,cantidad_proyectos=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, presidente.getMatricula_estudiante());
            consultaPreparada.setString(2, presidente.getFacultad());
            consultaPreparada.setString(3, presidente.getPeriodo());
            consultaPreparada.setInt(4, presidente.getCantidad_proyectos());
            consultaPreparada.setInt(5, presidente.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<mypackage.entities.PresidenteEstudiantil> getAll() {

        List<mypackage.entities.PresidenteEstudiantil> listaPresidenteEstudiantils = new ArrayList();

        try ( ResultSet resultSetPresidenteEstudiantil
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM presidente")) {
                    while (resultSetPresidenteEstudiantil.next()) {

                        listaPresidenteEstudiantils.add(new mypackage.entities.PresidenteEstudiantil(
                                resultSetPresidenteEstudiantil.getInt("id"),
                                resultSetPresidenteEstudiantil.getInt("matricula_estudiante"),
                                resultSetPresidenteEstudiantil.getString("facultad"),
                                resultSetPresidenteEstudiantil.getString("periodo"),
                                resultSetPresidenteEstudiantil.getInt("cantidad_proyectos")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaPresidenteEstudiantils;
    }


}
