
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Profesores;
import mypackage.repositories.interfaces.I_GerenteRepository;


public class GerenteRepository implements I_GerenteRepository {
    
      private Connection conexionDB;

    public GerenteRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Profesores profesores) {
        if (profesores == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO gerentes(id,id_empleados,sector,formacion,antiguedad)"
                        + "values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, profesores.getId());
                    consultaPreparada.setInt(2, profesores.getId_empleados());
                    consultaPreparada.setString(3, profesores.getPuesto());
                    consultaPreparada.setString(4, profesores.getTitulo());
                    consultaPreparada.setInt(5, profesores.getAntiguedad());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        profesores.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Profesores profesores) {
        if (profesores == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM gerentes WHERE id=?")) {

            consultaPreparada.setInt(1, profesores.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Profesores profesores) {
        if (profesores == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE gerentes SET id_empleados=?,sector=?,formacion=?,antiguedad=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, profesores.getId_empleados());
            consultaPreparada.setString(2, profesores.getPuesto());
            consultaPreparada.setString(3, profesores.getTitulo());
            consultaPreparada.setInt(4, profesores.getAntiguedad());
            consultaPreparada.setInt(5, profesores.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Profesores> getAll() {

        List<Profesores> listaProfesores = new ArrayList();

        try ( ResultSet resultSetGerente
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM gerentes")) {
                    while (resultSetGerente.next()) {

                        listaProfesores.add(new Profesores(
                                resultSetGerente.getInt("id"),
                                resultSetGerente.getInt("id_empleados"),
                                resultSetGerente.getString("sector"),
                                resultSetGerente.getString("formacion"),
                                resultSetGerente.getInt("antiguedad")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaProfesores;
    }


}
