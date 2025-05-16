
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Gerente;
import mypackage.repositories.interfaces.I_GerenteRepository;


public class GerenteRepository implements I_GerenteRepository {
    
      private Connection conexionDB;

    public GerenteRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Gerente gerente) {
        if (gerente == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO gerentes(id,id_estudiantes,sector,formacion,antiguedad)"
                        + "values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, gerente.getId());
                    consultaPreparada.setInt(2, gerente.getId_estudiantes());
                    consultaPreparada.setString(3, gerente.getSector());
                    consultaPreparada.setString(4, gerente.getFormacion());
                    consultaPreparada.setInt(5, gerente.getAntiguedad());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        gerente.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Gerente gerente) {
        if (gerente == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM gerentes WHERE id=?")) {

            consultaPreparada.setInt(1, gerente.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Gerente gerente) {
        if (gerente == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE gerentes SET id_estudiantes=?,sector=?,formacion=?,antiguedad=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, gerente.getId_estudiantes());
            consultaPreparada.setString(2, gerente.getSector());
            consultaPreparada.setString(3, gerente.getFormacion());
            consultaPreparada.setInt(4, gerente.getAntiguedad());
            consultaPreparada.setInt(5, gerente.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Gerente> getAll() {

        List<Gerente> listaGerentes = new ArrayList();

        try ( ResultSet resultSetGerente
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM gerentes")) {
                    while (resultSetGerente.next()) {

                        listaGerentes.add(new Gerente(
                                resultSetGerente.getInt("id"),
                                resultSetGerente.getInt("id_estudiantes"),
                                resultSetGerente.getString("sector"),
                                resultSetGerente.getString("formacion"),
                                resultSetGerente.getInt("antiguedad")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaGerentes;
    }


}
