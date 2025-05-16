
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mypackage.entities.Quimica;
import mypackage.repositories.interfaces.I_QuimicaRepository;


public class QuimicaRepository implements I_QuimicaRepository {
   
    private Connection conexionDB;

    public QuimicaRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Quimica quimica) {
        if (quimica == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO quimica(id,matricula_empleado,nivel,programa,estatus)"
                        + "values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, quimica.getId());
                    consultaPreparada.setInt(2, quimica.getMatricula_estudiante());
                    consultaPreparada.setString(3, quimica.getNivel());
                    consultaPreparada.setString(4, quimica.getPrograma());
                    consultaPreparada.setString(5, quimica.getEstatus());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        quimica.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Quimica quimica) {
        if (quimica == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM quimica WHERE id=?")) {

            consultaPreparada.setInt(1, quimica.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Quimica quimica) {
        if (quimica == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE quimica SET matricula_estudiante=?,nivel=?,programa=?,estatus=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, quimica.getMatricula_estudiante());
            consultaPreparada.setString(2, quimica.getNivel());
            consultaPreparada.setString(3, quimica.getPrograma());
            consultaPreparada.setString(4, quimica.getEstatus());
            consultaPreparada.setInt(5, quimica.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Quimica> getAll() {

        List<Quimica> listaQuimica = new ArrayList();

        try ( ResultSet resultSetQuimica
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM quimica")) {
                    while (resultSetQuimica.next()) {

                        listaQuimica.add(new Quimica(
                                resultSetQuimica.getInt("id"),
                                resultSetQuimica.getInt("matricula_estudiante"),
                                resultSetQuimica.getString("nivel"),
                                resultSetQuimica.getString("programa"),
                                resultSetQuimica.getString("estatus")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaQuimica;
    }


}
