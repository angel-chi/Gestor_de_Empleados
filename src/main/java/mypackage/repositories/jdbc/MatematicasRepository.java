
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Matematicas;
import mypackage.repositories.interfaces.I_MatematicasRepository;


public class MatematicasRepository implements I_MatematicasRepository {

    
    private Connection conexionDB;

    public MatematicasRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Matematicas matematicas) {
        if (matematicas == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO matematicas(id,matricula_estudiante,nivel,programa,estatus,promedio_actual)"
                        + "values(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, matematicas.getId());
                    consultaPreparada.setInt(2, matematicas.getMatricula_estudiante());
                    consultaPreparada.setString(3, matematicas.getNivel());
                    consultaPreparada.setString(4, matematicas.getPrograma());
                    consultaPreparada.setString(5, matematicas.getEstatus());
                    consultaPreparada.setFloat(6, matematicas.getPromedio_actual());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        matematicas.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
   
      @Override
    public void remove(Matematicas matematicas) {
        if (matematicas == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM matematicas WHERE id=?")) {

            consultaPreparada.setInt(1, matematicas.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void update(Matematicas matematicas) {
        if (matematicas == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE matematicas SET matricula_estudiante=?,nivel=?,programa=?,estatus=?,promedio_actual=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, matematicas.getMatricula_estudiante());
            consultaPreparada.setString(2, matematicas.getNivel());
            consultaPreparada.setString(3, matematicas.getPrograma());
            consultaPreparada.setString(4, matematicas.getEstatus());
            consultaPreparada.setFloat(5, matematicas.getPromedio_actual());
            consultaPreparada.setInt(6, matematicas.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<Matematicas> getAll() {

        List<Matematicas> listaMatematicas = new ArrayList();

        try ( ResultSet resultSetMatematicas
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM matematicas")) {
                    while (resultSetMatematicas.next()) {

                        listaMatematicas.add(new Matematicas(
                                resultSetMatematicas.getInt("id"),
                                resultSetMatematicas.getInt("matricula_estudiante"),
                                resultSetMatematicas.getString("nivel"),
                                resultSetMatematicas.getString("programa"),
                                resultSetMatematicas.getString("estatus"),
                                resultSetMatematicas.getInt("promedio_actual")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaMatematicas;
    }

}
