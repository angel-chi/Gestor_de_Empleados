
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mypackage.entities.LicCienciasComputacion;
import mypackage.repositories.interfaces.I_LicCienciasComputacionRepository;


public class LicCienciasComputacionRepository implements I_LicCienciasComputacionRepository{
   
    private Connection conexionDB;

    public LicCienciasComputacionRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(LicCienciasComputacion LicCienciasComputacion) {
        if (LicCienciasComputacion == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO lic_ciencias_computacion(id,id_Estudiantes,semestre,optativas,materias_libres_cursadas)"
                        + "values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, LicCienciasComputacion.getId());
                    consultaPreparada.setInt(2, LicCienciasComputacion.getId_Estudiantes());
                    consultaPreparada.setString(3, LicCienciasComputacion.getSemestre());
                    consultaPreparada.setString(4, LicCienciasComputacion.getoptativas());
                    consultaPreparada.setString(5, LicCienciasComputacion.getMaterias_libres_cursadas());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        LicCienciasComputacion.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(LicCienciasComputacion LicCienciasComputacion) {
        if (LicCienciasComputacion == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM lic_ciencias_computacion WHERE id=?")) {

            consultaPreparada.setInt(1, LicCienciasComputacion.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(LicCienciasComputacion LicCienciasComputacion) {
        if (LicCienciasComputacion == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE lic_ciencias_computacion SET id_Estudiantes=?,semestre=?,optativas=?,materias_libres_cursadas=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, LicCienciasComputacion.getId_Estudiantes());
            consultaPreparada.setString(2, LicCienciasComputacion.getSemestre());
            consultaPreparada.setString(3, LicCienciasComputacion.getoptativas());
            consultaPreparada.setString(4, LicCienciasComputacion.getMaterias_libres_cursadas());
            consultaPreparada.setInt(5, LicCienciasComputacion.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<LicCienciasComputacion> getAll() {

        List<LicCienciasComputacion> listaLicCienciasComputacion = new ArrayList();

        try ( ResultSet resultSetLicCienciasComputacion
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM lic_ciencias_computacion")) {
                    while (resultSetLicCienciasComputacion.next()) {

                        listaLicCienciasComputacion.add(new LicCienciasComputacion(
                                resultSetLicCienciasComputacion.getInt("id"),
                                resultSetLicCienciasComputacion.getInt("id_Estudiantes"),
                                resultSetLicCienciasComputacion.getString("semestre"),
                                resultSetLicCienciasComputacion.getString("optativas"),
                                resultSetLicCienciasComputacion.getString("materias_libres_cursadas")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaLicCienciasComputacion;
    }


}
