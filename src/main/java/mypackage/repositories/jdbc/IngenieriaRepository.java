
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Ingenieria;
import mypackage.repositories.interfaces.I_IngenieriaRepository;


public class IngenieriaRepository implements I_IngenieriaRepository {
    
       private Connection conexionDB;

    public IngenieriaRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Ingenieria ingenieria) {
        if (ingenieria == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO ingenieria(id,matricula_estudiante,nivel,programa)"
                        + "values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, ingenieria.getId());
                    consultaPreparada.setInt(2, ingenieria.getMatricula_estudiante());
                    consultaPreparada.setString(3, ingenieria.getNivel());
                    consultaPreparada.setString(4, ingenieria.getPrograma());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        ingenieria.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Ingenieria ingenieria) {
        if (ingenieria == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM ingenieria WHERE id=?")) {

            consultaPreparada.setInt(1, ingenieria.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Ingenieria ingenieria) {
        if (ingenieria == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE ingenieria SET matricula_estudiante=?,nivel=?,programa=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, ingenieria.getMatricula_estudiante());
            consultaPreparada.setString(2, ingenieria.getNivel());
            consultaPreparada.setString(3, ingenieria.getPrograma());
            consultaPreparada.setInt(4, ingenieria.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Ingenieria> getAll() {

        List<Ingenieria> listaIngenieria = new ArrayList();

        try ( ResultSet resultSetIngenieria
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM ingenieria")) {
                    while (resultSetIngenieria.next()) {

                        listaIngenieria.add(new Ingenieria(
                                resultSetIngenieria.getInt("id"),
                                resultSetIngenieria.getInt("matricula_empleado"),
                                resultSetIngenieria.getString("nivel"),
                                resultSetIngenieria.getString("programa")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaIngenieria;
    }


}
