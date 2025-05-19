
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Egresado;
import mypackage.repositories.interfaces.I_EgresadoRepository;


public class EgresadoRepository implements I_EgresadoRepository {
    
      private Connection conexionDB;

    public EgresadoRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Egresado Egresado) {
        if (Egresado == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO egresados(id,id_Estudiantes,carrera_estudiada,optativas,año_egreso)"
                        + "values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, Egresado.getId());
                    consultaPreparada.setInt(2, Egresado.getId_Estudiantes());
                    consultaPreparada.setString(3, Egresado.getCarrera_estudiada());
                    consultaPreparada.setString(4, Egresado.getoptativas());
                    consultaPreparada.setInt(5, Egresado.getAño_egreso());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        Egresado.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Egresado Egresado) {
        if (Egresado == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM egresados WHERE id=?")) {

            consultaPreparada.setInt(1, Egresado.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Egresado Egresado) {
        if (Egresado == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE egresados SET id_Estudiantes=?,carrera_estudiada=?,optativas=?,año_egreso=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, Egresado.getId_Estudiantes());
            consultaPreparada.setString(2, Egresado.getCarrera_estudiada());
            consultaPreparada.setString(3, Egresado.getoptativas());
            consultaPreparada.setInt(4, Egresado.getAño_egreso());
            consultaPreparada.setInt(5, Egresado.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Egresado> getAll() {

        List<Egresado> listaegresados = new ArrayList();

        try ( ResultSet resultSetEgresado
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM egresados")) {
                    while (resultSetEgresado.next()) {

                        listaegresados.add(new Egresado(
                                resultSetEgresado.getInt("id"),
                                resultSetEgresado.getInt("id_Estudiantes"),
                                resultSetEgresado.getString("carrera_estudiada"),
                                resultSetEgresado.getString("optativas"),
                                resultSetEgresado.getInt("año_egreso")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaegresados;
    }


}
