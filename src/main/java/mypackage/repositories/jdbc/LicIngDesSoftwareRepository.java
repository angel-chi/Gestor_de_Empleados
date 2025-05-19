
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.LicIngDesSoftware;
import mypackage.repositories.interfaces.I_LicIngDesSoftwareRepository;


public class LicIngDesSoftwareRepository implements I_LicIngDesSoftwareRepository {
    
       private Connection conexionDB;

    public LicIngDesSoftwareRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(LicIngDesSoftware licIngDesSoftware) {
        if (licIngDesSoftware == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO licIngDesSoftware(id,id_Estudiantes,semestre,materias_debidas)"
                        + "values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, licIngDesSoftware.getId());
                    consultaPreparada.setInt(2, licIngDesSoftware.getId_Estudiantes());
                    consultaPreparada.setString(3, licIngDesSoftware.getSemestre());
                    consultaPreparada.setString(4, licIngDesSoftware.getMaterias_debidas());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        licIngDesSoftware.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(LicIngDesSoftware licIngDesSoftware) {
        if (licIngDesSoftware == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM licIngDesSoftware WHERE id=?")) {

            consultaPreparada.setInt(1, licIngDesSoftware.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(LicIngDesSoftware licIngDesSoftware) {
        if (licIngDesSoftware == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE licIngDesSoftware SET id_Estudiantes=?,semestre=?,materias_debidas=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, licIngDesSoftware.getId_Estudiantes());
            consultaPreparada.setString(2, licIngDesSoftware.getSemestre());
            consultaPreparada.setString(3, licIngDesSoftware.getMaterias_debidas());
            consultaPreparada.setInt(4, licIngDesSoftware.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<LicIngDesSoftware> getAll() {

        List<LicIngDesSoftware> listalicIngDesSoftware = new ArrayList();

        try ( ResultSet resultSetlicIngDesSoftware
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM licIngDesSoftware")) {
                    while (resultSetlicIngDesSoftware.next()) {

                        listalicIngDesSoftware.add(new LicIngDesSoftware(
                                resultSetlicIngDesSoftware.getInt("id"),
                                resultSetlicIngDesSoftware.getInt("id_Estudiantes"),
                                resultSetlicIngDesSoftware.getString("semestre"),
                                resultSetlicIngDesSoftware.getString("materias_debidas")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listalicIngDesSoftware;
    }


}
