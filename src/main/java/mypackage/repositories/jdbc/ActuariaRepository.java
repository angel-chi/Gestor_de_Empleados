
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Actuaria;
import mypackage.repositories.interfaces.I_ActuariaRepository;


public class ActuariaRepository implements I_ActuariaRepository {

    
    private Connection conexionDB;

    public ActuariaRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Actuaria Actuaria) {
        if (Actuaria == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO actuarios(id,id_Estudiantes,semestre,materias_libres_cursadas,materias_debidas,creditos_cursados)"
                        + "values(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, Actuaria.getId());
                    consultaPreparada.setInt(2, Actuaria.getId_Estudiantes());
                    consultaPreparada.setString(3, Actuaria.getSemestre());
                    consultaPreparada.setString(4, Actuaria.getMaterias_libres_cursadas());
                    consultaPreparada.setString(5, Actuaria.getMaterias_debidas());
                    consultaPreparada.setInt(6, Actuaria.getCreditos_cursados());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        Actuaria.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
   
      @Override
    public void remove(Actuaria Actuaria) {
        if (Actuaria == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM actuarios WHERE id=?")) {

            consultaPreparada.setInt(1, Actuaria.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void update(Actuaria Actuaria) {
        if (Actuaria == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE actuarios SET id_Estudiantes=?,semestre=?,materias_libres_cursadas=?,materias_debidas=?,creditos_cursados=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, Actuaria.getId_Estudiantes());
            consultaPreparada.setString(2, Actuaria.getSemestre());
            consultaPreparada.setString(3, Actuaria.getMaterias_libres_cursadas());
            consultaPreparada.setString(4, Actuaria.getMaterias_debidas());
            consultaPreparada.setInt(5, Actuaria.getCreditos_cursados());
            consultaPreparada.setInt(6, Actuaria.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<Actuaria> getAll() {

        List<Actuaria> listaactuarios = new ArrayList();

        try ( ResultSet resultSetactuarios
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM actuarios")) {
                    while (resultSetactuarios.next()) {

                        listaactuarios.add(new Actuaria(
                                resultSetactuarios.getInt("id"),
                                resultSetactuarios.getInt("id_Estudiantes"),
                                resultSetactuarios.getString("semestre"),
                                resultSetactuarios.getString("materias_libres_cursadas"),
                                resultSetactuarios.getString("materias_debidas"),
                                resultSetactuarios.getInt("creditos_cursados")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaactuarios;
    }

}
